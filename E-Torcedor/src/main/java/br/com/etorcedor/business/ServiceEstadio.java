package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.List;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.exception.EstadioExistenteException;
import br.com.etorcedor.exception.EstadioInexistenteException;
import br.com.etorcedor.exception.SetorExistenteException;
import br.com.etorcedor.exception.SetorInexistenteException;

public interface ServiceEstadio extends Serializable {

	//ESTADIO
	
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
	public Estadio findOneEstadio(Long id)throws EstadioInexistenteException;
	
	//SETOR
	
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
	public void atualizarSetor(Setor e)throws SetorInexistenteException;
	
	/**
	 * 
	 * @param e
	 * @throws SetorInexistenteException
	 */
	public void removerSetor(Setor e)throws SetorInexistenteException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws SetorInexistenteException
	 */
	public Setor findOneSetor(Long id)throws SetorInexistenteException;
	
	/**
	 * Recupera um setor pelo seu nome.
	 * @param nome
	 * @return Uma entidade do tipo Setor.
	 */
	public Setor findByNome(String nome)throws SetorInexistenteException;
	
	/**
	 * Recupera uma lista de Setor começando pelo nome.
	 * @param nome
	 * @return Uma coleção do tipo List de Setor.
	 */
	public List<Setor> findByNomeStartingWith(String nome)throws SetorInexistenteException;
	
	/**
	 * Resupera um setor contendo um determinado nome.
	 * @param nome
	 * @return Uma coleção do tipo List de Setor.
	 */
	public List<Setor> findByNomeContaining(String nome)throws SetorInexistenteException;
}
