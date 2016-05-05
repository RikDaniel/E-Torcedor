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
	 * Recupera todas as torcida pelo Time
	 * @param time
	 * @return uma coleção de Torcida do tipo List
	 */
	public List<Torcida> findByTime(Time time);
}