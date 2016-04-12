package br.com.etorcedor.persistence;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Estadio;
import java.util.Date;

/**
 * 
 * @author layon
 *
 */
public interface RepositorioJogo extends CrudRepository<Jogo, Long> {
	
	/**
	 * Recupera uma lista de Jogos em um determinada Data.
	 * @param data
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByData(Date data);
	
	/**
	 * Recupera uma lista de Jogos em um determinada Data,
	 * ordenado de forma ascendente por data.
	 * @param data
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByDataOrderByDataAsc(Date data);
	
	/**
	 * Recupera uma lista de Jogos em um determinada Data,
	 * ordenado de forma descendente por data.
	 * @param data
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByDataOrderByDataDesc(Date data);
	
	/**
	 * Recupera uma lista de Jogos em um estadio.
	 * @param estadio
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByEstadio(Estadio estadio);
	
	/**
	 * Recupera uma lista de Jogos em um estadio,
	 * ordenado de forma ascendente por data.
	 * @param estadio
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByEstadioOrderByDataAsc(Estadio estadio);

	/**
	 * Recupera uma lista de Jogos em um estadio,
	 * ordenado de forma descendente por data.
	 * @param estadio
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByEstadioOrderByDataDesc(Estadio estadio);
	
	//Falta a consulta por times !!!!
	//Ver com Thiago como faz
}