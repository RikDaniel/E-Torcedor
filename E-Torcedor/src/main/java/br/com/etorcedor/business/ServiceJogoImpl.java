package br.com.etorcedor.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.exception.EstadioExistenteException;
import br.com.etorcedor.exception.EstadioInexistenteException;
import br.com.etorcedor.exception.IngressoExistenteException;
import br.com.etorcedor.exception.IngressoInexistenteException;
import br.com.etorcedor.exception.JogoExistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.persistence.RepositorioIngresso;
import br.com.etorcedor.persistence.RepositorioJogo;

@Service
public class ServiceJogoImpl implements ServiceJogo {

	/**
	 * Falta implementar as funções de remover
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositorioJogo jogoRep;
	@Autowired
	private RepositorioIngresso ingressoRep;

	public void adicionarJogo(Jogo j) throws JogoExistenteException {
		try {
			findOneJogo(j.getId());
			throw new JogoExistenteException();
		} catch (JogoInexistenteException e) {
			jogoRep.save(j);
		}
	}

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

	public void removerJogo(Jogo j) throws JogoInexistenteException {

	}

	public Jogo findOneJogo(Long id) throws JogoInexistenteException {
		Jogo j = jogoRep.findOne(id);

		if (j == null) {
			throw new JogoInexistenteException();
		}
		return j;
	}

	public List<Jogo> findByDataJogo(Date data) throws JogoInexistenteException {
		return jogoRep.findByData(data);
	}

	public List<Jogo> findByDataOrderByDataAsc(Date data) throws JogoInexistenteException {

		return jogoRep.findByDataOrderByDataAsc(data);
	}

	public List<Jogo> findByDataOrderByDataDesc(Date data) throws JogoInexistenteException {

		return jogoRep.findByDataOrderByDataDesc(data);
	}

	public List<Jogo> findByEstadio(Estadio estadio) throws JogoInexistenteException {
		return jogoRep.findByEstadio(estadio);
	}

	public List<Jogo> findByEstadioOrderByDataAsc(Estadio estadio) throws JogoInexistenteException {

		return jogoRep.findByEstadioOrderByDataAsc(estadio);
	}

	public List<Jogo> findByEstadioOrderByDataDesc(Estadio estadio) throws JogoInexistenteException {

		return jogoRep.findByEstadioOrderByDataDesc(estadio);
	}

	public void adicionarIngreco(Ingresso i) throws IngressoExistenteException {
		try {
			findOneIngresso(i.getId());
			throw new IngressoExistenteException();
		} catch (IngressoInexistenteException ei) {
			ingressoRep.save(i);
		}

	}

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

	public void removerIngreco(Long i) throws IngressoInexistenteException {

	}

	public Ingresso findOneIngresso(Long id) throws IngressoInexistenteException {
		Ingresso i = ingressoRep.findOne(id);
		if (i == null) {
			throw new IngressoInexistenteException();
		}
		return i;

	}

	public List<Ingresso> findByJogo(Jogo jogo) throws IngressoInexistenteException {

		return ingressoRep.findByJogo(jogo);
	}

	public List<Ingresso> findByDataIngresso(Date data) throws IngressoInexistenteException {

		return ingressoRep.findByData(data);
	}

	public List<Ingresso> findByNumeroAcento(int numeroAcento) throws IngressoInexistenteException {
		return ingressoRep.findByNumeroAcento(numeroAcento);
	}

	public List<Ingresso> findByNumeroAcentoAndSetorOrderByDataAsc(int numeroAcento, Setor setor)
			throws IngressoInexistenteException {
		return ingressoRep.findByNumeroAcentoAndSetorOrderByDataAsc(numeroAcento, setor);
	}

	public Ingresso findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(int numeroAcento, Setor setor, Jogo jogo)
			throws IngressoInexistenteException {

		return ingressoRep.findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(numeroAcento, setor, jogo);
	}

	public List<Ingresso> findByJogoOrderByDataAsc(Jogo jogo) throws IngressoInexistenteException {
		return ingressoRep.findByJogoOrderByDataAsc(jogo);
	}

	public List<Ingresso> findByJogoOrderByDataDesc(Jogo jogo) throws IngressoInexistenteException {
		return ingressoRep.findByJogoOrderByDataDesc(jogo);
	}

}
