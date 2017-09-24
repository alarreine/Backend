package com.imag.ecom.api.dessert;

import com.imag.ecom.produit.dessert.Dessert;
import com.imag.ecom.produit.dessert.DessertRepository;
import com.imag.ecom.security.Secured;
import com.imag.ecom.shared.Role;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/dessert")
@RequestScoped
public class DessertApi {

	@Inject
	private DessertRepository repository;

	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Map<String, List<Dessert>> res = new HashMap<>();
		res.put("data", repository.findAll());
		return Response.ok(res, MediaType.APPLICATION_JSON_TYPE).build();
	}

	@GET
	@Path("/get/by/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Dessert getByID(@PathParam(value = "id") Long id) {
		return repository.find(id);
	}

	@GET
	@Path("/get/by/name/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Dessert getByName(@PathParam(value = "nom") String name) {
		return repository.getByName(name);
	}

	@POST
	@Secured({ Role.ADMIN })
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Dessert add(Dessert d) {
		return repository.create(d);
	}

	@DELETE
	@Secured({ Role.ADMIN })
	@Path("/delete/{id}")
	public void delete(@PathParam(value = "id") Long id) {
		repository.remove(repository.find(id));
	}

	@PUT
	@Secured({ Role.ADMIN })
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Dessert update(Dessert d) {
		return repository.update(d);
	}

}
