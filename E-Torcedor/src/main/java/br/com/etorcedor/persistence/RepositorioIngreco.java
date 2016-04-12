package br.com.etorcedor.persistence;

import org.springframework.data.repository.CrudRepository;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Setor;
import java.util.List;
import java.util.Date;

/**
 * 
 * @author layon
 *
 */
public interface RepositorioIngreco extends CrudRepository<Ingresso, Long>{

	/**
	 * Recupera todos os ingressos de um determinado jogo.
	 * @param jogo
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByJogo(Jogo jogo);
	
	/**
	 * Recupera todos os ingressos de uma data.
	 * @param data
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByData(Date data);
	
	/**
	 * Recupera todos os ingressos pelo numero do acento.
	 * @param numeroAcento
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByNumeroAcento(int numeroAcento);
	
	/**
	 * Recupera todos os ingressos pelo numero do acento e setor,
	 * ordenado por data de forma ascendente.
	 * @param numeroAcento
	 * @param setor
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByNumeroAcentoAndSetorOrderByDataAsc(int numeroAcento, Setor setor);
	
	/**
	 * Recupera todos os ingressos pelo numero do acento, setor e Jogo,
	 * ordenado por data de forma ascendente.
	 * @param numeroAcento
	 * @param setor
	 * @param jogo
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public Ingresso findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(int numeroAcento, Setor setor, Jogo jogo);
	
	/**
	 * Recupera todos os ingressos pelo Jogo, ordenado por
	 * data de forma ascendente.
	 * @param jogo
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByJogoOrderByDataAsc(Jogo jogo);

	/**
	 * Recupera todos os ingressos pelo Jogo, ordenado por
	 * data de forma descendente.
	 * @param jogo
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByJogoOrderByDataDesc(Jogo jogo);
		
}