
package com.imag.ecom.security;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.imag.ecom.shared.Log;
import com.imag.ecom.shared.Role;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Secured
@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	@Inject
	private Log logger;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			logger.logInfo("Access UNAUTHORIZED from " + requestContext.getHeaderString("X-Real-IP")+" without sesion");
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			return;
		}
		String token = authorizationHeader.substring("Bearer".length()).trim();

		try {
			Role userRole = Role.valueOf(TokenServices.validateToken(token));

			List<Role> classRoles = extractRoles(resourceInfo.getResourceClass());
			List<Role> methodRoles = extractRoles(resourceInfo.getResourceMethod());

			if (methodRoles.size() > 0) {
				if (!methodRoles.contains(userRole)) {
					logger.logInfo("Access FORBIDDEN from " + requestContext.getHeaderString("X-Real-IP"));
					requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
				}
			}
			if (classRoles.size() > 0) {
				if (!classRoles.contains(userRole)) {
					
					logger.logInfo("Access FORBIDDEN from " + requestContext.getHeaderString("X-Real-IP") +"USER:"+TokenServices.getUsername(token));
					requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
				}
			}
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException e) {
			logger.logInfo("Access UNAUTHORIZED from " + requestContext.getHeaderString("X-Real-IP") +"USER:"+TokenServices.getUsername(token));
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}

	}

	private List<Role> extractRoles(AnnotatedElement annotatedElement) {
		List<Role> roles = new ArrayList<>();
		if (annotatedElement == null) {
			return roles;
		} else {
			Secured secured = annotatedElement.getAnnotation(Secured.class);
			if (secured == null) {
				return roles;
			} else {
				Role[] allowedRoles = secured.value();
				return Arrays.asList(allowedRoles);
			}
		}
	}

}
