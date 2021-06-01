/**
 * 
 */
package br.com.bank.service;

import java.util.List;

import br.com.bank.model.Contato;

/**
 * @author cbgomes
 *
 */
public interface ContatoService {
	
	void salvar(Contato contato);
	
	public Contato getContatoById(Long id);
	
	public boolean update(Contato contao);
	
	List<Contato> list();

}
