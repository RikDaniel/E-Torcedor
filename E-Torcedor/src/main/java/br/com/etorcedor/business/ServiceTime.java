package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.List;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.exception.TimeExistenteException;
import br.com.etorcedor.exception.TimeInexistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;

public interface ServiceTime extends Serializable{

	/**
	 * 
	 * @param t
	 * @throws TimeExistenteException
	 */
	public void adicionarTime(Time t)throws TimeExistenteException;
	
	/**
	 * 
	 * @param t
	 * @throws TimeInexistenteException
	 */
	public void atualizarTime(Time t)throws TimeInexistenteException;
	
	/**
	 * 
	 * @param t
	 * @throws TimeInexistenteException
	 */
	public void removerTime(Time t)throws TimeInexistenteException,TorcidaInexistenteException,JogoInexistenteException;
	
	/**
	 * Recupera um time pelo seu identificador.
	 * @param id
	 * @return uma entidade do tipo Time.
	 */
	public Time findByOne(Long id)throws TimeInexistenteException;
	
	/**
	 * Recupera um time pelo seu nome.
	 * @param nome
	 * @return uma entidade do tipo Time.
	 */
	public Time findByNome(String nome)throws TimeInexistenteException;
	
	public List<Time> findAll();
	
}
