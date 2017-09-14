package com.imag.ecom.api.commande;

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

import com.imag.ecom.commande.Commande;
import com.imag.ecom.commande.Repository;

@Path("/commande")
@RequestScoped
public class RestService {
	
	@Inject
	private Repository repository;

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Commande add(Commande c) {
		return repository.add(c);
	}

	@DELETE
	@Path("/delete/{id}")
	public void delete(@PathParam(value = "id") Long id) {
		repository.delete(id);
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Commande> getAll() {
		return repository.getAll();
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Commande getByID(@PathParam(value = "id") Long id) {
		return repository.getByID(id);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Commande update(Commande c) {
		return repository.update(c);
	}


}
