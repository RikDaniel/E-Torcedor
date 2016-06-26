package br.com.etorcedor.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.entity.odc.TorcidaShort;
import br.com.etorcedor.exception.TorcidaExistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;
import br.com.etorcedor.persistence.RepositorioTorcida;

@Service
public class ServiceTorcidaImpl implements ServiceTorcida {

	private static final long serialVersionUID = 5184754998130052128L;

	@Autowired
	private RepositorioTorcida torcidaRep;

	@Transactional(rollbackFor = TorcidaExistenteException.class)
	public void adicionarTorcida(TorcidaShort t) throws TorcidaExistenteException {
		try {
				TorcidaShort torcida = this.findByNome(t.getNome());
				if (torcida != null)
					throw new TorcidaExistenteException();
		} catch (TorcidaInexistenteException e) {
			this.torcidaRep.save(TorcidaShort.toTorcida(t));
		}
	}

	@Transactional(rollbackFor = TorcidaInexistenteException.class)
	public void atualizarTorcida(TorcidaShort t) throws TorcidaInexistenteException {
		TorcidaShort old = this.findOneTorcida(t.getId());
		old.setNome(t.getNome());
		old.setTimeShort(t.getTimeShort());
		this.torcidaRep.save(TorcidaShort.toTorcida(old));
	}

	@Transactional(rollbackFor = TorcidaInexistenteException.class)
	public void removerTorcida(Long id) throws TorcidaInexistenteException {
		TorcidaShort t = this.findOneTorcida(id);
		if (t == null)
			throw new TorcidaInexistenteException();
		this.torcidaRep.delete(TorcidaShort.toTorcida(t));
	}

	public TorcidaShort findById(Long id) throws TorcidaInexistenteException {
		Torcida i = this.torcidaRep.findOne(id);
		if (i == null)
			throw new TorcidaInexistenteException();
		return TorcidaShort.toTorcidaShort(i);
	}

	public TorcidaShort findOneTorcida(Long id) throws TorcidaInexistenteException {
		Torcida t = this.torcidaRep.findOne(id);
		if (t == null)
			throw new TorcidaInexistenteException();
		return TorcidaShort.toTorcidaShort(t);
	}

	public TorcidaShort findByNome(String nome) throws TorcidaInexistenteException {
		Torcida t = this.torcidaRep.findByNome(nome);
		if (t == null)
			throw new TorcidaInexistenteException();
		return TorcidaShort.toTorcidaShort(t);
	}

	public List<TorcidaShort> findByTime(Time time) {
		return TorcidaShort.toTorcidaShort(this.torcidaRep.findByTime(time));
	}

	/**
	 * Retorna uma lista com todos os times
	 */
	public List<TorcidaShort> findAllTorcida() {
		return TorcidaShort.toTorcidaShort((List<Torcida>) this.torcidaRep.findAll());
	}
}
