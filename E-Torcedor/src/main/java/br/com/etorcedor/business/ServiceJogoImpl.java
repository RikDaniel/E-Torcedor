package br.com.etorcedor.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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
	public void adicionarJogo(Jogo j) throws JogoExistenteException {
			this.jogoRep.save(j);
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
		List<JogoShort> js = new ArrayList<JogoShort>();
		for(Jogo jogo : this.jogoRep.findByData(data)) {
			js.add(JogoShort.toJogoShort(jogo));
		}
		return js; 
	}

	public List<JogoShort> findByEstadio(Estadio estadio) {
		List<JogoShort> js = new ArrayList<JogoShort>();
		for(Jogo jogo : this.jogoRep.findByEstadio(estadio)) {
			js.add(JogoShort.toJogoShort(jogo));
		}
		return js;
	}

	public List<JogoShort> findAllJogo() {
		List<JogoShort> js = new ArrayList<JogoShort>();
		for(Jogo jogo : (List<Jogo>) this.jogoRep.findAll()) {
			js.add(JogoShort.toJogoShort(jogo));
		}
		return js;
	}

	// INGRESSO

	@Transactional(rollbackFor = IngressoExistenteException.class)
	public void adicionarIngresso(@RequestBody IngressoShort i) throws IngressoExistenteException {
			//if (this.findByNumeroAcento(i.getNumeroAcento()) == null) {
				this.ingressoRep.save(IngressoShort.toIngresso(i));
		//	}
	}

	@Transactional(rollbackFor = IngressoInexistenteException.class)
	public void removerIngresso(Long i) throws IngressoInexistenteException {
		IngressoShort old = this.findOneIngresso(i);
		this.ingressoRep.delete(old.getId());
	}

	public IngressoShort findOneIngresso(Long id) throws IngressoInexistenteException {
		Ingresso i = this.ingressoRep.findOne(id);
		if (i == null) {
			throw new IngressoInexistenteException();
		}
		return IngressoShort.toIngressoShort(i);
	}

	public List<IngressoShort> findByJogo(Jogo jogo) {
		return IngressoShort.toIngressoShort(this.ingressoRep.findByJogo(jogo));
	}

	public List<IngressoShort> findByDataIngresso(Date data) {
		return IngressoShort.toIngressoShort(this.ingressoRep.findByData(data));
	}

	public List<IngressoShort> findByNumeroAcento(int numeroAcento) {
		return IngressoShort.toIngressoShort(this.ingressoRep.findByNumeroAcento(numeroAcento));
	}

	public List<IngressoShort> findAllIngresso() {
		return IngressoShort.toIngressoShort((List<Ingresso>) this.ingressoRep.findAll());
	}
}