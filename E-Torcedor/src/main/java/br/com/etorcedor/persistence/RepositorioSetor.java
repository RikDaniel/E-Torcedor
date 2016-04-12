package br.com.etorcedor.persistence;

import org.springframework.data.repository.CrudRepository;
import br.com.etorcedor.entity.Setor;
import java.util.List;

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
	
	/**
	 * Recupera uma lista de Setor começando pelo nome.
	 * @param nome
	 * @return Uma coleção do tipo List de Setor.
	 */
	public List<Setor> findByNomeStartingWith(String nome);
	
	/**
	 * Resupera um setor contendo um determinado nome.
	 * @param nome
	 * @return Uma coleção do tipo List de Setor.
	 */
	public List<Setor> findByNomeContaining(String nome);
	
}
