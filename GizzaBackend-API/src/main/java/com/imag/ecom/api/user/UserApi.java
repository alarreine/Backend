package com.imag.ecom.api.user;

import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.imag.ecom.user.UserRepository;
import com.imag.ecom.security.Secured;
import com.imag.ecom.security.TokenServices;
import com.imag.ecom.shared.Role;
import com.imag.ecom.user.User;

@Path("/user")
@RequestScoped
public class UserApi {
	@Inject
	private UserRepository repository;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User add(@FormParam(value = "email") String email, @FormParam(value = "password") String password,
			@FormParam(value = "nom") String nom, @FormParam("prenom") String prenom,
			@FormParam(value = "adresse") String adresse, @FormParam(value = "telephone") String telephone) {
		User u = new User();
		u.setPassword(password);
		u.setAdresse(adresse);
		u.setEmail(email);
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setTelephone(telephone);
		u.setRole(Role.USER);
		return repository.create(u);
	}

	@DELETE
	@Secured({ Role.ADMIN })
	@Path("/delete/{id}")
	public void delete(@PathParam(value = "id") Long id) {
		repository.remove(repository.find(id));
	}

	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll() {
		return repository.findAll();
	}

	@GET
	@Path("/get/by/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getByID(@PathParam(value = "id") Long id) {
		return repository.find(id);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User update(User u) {
		return repository.update(u);
	}

	@POST
	@Path("/auth")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password) {
		String role = repository.login(username, password);
//		User u = repository.logedUser(username, password);
//		String user = new Gson().toJson(u);

		if (role != null) {
			return Response.ok(Json.createObjectBuilder().add("token", createToken(username, role)).build(),
					MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	private String createToken(String username, String role) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, 3);
		return TokenServices.createToken(username, role, cal.getTimeInMillis());
	}

	@POST
	@Secured({ Role.ADMIN })
	@Path("admin/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User addAdmin(@FormParam(value = "email") String email, @FormParam(value = "password") String password,
			@FormParam(value = "nom") String nom, @FormParam("prenom") String prenom) {
		User u = new User();
		u.setPassword(password);
		u.setEmail(email);
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setRole(Role.ADMIN);
		return repository.create(u);
	}

}