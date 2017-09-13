package com.imag.ecom.api.role;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.imag.ecom.role.Repository;
import com.imag.ecom.role.Role;

@Path("/role")
@RequestScoped
public class RestService {
	@Inject
	private Repository repository;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Role add(Role r) {
		return repository.add(r);
	}

	@DELETE
	@Path("/delete/{id}")
	public void delete(@PathParam(value = "id") Long id) {
		repository.delete(id);
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Role getByID(@PathParam(value = "id") Long id) {
		return repository.getByID(id);
	}

	@GET
	@Path("/get/by/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Role getByName(@PathParam(value = "nom") String name) {
		return repository.getByName(name);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Role update(Role r) {
		return repository.update(r);
	}

}
