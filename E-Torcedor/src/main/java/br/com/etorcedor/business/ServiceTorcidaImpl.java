package br.com.etorcedor.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.exception.TorcidaExistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;
import br.com.etorcedor.persistence.RepositorioTorcida;

@Service
public class ServiceTorcidaImpl implements ServiceTorcida{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositorioTorcida torcidaRep;

	public void adicionarTorcida(Torcida t) throws TorcidaExistenteException {
		// TODO Auto-generated method stub
		
	}

	public void atualizarTorcida(Torcida t) throws TorcidaInexistenteException {
		// TODO Auto-generated method stub
		
	}

	public void removerTorcida(Long id) throws TorcidaInexistenteException {
		// TODO Auto-generated method stub
		
	}

	public Torcida findByNome(String nome) throws TorcidaExistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByNomeContaining(String nome) throws TorcidaExistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByNomeStartingWith(String nome) throws TorcidaExistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByNomeOrderByNomeAsc(String nome) throws TorcidaExistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByNomeOrderByNomeDesc(String nome) throws TorcidaExistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByTime(Time time) throws TorcidaExistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByTimeOrderByNomeAsc(Time time) throws TorcidaExistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByTimeOrderByNomeDesc(Time time) throws TorcidaExistenteException {
		// TODO Auto-generated method stub
		return null;
	}

}
