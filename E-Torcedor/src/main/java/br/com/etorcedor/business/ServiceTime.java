package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.List;

import br.com.etorcedor.entity.odc.TimeLong;
import br.com.etorcedor.entity.odc.TimeShort;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.exception.TimeExistenteException;
import br.com.etorcedor.exception.TimeInexistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;

public interface ServiceTime extends Serializable {

	/**
	 * 
	 * @param t
	 * @throws TimeExistenteException
	 */
	public void adicionarTime(TimeShort t) throws TimeExistenteException;

	/**
	 * 
	 * @param t
	 * @throws TimeInexistenteException
	 */
	public void atualizarTime(TimeShort t) throws TimeInexistenteException;

	/**
	 * 
	 * @param t
	 * @throws TimeInexistenteException
	 */
	public void removerTime(Long t)
			throws TimeInexistenteException, TorcidaInexistenteException, JogoInexistenteException;

	/**
	 * Recupera um time pelo seu identificador.
	 * 
	 * @param id
	 * @return uma entidade do tipo Time.
	 */
	public TimeLong findByOne(Long id) throws TimeInexistenteException;

	/**
	 * Recupera um time pelo seu nome.
	 * 
	 * @param nome
	 * @return uma entidade do tipo Time.
	 */
	public TimeShort findByNome(String nome) throws TimeInexistenteException;

	public List<TimeLong> findAll();

}
