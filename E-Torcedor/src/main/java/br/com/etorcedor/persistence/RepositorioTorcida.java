package br.com.etorcedor.persistence;

import org.springframework.data.repository.CrudRepository;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import java.util.List;

/**
 * Define todos os métodos necessários para o repositório da entidade Torcida.
 * @author layon
 *
 */
public interface RepositorioTorcida extends CrudRepository<Torcida, Long> {
	
	/**
	 * Recupera uma torcidas pelo seu nome. 
	 * @param nome
	 * @return uma entidade do tipo Torcida
	 */
	public Torcida findByNome(String nome);
	
	/**
	 * Recupera todas as torcidas contendo um nome. 
	 * @param nome
	 * @return uma coleção do tipo List de Torcida
	 */
	public List<Torcida> findByNomeContaining(String nome);
	
	/**
	 * Recupera todas as torcidas começando com um nome. 
	 * @param nome
	 * @return uma coleção do tipo List de Torcida
	 */
	public List<Torcida> findByNomeStartingWith(String nome);
	
	/**
	 * Recupera todas as torcidas pelo seu nome, ordenado de forma ascendente,
	 * usando o nome como critério.
	 * @param nome
	 * @return uma coleção de Torcida do tipo List
	 */
	public List<Torcida> findByNomeOrderByNomeAsc(String nome);
	
	/**
	 * Recupera todas as torcidas pelo seu nome, ordenado de forma descendente,
	 * usando o nome como critério.
	 * @param nome
	 * @return uma coleção de Torcida do tipo List 
	 */
	public List<Torcida> findByNomeOrderByNomeDesc(String nome);
	
	/**
	 * Recupera todas as torcida pelo Time
	 * @param time
	 * @return uma coleção de Torcida do tipo List
	 */
	public List<Torcida> findByTime(Time time);
	
	/**
	 * Recupera todas as torcida pelo Time, ordenando de forma ascendente,
	 * utilizando o nome da torcida como critério.
	 * @param time
	 * @return
	 */
	public List<Torcida> findByTimeOrderByNomeAsc(Time time);
	
	/**
	 * Recupera todas as torcida pelo Time, ordenando de forma descendente,
	 * utilizando o nome da torcida como critério.
	 * @param time
	 * @return
	 */
	public List<Torcida> findByTimeOrderByNomeDesc(Time time);
}
