package com.imag.ecom.user;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.imag.ecom.shared.Repository;
import com.imag.ecom.shared.Role;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "UserRepository")
@LocalBean
public class UserRepository extends Repository<User> {

	/**
	 * Default constructor.
	 */
	public UserRepository() {
		super(User.class);
	}

	public String login(String username, String password) {
		TypedQuery<Role> loginQuery = super.getEntityManager().createNamedQuery("User.role", Role.class);
		loginQuery.setParameter("username", username);
		loginQuery.setParameter("password", hashPassword(password.toCharArray()));

		try {
			String role = loginQuery.getSingleResult().toString();
			return role;
		} catch (Exception e) {
			return null;
		}
	}

	public String hashPassword(final char[] password) {
		try {
			byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512").generateSecret(
					new PBEKeySpec(password, "SaltPasswordHere".getBytes(), 33/* iteration */, 256/* key length */))
					.getEncoded();
			return Base64.getEncoder().encodeToString(result);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			throw new RuntimeException(ex);
		}
	}

	public User logedUser(String username, String password) {
		TypedQuery<User> loginQuery = super.getEntityManager().createNamedQuery("User.get", User.class);
		loginQuery.setParameter("username", username);
		loginQuery.setParameter("password", hashPassword(password.toCharArray()));
		User u;
		try {
			u = loginQuery.getSingleResult();
			return u;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean registerNewUser() {
		boolean success = false;
		if (!success) {
			User u = new User();
			u.setEmail("admin@imag.fr");
			u.setPassword(hashPassword("admin".toCharArray()));
			u.setRole(Role.ADMIN);
			User uu = new User();
			uu.setEmail("user@imag.fr");
			uu.setPassword(hashPassword("user".toCharArray()));
			uu.setRole(Role.USER);
			super.create(u);
			super.create(uu);
			success = !success;
			return success;
		}
		return success;
	}

}
