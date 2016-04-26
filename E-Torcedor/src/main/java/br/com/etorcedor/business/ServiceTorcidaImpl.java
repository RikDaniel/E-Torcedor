package br.com.etorcedor.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.exception.TimeInexistenteException;
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

	@Transactional(rollbackFor = TorcidaExistenteException.class)
	public void adicionarTorcida(Torcida t) throws TorcidaExistenteException {
		// TODO Auto-generated method stub
		
	}

	@Transactional(rollbackFor = TorcidaInexistenteException.class)
	public void atualizarTorcida(Torcida t) throws TorcidaInexistenteException {
		// TODO Auto-generated method stub
		
	}

	@Transactional(rollbackFor = TorcidaInexistenteException.class)
	public void removerTorcida(Long id) throws TorcidaInexistenteException {
		// TODO Auto-generated method stub
		
	}

	public Torcida findByNome(String nome) throws TorcidaInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByNomeContaining(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByNomeStartingWith(String nome)  {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByNomeOrderByNomeAsc(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByNomeOrderByNomeDesc(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByTime(Time time) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByTimeOrderByNomeAsc(Time time) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Torcida> findByTimeOrderByNomeDesc(Time time) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Retorna uma lista com todos os times
	 */
	public List<Torcida> findAllTorcida() {
		return (List<Torcida>) this.torcidaRep.findAll();
	}

}
