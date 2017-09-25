package com.imag.ecom.api.pizza;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import javax.ws.rs.core.Response;

import com.imag.ecom.categorie.Categorie;
import com.imag.ecom.categorie.CategorieRepository;
import com.imag.ecom.produit.pizza.Pizza;
import com.imag.ecom.produit.pizza.PizzaRepository;
import com.imag.ecom.security.Secured;
import com.imag.ecom.shared.Log;
import com.imag.ecom.shared.Role;

@Path("/pizza")
@RequestScoped
public class PizzaApi {

	@Inject
	private PizzaRepository repository;
	@Inject
	private CategorieRepository categorieRepository;
	@Inject
	private Log logger;

	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Map<String, List<Pizza>> res = new HashMap<>();
		List<Pizza> pizzas = repository.findAll();
		res.put("data", pizzas);
		return Response.ok(res, MediaType.APPLICATION_JSON_TYPE).build();
	}

	@GET
	@Path("/get/by/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pizza getByID(@PathParam(value = "id") Long id) {
		return repository.find(id);
	}

	@GET
	@Path("/get/by/name/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pizza getByName(@PathParam(value = "nom") String name) {
		return repository.getByName(name);
	}

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
		logger.logInfo("The pizza "+p.toString()+ "has been created");
		return repository.create(p);
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
	public Pizza update(Pizza p) {
		logger.logInfo("The pizza "+p.toString()+ "has been updated");
		return repository.update(p);
	}

}
