package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.List;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.exception.TorcidaExistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;

public interface ServiceTorcida extends Serializable {

	/**
	 * 
	 * @param t
	 * @throws TorcidaExistenteException
	 */
	public void adicionarTorcida(Torcida t)throws TorcidaExistenteException;
	
	/**
	 * 
	 * @param t
	 * @throws TorcidaInexistenteException
	 */
	public void atualizarTorcida(Torcida t)throws TorcidaInexistenteException;
	
	/**
	 * 
	 * @param id
	 * @throws TorcidaInexistenteException
	 */
	public void removerTorcida(Long id)throws TorcidaInexistenteException;
	
	/**
	 * Recupera uma torcidas pelo seu nome. 
	 * @param nome
	 * @return uma entidade do tipo Torcida
	 */
	public Torcida findByNome(String nome)throws TorcidaInexistenteException;
	
	/**
	 * Recupera todas as torcida pelo Time
	 * @param time
	 * @return uma coleção de Torcida do tipo List
	 */
	public List<Torcida> findByTime(Time time);
	
		
	public Torcida findOneTorcida(Long id)throws TorcidaInexistenteException;
	
	/**
	 * Retorna uma lista com todos os times
	 */
	public List<Torcida> findAllTorcida();
}
