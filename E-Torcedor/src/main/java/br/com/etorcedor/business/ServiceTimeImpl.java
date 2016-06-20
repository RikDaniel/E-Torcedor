package br.com.etorcedor.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.exception.TimeExistenteException;
import br.com.etorcedor.exception.TimeInexistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;
import br.com.etorcedor.persistence.RepositorioTime;

@Service
public class ServiceTimeImpl implements ServiceTime {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private RepositorioTime timeRep;
	@Autowired
	private ServiceTorcida torcidaSer;
	@Autowired
	private ServiceJogo jogoSer;

	@Transactional(rollbackFor = TimeExistenteException.class)
	public void adicionarTime(Time t) throws TimeExistenteException {
		try {
			Time time = this.findByNome(t.getNome());
			if (time != null)
				throw new TimeExistenteException();
		} catch (TimeInexistenteException e) {
			this.timeRep.save(t);
		}
	}

	@Transactional(rollbackFor = TimeInexistenteException.class)
	public void atualizarTime(Time t) throws TimeInexistenteException {
		Time old = findByOne(t.getId());
		old.setJogos(t.getJogos());
		old.setNome(t.getNome());
		old.setTorcidas(t.getTorcidas());
		this.timeRep.save(old);
	}

	@Transactional(rollbackFor = TimeInexistenteException.class)
	public void removerTime(Time t)
			throws TimeInexistenteException, TorcidaInexistenteException, JogoInexistenteException {
		Time old = findByOne(t.getId());
		List<Torcida> a = old.getTorcidas();
		List<Jogo> j = old.getJogos();
		try {
			for (Torcida to : a)
				torcidaSer.removerTorcida(to.getId());
			for (Jogo jo : j)
				jogoSer.removerJogo(jo);
			timeRep.delete(old);
		} catch (Exception e) {
			throw new TimeInexistenteException();
		}
	}

	public Time findByOne(Long id) throws TimeInexistenteException {
		Time t = timeRep.findOne(id);
		if (t == null) {
			throw new TimeInexistenteException();
		}
		return t;
	}

	public Time findByNome(String nome) throws TimeInexistenteException {
		Time t = timeRep.findByNome(nome);
		if (t == null) {
			throw new TimeInexistenteException();
		}
		return t;
	}

	/**
	 * Retorna uma lista com todos os times
	 */
	public List<Time> findAll() {
		return (List<Time>) this.timeRep.findAll();
	}
}