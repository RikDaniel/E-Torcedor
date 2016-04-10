package br.com.etorcedor.service;

import java.util.List;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.exception.EstadioExistenteException;
import br.com.etorcedor.exception.EstadioInexistenteException;
import br.com.etorcedor.exception.SetorExistenteException;
import br.com.etorcedor.exception.SetorInexistenteException;

public interface ServiceEstadio {

	public void adicionarEstadio(Estadio e) throws EstadioExistenteException;
	public void atualizarEstadio(Estadio e) throws EstadioInexistenteException;
	public void removerEstadio(Estadio e) throws EstadioInexistenteException;
	public Estadio buscarEstadio(Long id)throws EstadioInexistenteException;
	public List<Estadio> buscarEstadio(String nome);
	public List<Jogo> listarEstadioJogos();
	
	public void adicionarSetor(Setor e) throws SetorExistenteException;
	public void atualizarSetor(Setor e) throws SetorInexistenteException;
	public void removerSetor(Setor e) throws SetorInexistenteException;
	public Setor buscarSetor(Long id) throws SetorInexistenteException;
	public List<Setor> listarSetores();
	
}
