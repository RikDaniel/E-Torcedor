package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.List;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.exception.TimeExistenteException;
import br.com.etorcedor.exception.TimeInexistenteException;

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
	public void removerTime(Time t)throws TimeInexistenteException;
	
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
	
	/**
	 * Recupera uma lista de times, começando com um nome.
	 * @param nome
	 * @return uma List do tipo Time.
	 */
	public List<Time> findByNomeStartingWith(String nome)throws TimeInexistenteException;
	
	/*
	 * Não sei se esse metodo funciona, Verificar com o Prof Thiago
	 * public List<Time> findByNomeStartingWithOrderByNomeAsc(String nome);
	 */
	
	/**
	 * Recupera uma Lista de time contendo um nome.
	 * @param nome
	 * @return uma List do tipo Time.
	 */
	public List<Time> findByNomeContaining(String nome)throws TimeInexistenteException;
}
