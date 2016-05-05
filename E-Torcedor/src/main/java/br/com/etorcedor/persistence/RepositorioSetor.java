package br.com.etorcedor.persistence;

import org.springframework.data.repository.CrudRepository;
import br.com.etorcedor.entity.Setor;

/**
 * 
 * @author layon
 *
 */
public interface RepositorioSetor extends CrudRepository<Setor, Long> {
	
	/**
	 * Recupera um setor pelo seu nome.
	 * @param nome
	 * @return Uma entidade do tipo Setor.
	 */
	public Setor findByNome(String nome);
	
}
