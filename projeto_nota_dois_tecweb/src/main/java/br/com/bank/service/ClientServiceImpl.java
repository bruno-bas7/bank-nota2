/**
 * 
 */
package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.ClientDaoImpl;
import br.com.bank.model.Client;

/**
 * @author cbgomes
 *
 */
public class ClientServiceImpl implements ClientService {

	private ClientDaoImpl dao;

	public ClientServiceImpl() {
		this.dao = new ClientDaoImpl();
	}

	@Override
	public Client getClient(String email, String senha) {
		return this.dao.getClient(email, senha);
	}

	@Override
	public List<Client> getAll() {
		return this.dao.getAll();
	}

	@Override
	public boolean save(Client client) {

		return this.dao.save(client);
	}

	@Override
	public Boolean deleteById(Long idClient) {
		if (this.dao.deleteById(idClient)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Client getClientById(Long id) {

		return dao.getClientById(id);
	}

	@Override
	public boolean update(Client client) {
		return dao.updade(client);
	}

}
