package br.com.etorcedor.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.odc.IngressoShort;
import br.com.etorcedor.entity.odc.JogoLong;
import br.com.etorcedor.entity.odc.JogoShort;
import br.com.etorcedor.exception.IngressoExistenteException;
import br.com.etorcedor.exception.IngressoInexistenteException;
import br.com.etorcedor.exception.JogoExistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.persistence.RepositorioIngresso;
import br.com.etorcedor.persistence.RepositorioJogo;

@Service
public class ServiceJogoImpl implements ServiceJogo {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RepositorioJogo jogoRep;
	@Autowired
	private RepositorioIngresso ingressoRep;

	@Transactional(rollbackFor = JogoExistenteException.class)
	public void adicionarJogo(JogoLong j) throws JogoExistenteException {
		JogoLong jogo = new JogoLong();
		try {
			 jogo = this.findOneJogo(j.getId());
			if (jogo != null)
				throw new JogoExistenteException();
		} catch (JogoInexistenteException e) {
			this.jogoRep.save(JogoLong.toJogo(j));
		}
	}

	@Transactional(rollbackFor = JogoInexistenteException.class)
	public void atualizarJogo(JogoLong j) throws JogoInexistenteException {
		JogoLong old = this.findOneJogo(j.getId());
		old.setData(j.getData());
		old.setEstadioApelido(j.getEstadioApelido());
		old.setEstadioNome(j.getEstadioNome());
		old.setIngressos(j.getIngressos());
		old.setIngressos_quantidade(j.getIngressos_quantidade());
		old.setIngressos_vendidos(j.getIngressos_vendidos());
		old.setTimes(j.getTimes());
		this.jogoRep.save(JogoLong.toJogo(old));
	}

	@Transactional(rollbackFor = JogoInexistenteException.class)
	public void removerJogo(Long id) throws JogoInexistenteException {
		JogoLong old = this.findOneJogo(id);
		List<IngressoShort> i = old.getIngressos();
		try {
			for (IngressoShort n : i)
				this.removerIngresso(n.getId());
			this.jogoRep.delete(old.getId());
		} catch (Exception e) {
			throw new JogoInexistenteException();
		}
	}

	public JogoLong findOneJogo(Long id) throws JogoInexistenteException {
		JogoLong jl = new JogoLong();
		JogoLong j = jl.toJogoLong(this.jogoRep.findOne(id));
		if (j == null) {
			throw new JogoInexistenteException();
		}
		return j;
	}

	public List<JogoShort> findByDataJogo(Date data) {
		List<JogoShort> js = null;
		for(Jogo jogo : this.jogoRep.findByData(data)) {
			js.add(JogoShort.toJogoShort(jogo));
		}
		return js; 
	}

	public List<JogoShort> findByEstadio(Estadio estadio) {
		List<JogoShort> js = null;
		for(Jogo jogo : this.jogoRep.findByEstadio(estadio)) {
			js.add(JogoShort.toJogoShort(jogo));
		}
		return js;
	}

	public List<JogoShort> findAllJogo() {
		List<JogoShort> js = null;
		for(Jogo jogo : (List<Jogo>) this.jogoRep.findAll()) {
			js.add(JogoShort.toJogoShort(jogo));
		}
		return js;
	}

	// INGRESSO

	@Transactional(rollbackFor = IngressoExistenteException.class)
	public void adicionarIngresso(Ingresso i) throws IngressoExistenteException {
		try {
			findOneIngresso(i.getId());
			throw new IngressoExistenteException();
		} catch (IngressoInexistenteException ei) {
			ingressoRep.save(i);
		}
	}

	@Transactional(rollbackFor = IngressoInexistenteException.class)
	public void removerIngresso(Long i) throws IngressoInexistenteException {
		Ingresso old = findOneIngresso(i);
		ingressoRep.delete(old);
	}

	public Ingresso findOneIngresso(Long id) throws IngressoInexistenteException {
		Ingresso i = ingressoRep.findOne(id);
		if (i == null) {
			throw new IngressoInexistenteException();
		}
		return i;
	}

	public List<Ingresso> findByJogo(Jogo jogo) {
		return ingressoRep.findByJogo(jogo);
	}

	public List<Ingresso> findByDataIngresso(Date data) {
		return ingressoRep.findByData(data);
	}

	public List<Ingresso> findByNumeroAcento(int numeroAcento) {
		return ingressoRep.findByNumeroAcento(numeroAcento);
	}

	public List<Ingresso> findAllIngresso() {
		return (List<Ingresso>) this.ingressoRep.findAll();
	}
}