package br.com.bank.dao;

import java.util.List;

import br.com.bank.model.Contato;

public interface ContatoDao {

	void salvar(Contato contato);
	void update(Contato contato);
	public Contato getContatoById(Long id);
	
	List<Contato> list();
}
