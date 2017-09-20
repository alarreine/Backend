package com.imag.ecom.api.pizza;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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

import com.imag.ecom.categorie.Categorie;
import com.imag.ecom.produit.pizza.Pizza;
import com.imag.ecom.produit.pizza.PizzaRepository;
import com.imag.ecom.security.Secured;
import com.imag.ecom.shared.Role;

@Path("/pizza")
@RequestScoped
public class PizzaApi {

	@Inject
	private PizzaRepository repository;
	@Inject
	com.imag.ecom.categorie.CategorieRepository categorieRepository;

	@POST
	@Secured({ Role.ADMIN })
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Pizza add(@FormParam(value = "id_categorie") Long id_categorie, @FormParam(value = "nom") String nom,
			@FormParam(value = "description") String description, @FormParam(value = "prix") double prix,
			@FormParam(value = "url") String url) {
		Categorie c = categorieRepository.find(id_categorie);
		if (c == null) {
			return null;
		}
		Pizza p = new Pizza();
		p.setCategorie(c);
		p.setNom(nom);
		p.setPrix(prix);
		p.setDescription(description);
		p.setUrl(url);

		return repository.create(p);
	}

	@DELETE
	@Path("/delete/{id}")
	public void delete(@PathParam(value = "id") Long id) {
		repository.remove(repository.find(id));
	}

	@GET
	@Secured({ Role.ADMIN, Role.USER })
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> getAll() {
		return repository.findAll();
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pizza getByID(@PathParam(value = "id") Long id) {
		return repository.find(id);
	}

	@GET
	@Path("/get/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pizza getByName(@PathParam(value = "nom") String name) {
		return repository.getByName(name);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pizza update(Pizza p) {
		return repository.update(p);
	}

}
