package br.com.etorcedor.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.exception.TorcidaExistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;
import br.com.etorcedor.persistence.RepositorioTorcida;

@Service
public class ServiceTorcidaImpl implements ServiceTorcida {

	private static final long serialVersionUID = 5184754998130052128L;
	
	@Autowired
	private RepositorioTorcida torcidaRep;

	@Transactional(rollbackFor = TorcidaExistenteException.class)
	public void adicionarTorcida(Torcida t) throws TorcidaExistenteException {
		try {
			Torcida torcida = this.findById(t.getId());
			if (torcida != null)
				throw new TorcidaExistenteException();
		} catch (TorcidaInexistenteException e) {
			torcidaRep.save(t);
		}
	}

	@Transactional(rollbackFor = TorcidaInexistenteException.class)
	public void atualizarTorcida(Torcida t) throws TorcidaInexistenteException {
		Torcida old = findOneTorcida(t.getId());
		old.setNome(t.getNome());
		old.setSocios(t.getSocios());
		old.setTime(t.getTime());
		old.setTorcedores(t.getTorcedores());
		torcidaRep.save(old);
	}

	@Transactional(rollbackFor = TorcidaInexistenteException.class)
	public void removerTorcida(Long id) throws TorcidaInexistenteException {
		Torcida t = findOneTorcida(id);
		if (t == null)
			throw new TorcidaInexistenteException();
		torcidaRep.delete(t);
	}

	public Torcida findById(Long id) throws TorcidaInexistenteException {
		Torcida i = torcidaRep.findOne(id);
		if (i == null)
			throw new TorcidaInexistenteException();
		return i;
	}

	public Torcida findOneTorcida(Long id) throws TorcidaInexistenteException {
		Torcida t = torcidaRep.findOne(id);
		if (t == null)
			throw new TorcidaInexistenteException();
		return t;
	}

	public Torcida findByNome(String nome) throws TorcidaInexistenteException {
		Torcida t = torcidaRep.findByNome(nome);
		if (t == null)
			throw new TorcidaInexistenteException();
		return t;
	}

	public List<Torcida> findByTime(Time time) {
		return this.torcidaRep.findByTime(time);
	}

	/**
	 * Retorna uma lista com todos os times
	 */
	public List<Torcida> findAllTorcida() {
		return (List<Torcida>) this.torcidaRep.findAll();
	}
}
