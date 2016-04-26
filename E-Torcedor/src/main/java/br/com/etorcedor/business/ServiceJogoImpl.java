package br.com.etorcedor.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.exception.IngressoExistenteException;
import br.com.etorcedor.exception.IngressoInexistenteException;
import br.com.etorcedor.exception.JogoExistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.persistence.RepositorioIngresso;
import br.com.etorcedor.persistence.RepositorioJogo;

@Service
public class ServiceJogoImpl implements ServiceJogo {

	/**
	 * Falta implementar os metodos de remover
	 */
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

	public List<Jogo> findByDataOrderByDataAsc(Date data) {
		return jogoRep.findByDataOrderByDataAsc(data);
	}

	public List<Jogo> findByDataOrderByDataDesc(Date data) {
		return jogoRep.findByDataOrderByDataDesc(data);
	}

	public List<Jogo> findByEstadio(Estadio estadio) {
		return jogoRep.findByEstadio(estadio);
	}

	public List<Jogo> findByEstadioOrderByDataAsc(Estadio estadio) {
		return jogoRep.findByEstadioOrderByDataAsc(estadio);
	}

	public List<Jogo> findByEstadioOrderByDataDesc(Estadio estadio) {
		return jogoRep.findByEstadioOrderByDataDesc(estadio);
	}
	public List<Jogo> findAllJogo() {
		return (List<Jogo>) this.jogoRep.findAll();
	}

	@Transactional(rollbackFor = IngressoExistenteException.class)
	public void adicionarIngreco(Ingresso i) throws IngressoExistenteException {
		try {
			findOneIngresso(i.getId());
			throw new IngressoExistenteException();
		} catch (IngressoInexistenteException ei) {
			ingressoRep.save(i);
		}

	}

	@Transactional(rollbackFor = IngressoInexistenteException.class)
	public void atualizarIngreco(Ingresso i) throws IngressoInexistenteException {
		Ingresso old = ingressoRep.findOne(i.getId());
		old.setData(i.getData());
		old.setJogo(i.getJogo());
		old.setNumero_acento(i.getNumero_acento());
		old.setSetor(i.getSetor());
		old.setUsuario(i.getUsuario());
		old.setValor_ingreco(i.getValor_ingreco());
		ingressoRep.save(old);

	}

	@Transactional(rollbackFor = IngressoInexistenteException.class)
	public void removerIngreco(Long i) throws IngressoInexistenteException {

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

	public List<Ingresso> findByNumeroAcentoAndSetorOrderByDataAsc(int numeroAcento, Setor setor) {
		return ingressoRep.findByNumeroAcentoAndSetorOrderByDataAsc(numeroAcento, setor);
	}

	public Ingresso findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(int numeroAcento, Setor setor, Jogo jogo)
			throws IngressoInexistenteException {
		return ingressoRep.findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(numeroAcento, setor, jogo);
	}

	public List<Ingresso> findByJogoOrderByDataAsc(Jogo jogo) {
		return ingressoRep.findByJogoOrderByDataAsc(jogo);
	}

	public List<Ingresso> findByJogoOrderByDataDesc(Jogo jogo) {
		return ingressoRep.findByJogoOrderByDataDesc(jogo);
	}
	
	public List<Ingresso> findAllIngresso() {
		return (List<Ingresso>) this.ingressoRep.findAll();
	}
}