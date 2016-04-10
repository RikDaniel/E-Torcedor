package br.com.etorcedor.persistence;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import br.com.etorcedor.entity.Time;

/**
 * Define todos os métodos necessários para o repositório de Time.
 * @author layon
 *
 */
public interface RepositorioTime extends CrudRepository<Time, Long> {
	
	/**
	 * Recupera um time pelo seu nome.
	 * @param nome
	 * @return uma entidade do tipo Time.
	 */
	public Time findByNome(String nome);
	
	/**
	 * Recupera uma lista de times, começando com um nome.
	 * @param nome
	 * @return uma List do tipo Time.
	 */
	public List<Time> findByNomeStartingWith(String nome);
	
	/*
	 * Não sei se esse metodo funciona, Verificar com o Prof Thiago
	 * public List<Time> findByNomeStartingWithOrderByNomeAsc(String nome);
	 */
	
	
	/**
	 * Recupera uma Lista de time contendo um nome.
	 * @param nome
	 * @return uma List do tipo Time.
	 */
	public List<Time> findByNomeContaining(String nome);
	
}
