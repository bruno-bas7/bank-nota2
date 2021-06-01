/**
 * 
 */
package br.com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.bank.model.Contato;
import br.com.bank.util.JPAUtil;

/**
 * @author cbgomes
 *
 */
public class ContatoDaoImpl implements ContatoDao {

	@Override
	public void salvar(Contato contato) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		try {

			entityManager.persist(contato);
			entityManager.getTransaction().commit();
			entityManager.close();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public List<Contato> list() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("SELECT c FROM Contato c");
		List<Contato> contatos = query.getResultList();
		return contatos;
		
	}

	@Override
	public void update(Contato contato) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.merge(contato);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
	}

	@Override
	public Contato getContatoById(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {

			Contato contato = entityManager.find(Contato.class, id);
			return contato;

		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}

		return null;
	}

}









