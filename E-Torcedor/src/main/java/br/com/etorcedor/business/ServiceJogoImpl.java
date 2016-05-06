package br.com.etorcedor.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
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
		try {
			findOneJogo(j.getId());
			throw new JogoExistenteException();
		} catch (JogoInexistenteException e) {
			jogoRep.save(j);
		}
	}

	@Transactional(rollbackFor = JogoInexistenteException.class)
	public void atualizarJogo(Jogo j) throws JogoInexistenteException {
		Jogo old = findOneJogo(j.getId());
		old.setData(j.getData());
		old.setEstadio(j.getEstadio());
		old.setIngrecos(j.getIngrecos());
		old.setIngrecos_quantidade(j.getIngrecos_quantidade());
		old.setIngrecos_vendidos(j.getIngrecos_quantidade());
		old.setTimes(j.getTimes());
		jogoRep.save(old);
	}

	@Transactional(rollbackFor = JogoInexistenteException.class)
	public void removerJogo(Jogo j) throws JogoInexistenteException {
		Jogo old= findOneJogo(j.getId());

		List<Ingresso> i = old.getIngrecos();
		try {
			for(Ingresso n:i)
				removerIngresso(n.getId());
			jogoRep.delete(old);	
		} catch (Exception e) {
			throw new JogoInexistenteException();
		}
	}

	public Jogo findOneJogo(Long id) throws JogoInexistenteException {
		Jogo j = jogoRep.findOne(id);

		if (j == null) {
			throw new JogoInexistenteException();
		}
		return j;
	}

	public List<Jogo> findByDataJogo(Date data) {
		return jogoRep.findByData(data);
	}

	public List<Jogo> findByEstadio(Estadio estadio) {
		return jogoRep.findByEstadio(estadio);
	}

	public List<Jogo> findAllJogo() {
		return (List<Jogo>) this.jogoRep.findAll();
	}

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
	public void atualizarIngresso(Ingresso i) throws IngressoInexistenteException {
		Ingresso old = ingressoRep.findOne(i.getId());
		old.setData(i.getData());
		old.setJogo(i.getJogo());
		old.setNumeroAcento(i.getNumeroAcento());
		old.setSetor(i.getSetor());
		old.setUsuario(i.getUsuario());
		old.setValorIngresso(i.getValorIngresso());
		ingressoRep.save(old);
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