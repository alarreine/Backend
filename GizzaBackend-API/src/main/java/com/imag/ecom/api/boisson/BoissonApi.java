package com.imag.ecom.api.boisson;

import java.util.List;

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

import com.imag.ecom.produit.boisson.Boisson;
import com.imag.ecom.produit.boisson.BoissonRepository;
import com.imag.ecom.security.Secured;
import com.imag.ecom.shared.Role;

@Path("/boisson")
@RequestScoped
public class BoissonApi {

	@Inject
	private BoissonRepository repository;

	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Boisson> getAll() {
		return repository.findAll();
	}

	@GET
	@Path("/get/by/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boisson getByID(@PathParam(value = "id") Long id) {
		return repository.find(id);
	}

	@GET
	@Path("/get/by/name/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boisson getByName(@PathParam(value = "nom") String name) {
		return repository.getByName(name);
	} 
	
	@POST
	@Secured({ Role.ADMIN })
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Boisson add(Boisson b) {
		return repository.create(b);
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
	public Boisson update(Boisson p) {
		return repository.update(p);
	}

}
