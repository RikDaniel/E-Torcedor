package br.com.etorcedor.persistence;

import org.springframework.data.repository.CrudRepository;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import java.util.List;
import java.util.Date;

/**
 * 
 * @author layon
 *
 */
public interface RepositorioIngresso extends CrudRepository<Ingresso, Long> {

	/**
	 * Recupera todos os ingressos de um determinado jogo.
	 * 
	 * @param jogo
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByJogo(Jogo jogo);

	/**
	 * Recupera todos os ingressos de uma data.
	 * 
	 * @param data
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByData(Date data);

	/**
	 * Recupera todos os ingressos pelo numero do acento.
	 * 
	 * @param numeroAcento
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByNumeroAcento(int numeroAcento);
}