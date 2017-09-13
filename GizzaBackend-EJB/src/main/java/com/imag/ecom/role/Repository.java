package com.imag.ecom.role;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "RoleRepository")
@LocalBean
public class Repository implements RepositoryLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public Repository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Role add(Role r) {
		em.persist(r);
		return r;
	}

	@Override
	public Role update(Role r) {
		em.merge(r);
		return r;
	}

	@Override
	public void delete(Long id) {
		Role r = getByID(id);
		em.remove(r);

	}

	@Override
	public Role getByID(Long id) {
		Role r = em.find(Role.class, id);
		return r;
	}

	@Override
	public Role getByName(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Role> criteria = cb.createQuery(Role.class);
		Root<Role> role = criteria.from(Role.class);
		criteria.select(role).where(cb.equal(role.get("libelle"), name));
		return em.createQuery(criteria).getSingleResult();
	}

}
