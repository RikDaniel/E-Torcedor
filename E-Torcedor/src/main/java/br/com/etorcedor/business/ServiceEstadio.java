package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.List;

import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.entity.odc.EstadioShort;
import br.com.etorcedor.entity.odc.SetorShort;
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
	public void adicionarEstadio(EstadioShort e) throws EstadioExistenteException;

	/**
	 * 
	 * @param e
	 * @throws EstadioInexistenteException
	 */
	public void atualizarEstadio(EstadioShort e) throws EstadioInexistenteException;

	/**
	 * 
	 * @param e
	 * @throws EstadioInexistenteException
	 */
	public void removerEstadio(Long id) throws EstadioInexistenteException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	public EstadioShort findOneEstadio(Long id) throws EstadioInexistenteException;

	/**
	 * 
	 * @param nome
	 * @return
	 * @throws EstadioInexistenteException
	 */
	public EstadioShort findByNomeEstadio(String nome) throws EstadioInexistenteException;
	
	/**
	 * 
	 * @param apelido
	 * @return
	 * @throws EstadioInexistenteException
	 */
	public EstadioShort findByApelido(String apelido) throws EstadioInexistenteException;

	/**
	 * 
	 * @return
	 */
	public List<EstadioShort> findAllEstadio();

	// SETOR

	/**
	 * 
	 * @param e
	 * @throws SetorExistenteException
	 */
	public void adicionarSetor(SetorShort e) throws SetorExistenteException;

	/**
	 * 
	 * @param e
	 * @throws SetorInexistenteException
	 */
	public void atualizarSetor(SetorShort e) throws SetorInexistenteException;

	/**
	 * 
	 * @param e
	 * @throws SetorInexistenteException
	 */
	public void removerSetor(Long id) throws SetorInexistenteException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws SetorInexistenteException
	 */
	public SetorShort findOneSetor(Long id) throws SetorInexistenteException;

	/**
	 * Recupera um setor pelo seu nome.
	 * 
	 * @param nome
	 * @return Uma entidade do tipo Setor.
	 */
	public List<SetorShort> findByNome(String nome) throws SetorInexistenteException;
	
	/**
	 * 
	 * @return
	 */
	public List<SetorShort> findAllSetores();
}
