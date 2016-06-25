package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.odc.IngressoShort;
import br.com.etorcedor.entity.odc.JogoLong;
import br.com.etorcedor.entity.odc.JogoShort;
import br.com.etorcedor.exception.IngressoExistenteException;
import br.com.etorcedor.exception.IngressoInexistenteException;
import br.com.etorcedor.exception.JogoExistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;

public interface ServiceJogo extends Serializable {

	// JOGO
	/**
	 * 
	 * @param j
	 * @throws JogoExistenteException
	 */
	public void adicionarJogo(JogoLong j) throws JogoExistenteException;

	/**
	 * 
	 * @param j
	 * @throws JogoInexistenteException
	 */
	public void atualizarJogo(JogoLong j) throws JogoInexistenteException;

	/**
	 * 
	 * @param j
	 * @throws JogoInexistenteException
	 */
	public void removerJogo(Long id) throws JogoInexistenteException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	public JogoLong findOneJogo(Long id) throws JogoInexistenteException;

	/**
	 * Recupera uma lista de Jogos em um determinada Data.
	 * 
	 * @param data
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<JogoShort> findByDataJogo(Date data);

	/**
	 * Recupera uma lista de Jogos em um estadio.
	 * 
	 * @param estadio
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<JogoShort> findByEstadio(Estadio estadio);

	/**
	 * Retorna uma lista com todos os jogos
	 * 
	 * @return
	 */
	public List<JogoShort> findAllJogo();

	// INGRESSO

	/**
	 * 
	 * @param i
	 * @throws IngressoExistenteException
	 */
	public void adicionarIngresso(IngressoShort i) throws IngressoExistenteException;

	/**
	 * 
	 * @param i
	 * @throws IngressoInexistenteException
	 */
	public void removerIngresso(Long i) throws IngressoInexistenteException;

	/**
	 * Recupera todos os ingressos de um determinado jogo.
	 * 
	 * @param jogo
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<IngressoShort> findByJogo(Jogo jogo);

	/**
	 * Recupera todos os ingressos de uma data.
	 * 
	 * @param data
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<IngressoShort> findByDataIngresso(Date data);

	/**
	 * Recupera todos os ingressos pelo numero do acento.
	 * 
	 * @param numeroAcento
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<IngressoShort> findByNumeroAcento(int numeroAcento);

	/**
	 * 
	 * @param id
	 * @return
	 * @throws IngressoInexistenteException
	 */
	public IngressoShort findOneIngresso(Long id) throws IngressoInexistenteException;

	/**
	 * 
	 * @return
	 */
	public List<IngressoShort> findAllIngresso();
}
