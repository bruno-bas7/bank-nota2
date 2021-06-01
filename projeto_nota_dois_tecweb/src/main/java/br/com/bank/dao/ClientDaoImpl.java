/**
 * 
 */
package br.com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.bank.model.Client;
import br.com.bank.util.JPAUtil;

/**
 * @author cbgomes
 *
 */
public class ClientDaoImpl implements ClientDao {

	@Override
	public Client getClient(String email, String senha) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {

			Client client = entityManager.createNamedQuery("Client.getByName", Client.class)
					.setParameter("email", email).setParameter("senha", senha).getSingleResult();

			return client;

		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}

		return null;
	}

	@Override
	public List<Client> getAll() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {
			List<Client> client = entityManager.createNamedQuery("Client.getAll", Client.class).getResultList();
			return client;
		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
			return null;
		}
	}

	@Override
	public boolean save(Client client) {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		
			List<Client> clientList = null;
			clientList = getAll();

			try {

				for (Client clientConf : clientList) {
					if (clientConf.getEmail().contains(client.getEmail())
							|| client.getPhone().contains(clientConf.getPhone())) {
						return false;
					}
				}
				entityManager.persist(client);
				entityManager.getTransaction().commit();
				entityManager.close();
				return true;

			} catch (Exception e) {
				e.getMessage();
			}
		
		return false;

	}

	@Override
	public Boolean deleteById(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		Client client = entityManager.find(Client.class, id);

		try {
			entityManager.getTransaction().begin();
			entityManager.remove(client);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}

	}

	@Override
	public Client getClientById(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {

			Client client = entityManager.find(Client.class, id);
			return client;

		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}

		return null;
	}

	@Override
	public boolean updade(Client client) {


		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.merge(client);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
		return true;
	}

}
