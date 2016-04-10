package br.com.etorcedor.service;

import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Ingreco;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.exception.IngrecoExistenteException;
import br.com.etorcedor.exception.IngrecoInexistenteException;
import br.com.etorcedor.exception.JogoExistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;

public interface ServiceJogo {
	
	public void  adicionarJogo(Jogo j)throws JogoExistenteException;
	public void atualizarJogo(Jogo j)throws JogoInexistenteException;
	public void removerJogo(Jogo j)throws JogoInexistenteException;
	public Jogo buscarJogo(Long id)throws JogoInexistenteException;
	public List<Jogo> buscarJogoNomeTime(String nomeTime);
	public List<Jogo> buscarJogoData(Date data);
	
	public void adicionarIngreco(Ingreco i) throws IngrecoExistenteException;
	public void atualizarIngreco(Ingreco i) throws IngrecoInexistenteException;
	public void removerIngreco(Long i) throws IngrecoInexistenteException;
	public Ingreco buscarIngrego(Long id);
	public List<Ingreco> listarIngrecos();
	

}
