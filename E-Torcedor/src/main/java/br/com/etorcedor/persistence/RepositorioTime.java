package br.com.etorcedor.persistence;

import org.springframework.data.repository.CrudRepository;
import br.com.etorcedor.entity.Time;

/**
 * Define todos os métodos necessários para o repositório de Time.
 * 
 * @author layon
 *
 */
public interface RepositorioTime extends CrudRepository<Time, Long> {

	/**
	 * Recupera um time pelo seu nome.
	 * 
	 * @param nome
	 * @return uma entidade do tipo Time.
	 */
	public Time findByNome(String nome);

}
