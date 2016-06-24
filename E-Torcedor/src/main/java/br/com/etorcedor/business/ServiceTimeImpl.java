package br.com.etorcedor.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.entity.odc.TimeLong;
import br.com.etorcedor.entity.odc.TimePai;
import br.com.etorcedor.entity.odc.TimeShort;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.exception.TimeExistenteException;
import br.com.etorcedor.exception.TimeInexistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;
import br.com.etorcedor.persistence.RepositorioTime;

@Service
public class ServiceTimeImpl implements ServiceTime {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RepositorioTime timeRep;
	@Autowired
	private ServiceTorcida torcidaSer;
	@Autowired
	private ServiceJogo jogoSer;

	@Transactional(rollbackFor = TimeExistenteException.class)
	public void adicionarTime(TimeShort t) throws TimeExistenteException {
		try {
			TimeShort time = this.findByNome(t.getNome());
			if (time != null)
				throw new TimeExistenteException();
		} catch (TimeInexistenteException e) {
			this.timeRep.save(TimeShort.toTime(t));
		}
	}

	@Transactional(rollbackFor = TimeInexistenteException.class)
	public void atualizarTime(TimeShort t) throws TimeInexistenteException {
		TimePai old = findByOne(t.getId());
		old.setNome(t.getNome());
		this.timeRep.save(TimeShort.toTime(old));
	}

	@Transactional(rollbackFor = TimeInexistenteException.class)
	public void removerTime(Long idTime)
			throws TimeInexistenteException, TorcidaInexistenteException, JogoInexistenteException {
		TimePai old = this.findByOne(idTime);
		List<Torcida> torcidas = TimePai.toTime(old).getTorcidas();
		List<Jogo> jogos = TimePai.toTime(old).getJogos();
		try {
			if (torcidas != null) {
				for (Torcida to : torcidas)
					this.torcidaSer.removerTorcida(to.getId());
			}
			if (jogos != null) {
				for (Jogo jo : jogos)
					this.jogoSer.removerJogo(jo.getId());
			}
			this.timeRep.delete(old.getId());
		} catch (Exception e) {
			throw new TimeInexistenteException();
		}
	}

	public TimeLong findByOne(Long id) throws TimeInexistenteException {
		TimeLong t = TimeLong.toTimeLong(this.timeRep.findOne(id));
		if (t == null) {
			throw new TimeInexistenteException();
		}
		return t;
	}

	public TimeShort findByNome(String nome) throws TimeInexistenteException {
		TimeShort t = TimeShort.toTimeShort(timeRep.findByNome(nome));
		if (t == null) {
			throw new TimeInexistenteException();
		}
		return t;
	}

	/**
	 * Retorna uma lista com todos os times
	 */
	public List<TimeLong> findAll() {
		List<Time> times = (List<Time>) this.timeRep.findAll();
		List<TimeLong> timeslong = new ArrayList<TimeLong>();

		for (Time time : times) {
			timeslong.add(TimeLong.toTimeLong(time));
		}
		return timeslong;
	}
}