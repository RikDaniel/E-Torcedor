package br.com.etorcedor.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.exception.EstadioInexistenteException;
import br.com.etorcedor.exception.TimeInexistenteException;
import br.com.etorcedor.exception.TorcidaExistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;
import br.com.etorcedor.exception.UsuarioExistenteException;
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
		try {
			this.findById(t.getId());
			throw new TorcidaExistenteException();
		} catch (TorcidaInexistenteException e) {
			torcidaRep.save(t);
		}
		
	}
	
	public Torcida findById(Long id)throws TorcidaInexistenteException{
		
			Torcida i= torcidaRep.findOne(id);
		if(i==null)
			throw new TorcidaInexistenteException();	
		return i;
	}
	
	
	@Transactional(rollbackFor = TorcidaInexistenteException.class)
	public void atualizarTorcida(Torcida t) throws TorcidaInexistenteException {
		Torcida old= findOneTorcida(t.getId());
		old.setNome(t.getNome());
		old.setSocios(t.getSocios());
		old.setTime(t.getTime());
		old.setTorcedores(t.getTorcedores());
		torcidaRep.save(old);
		
	}

	@Transactional(rollbackFor = TorcidaInexistenteException.class)
	public void removerTorcida(Long id) throws TorcidaInexistenteException {
		
		Torcida t = findOneTorcida(id);
		
			if(t==null)
				
				throw new TorcidaInexistenteException();
		
			torcidaRep.delete(t);
	}
	
	public Torcida findOneTorcida(Long id)throws TorcidaInexistenteException{
	
		Torcida t = torcidaRep.findOne(id);
			
			if(t==null) 
				throw new TorcidaInexistenteException();
			
		return t;
		
	}

	public Torcida findByNome(String nome) throws TorcidaInexistenteException {
		
		Torcida t= torcidaRep.findByNome(nome);
		
		if(t==null)
		
			throw new TorcidaInexistenteException();
	
		return t;
		
	}

	public List<Torcida> findByNomeContaining(String nome) {

		return this.torcidaRep.findByNomeContaining(nome);
	}

	public List<Torcida> findByNomeStartingWith(String nome)  {
	
		return this.torcidaRep.findByNomeStartingWith(nome);
	}

	public List<Torcida> findByNomeOrderByNomeAsc(String nome) {
		
		return this.torcidaRep.findByNomeOrderByNomeAsc(nome);
	}

	public List<Torcida> findByNomeOrderByNomeDesc(String nome) {
	
		return this.torcidaRep.findByNomeOrderByNomeDesc(nome);
	}

	public List<Torcida> findByTime(Time time) {
		
		return this.torcidaRep.findByTime(time);
	}

	public List<Torcida> findByTimeOrderByNomeAsc(Time time) {
		
		return this.torcidaRep.findByTimeOrderByNomeAsc(time);
	}

	public List<Torcida> findByTimeOrderByNomeDesc(Time time) {
	
		return this.torcidaRep.findByTimeOrderByNomeDesc(time);
	}
	
	/**
	 * Retorna uma lista com todos os times
	 */
	public List<Torcida> findAllTorcida() {
		return (List<Torcida>) this.torcidaRep.findAll();
	}

}
