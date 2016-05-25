package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.List;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.exception.EstadioExistenteException;
import br.com.etorcedor.exception.EstadioInexistenteException;
import br.com.etorcedor.exception.SetorExistenteException;
import br.com.etorcedor.exception.SetorInexistenteException;

public interface ServiceEstadio extends Serializable {

	// ESTADIO

	/**
	 * 
	 * @param e
	 * @throws EstadioExistenteException
	 */
	public void adicionarEstadio(Estadio e) throws EstadioExistenteException;

	/**
	 * 
	 * @param e
	 * @throws EstadioInexistenteException
	 */
	public void atualizarEstadio(Estadio e) throws EstadioInexistenteException;

	/**
	 * 
	 * @param e
	 * @throws EstadioInexistenteException
	 */
	public void removerEstadio(Estadio e) throws EstadioInexistenteException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Estadio findOneEstadio(Long id) throws EstadioInexistenteException;

	/**
	 * 
	 * @param nome
	 * @return
	 * @throws EstadioInexistenteException
	 */
	public Estadio findByNomeEstadio(String nome) throws EstadioInexistenteException;
	
	/**
	 * 
	 * @param apelido
	 * @return
	 * @throws EstadioInexistenteException
	 */
	public Estadio findByApelido(String apelido) throws EstadioInexistenteException;

	/**
	 * 
	 * @return
	 */
	public List<Estadio> findAllEstadio();

	// SETOR

	/**
	 * 
	 * @param e
	 * @throws SetorExistenteException
	 */
	public void adicionarSetor(Setor e) throws SetorExistenteException;

	/**
	 * 
	 * @param e
	 * @throws SetorInexistenteException
	 */
	public void atualizarSetor(Setor e) throws SetorInexistenteException;

	/**
	 * 
	 * @param e
	 * @throws SetorInexistenteException
	 */
	public void removerSetor(Setor e) throws SetorInexistenteException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws SetorInexistenteException
	 */
	public Setor findOneSetor(Long id) throws SetorInexistenteException;

	/**
	 * Recupera um setor pelo seu nome.
	 * 
	 * @param nome
	 * @return Uma entidade do tipo Setor.
	 */
	public Setor findByNome(String nome) throws SetorInexistenteException;
}
