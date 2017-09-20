package com.imag.ecom;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class EntryPoint extends Application {

	// @Override
	// public Set<Class<?>> getClasses() {
	// Set<Class<?>> clazzes = new HashSet();
	// clazzes.add(JWTAuthFilter.class);
	//// clazzes.add(BooksResource.class);
	// clazzes.add(AuthResource.class);
	// clazzes.add(RestService.class);
	// clazzes.add(JWTResponseFilter.class);
	//
	// return clazzes;
	// }
}
