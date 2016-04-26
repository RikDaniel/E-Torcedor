package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.exception.IngressoExistenteException;
import br.com.etorcedor.exception.IngressoInexistenteException;
import br.com.etorcedor.exception.JogoExistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;

public interface ServiceJogo extends Serializable{
	
	
	//JOGO
	/**
	 * 
	 * @param j
	 * @throws JogoExistenteException
	 */
	public void  adicionarJogo(Jogo j)throws JogoExistenteException;
	
	/**
	 * 
	 * @param j
	 * @throws JogoInexistenteException
	 */
	public void atualizarJogo(Jogo j)throws JogoInexistenteException;
	
	/**
	 * 
	 * @param j
	 * @throws JogoInexistenteException
	 */
	public void removerJogo(Jogo j)throws JogoInexistenteException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Jogo findOneJogo(Long id)throws JogoInexistenteException;

	/**
	 * Recupera uma lista de Jogos em um determinada Data.
	 * @param data
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByDataJogo(Date data);
	
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
	
	/**
	 * Retorna uma lista com todos os jogos
	 * @return
	 */
	public List<Jogo> findAllJogo();
	
	//INGRESSO
	
	/**
	 * 
	 * @param i
	 * @throws IngressoExistenteException
	 */
	public void adicionarIngreco(Ingresso i) throws IngressoExistenteException;
	
	/**
	 * 
	 * @param i
	 * @throws IngressoInexistenteException
	 */
	public void atualizarIngreco(Ingresso i) throws IngressoInexistenteException;
	
	/**
	 * 
	 * @param i
	 * @throws IngressoInexistenteException
	 */
	public void removerIngreco(Long i)throws IngressoInexistenteException;
	
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
	public List<Ingresso> findByDataIngresso(Date data);
	
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
	public Ingresso findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(int numeroAcento, Setor setor, Jogo jogo)throws IngressoInexistenteException;
	
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

	/**
	 * 
	 * @param id
	 * @return
	 * @throws IngressoInexistenteException
	 */
	public Ingresso findOneIngresso(Long id)throws IngressoInexistenteException;
	
	public List<Ingresso> findAllIngresso();
}
