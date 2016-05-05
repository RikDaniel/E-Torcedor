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
	 * Recupera uma lista de Jogos em um estadio.
	 * @param estadio
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByEstadio(Estadio estadio);
}