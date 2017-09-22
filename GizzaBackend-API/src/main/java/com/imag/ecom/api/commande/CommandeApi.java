package com.imag.ecom.api.commande;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.imag.ecom.commande.Commande;
import com.imag.ecom.commande.CommandeRepository;
import com.imag.ecom.commande.ItemCommande;
import com.imag.ecom.commande.ItemsCommandes;
import com.imag.ecom.produit.Produit;
import com.imag.ecom.produit.ProduitCommande;
import com.imag.ecom.produit.ProduitCommandeRepository;
import com.imag.ecom.produit.ProduitRepository;
import com.imag.ecom.security.Secured;
import com.imag.ecom.security.TokenServices;
import com.imag.ecom.shared.Role;
import com.imag.ecom.user.UserRepository;

@Path("/commande")
@RequestScoped
public class CommandeApi {

	@Inject
	private CommandeRepository repository;
	@Inject
	private ProduitRepository produitRp;
	@Inject
	private ProduitCommandeRepository produitCommandeRp;
	@Inject
	private UserRepository userRp;

	@POST
	@Secured({ Role.USER, Role.ADMIN })
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Commande add(@HeaderParam("Authorization") String token, ItemsCommandes c) {
		Commande commande = new Commande();
		repository.create(commande);
		if (c != null) {
			commande.setDate(new Date());
			for (ItemCommande ic : c.getData()) {
				ProduitCommande pc = new ProduitCommande();
				Produit produit = produitRp.find(ic.getIdProduit());
				produitCommandeRp.create(pc);
				pc.setCommande(commande);
				pc.setProduit(produit);
				pc.setQuantite(ic.getQuantite());
				commande.addProduitCommande(pc);
				produit.addProduitCommande(pc);
				// **********************************

				// ************************************
				produitCommandeRp.update(pc);
				produitRp.update(produit);

			}
			commande.setUser(userRp.find(TokenServices.getUsername(token)));
		}

		return repository.update(commande);

	}

	@DELETE
	@Secured({ Role.ADMIN })
	@Path("/delete/{id}")
	public void delete(@PathParam(value = "id") Long id) {
		repository.remove(repository.find(id));
	}

	@GET
	@Secured({ Role.ADMIN })
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Map<String, List<Commande>> res = new HashMap<>();
		res.put("data", repository.findAll());
		return Response.ok(res, MediaType.APPLICATION_JSON_TYPE).build();
	}

	@GET
	@Secured({ Role.ADMIN })
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Commande getByID(@PathParam(value = "id") Long id) {
		return repository.find(id);
	}

	@PUT
	@Secured({ Role.ADMIN })
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Commande update(Commande c) {
		return repository.update(c);
	}

}
