package br.com.etorcedor.business;

import java.util.List;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.exception.TimeExistenteException;
import br.com.etorcedor.exception.TimeInexistenteException;

public interface ServiceTime {

	public void adicionarTime(Time t)throws TimeExistenteException;
	public void atualizarTime(Time t)throws TimeInexistenteException;
	public void removerTime(Time t)throws TimeInexistenteException;
	public Time buscarTime(Long id) throws TimeInexistenteException;
	public List<Time> buscarTimeNome(String nome);
	
}
