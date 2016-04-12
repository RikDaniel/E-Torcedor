package br.com.etorcedor.business;

import java.util.List;

import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.exception.TorcidaExistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;

public interface ServiceTorcida {

	public void adicionarTorcida(Torcida t) throws TorcidaExistenteException;
	public void atualizarTorcida(Torcida t) throws TorcidaInexistenteException;
	public void removerTorcida(Long id) throws TorcidaInexistenteException;
	public Torcida buscarTorcida(Long id) throws TorcidaInexistenteException;
	public List<Torcida> buscarTorcidaNome(String nome);
	public List<Torcida> buscarTorcidaTime(String time);
	
}
