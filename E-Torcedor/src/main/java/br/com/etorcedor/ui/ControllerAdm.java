package br.com.etorcedor.ui;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.etorcedor.business.Fachada;
import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.exception.EstadioExistenteException;
import br.com.etorcedor.exception.EstadioInexistenteException;
import br.com.etorcedor.exception.IngressoExistenteException;
import br.com.etorcedor.exception.IngressoInexistenteException;
import br.com.etorcedor.exception.JogoExistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.exception.SetorExistenteException;
import br.com.etorcedor.exception.SetorInexistenteException;
import br.com.etorcedor.exception.TimeExistenteException;
import br.com.etorcedor.exception.TimeInexistenteException;
import br.com.etorcedor.exception.TorcidaExistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;

@RestController
@RequestMapping("/adm")

/**
 * Todos os metodos desse controller não estão disponiveis para o usuario comum
 * 
 * @author layon
 *
 */
public class ControllerAdm {

	@Autowired
	private Fachada fachada;

	private static final Logger logger = Logger.getLogger(Controller.class);

	// TORCIDA
	@RequestMapping(value = "/torcida/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarTorcida(@RequestBody Torcida t) {
		try {
			if (t != null) {
				this.fachada.adicionarTorcida(t);
				return new ResponseEntity<String>(HttpStatus.OK);
			} else {
				logger.debug("PARAMETRO NULO OU INVALIDO");
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} catch (TorcidaExistenteException e) {
			return new ResponseEntity<TorcidaExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/torcida/att", method = RequestMethod.POST)
	public ResponseEntity<?> atualizarTorcida(@RequestBody Torcida t) {
		try {
			if (t != null) {
				this.fachada.atualizarTorcida(t);
				return new ResponseEntity<String>(HttpStatus.OK);
			} else {
				logger.debug("PARAMETRO NULO OU INVALIDO");
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} catch (TorcidaInexistenteException e) {
			return new ResponseEntity<TorcidaInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/torcida/remov", method = RequestMethod.GET)
	public ResponseEntity<?> removerTorcida(@RequestBody Long id) {
		try {
			if (id != null && id >= 1) {
				this.fachada.removerTorcida(id);
				return new ResponseEntity<String>(HttpStatus.OK);
			} else {
				logger.debug("PARAMETRO NULO OU INVALIDO");
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} catch (TorcidaInexistenteException e) {
			return new ResponseEntity<TorcidaInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// TIME
	@RequestMapping(value = "/time/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarTime(@RequestBody Time time) {
		try {
			this.fachada.adicionarTime(time);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (TimeExistenteException e) {
			return new ResponseEntity<TimeExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/time/remov", method = RequestMethod.POST)
	public ResponseEntity<?> removerTime(@RequestBody Time time) {
		try {
			this.fachada.removerTime(time);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (TimeInexistenteException e) {
			return new ResponseEntity<TimeInexistenteException>(e, HttpStatus.BAD_REQUEST);
		} catch (TorcidaInexistenteException e) {
			return new ResponseEntity<TorcidaInexistenteException>(e, HttpStatus.BAD_REQUEST);
		} catch (JogoInexistenteException e) {
			return new ResponseEntity<JogoInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/time/att", method = RequestMethod.POST)
	public ResponseEntity<?> atualizarTime(@RequestBody Time time) {
		try {
			this.fachada.atualizarTime(time);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (TimeInexistenteException e) {
			return new ResponseEntity<TimeInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// JOGO

	@RequestMapping(value = "/jogo/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarJogo(@RequestBody Jogo jogo) {
		try {
			this.fachada.adicionarJogo(jogo);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (JogoExistenteException e) {
			return new ResponseEntity<JogoExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/jogo/att", method = RequestMethod.POST)
	public ResponseEntity<?> atualizarJogo(@RequestBody Jogo jogo) {
		try {
			this.fachada.atualizarJogo(jogo);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (JogoInexistenteException e) {
			return new ResponseEntity<JogoInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/jogo/remov", method = RequestMethod.POST)
	public ResponseEntity<?> removerJogo(@RequestBody Jogo jogo) {
		try {
			this.fachada.removerJogo(jogo);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (JogoInexistenteException e) {
			return new ResponseEntity<JogoInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// INGRESSO

	@RequestMapping(value = "/ingresso/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarIngreco(@RequestBody Ingresso i) {
		try {
			this.fachada.adicionarIngreco(i);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (IngressoExistenteException e) {
			return new ResponseEntity<IngressoExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/ingresso/remov", method = RequestMethod.POST)
	public ResponseEntity<?> removerIngreco(@RequestBody Long i) {
		try {
			this.fachada.removerIngreco(i);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (IngressoInexistenteException e) {
			return new ResponseEntity<IngressoInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// ESTADIO

	@RequestMapping(value = "/estadio/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarEstadio(Estadio estadio) {
		try {
			this.fachada.adicionarEstadio(estadio);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (EstadioExistenteException e) {
			return new ResponseEntity<EstadioExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/estadio/att", method = RequestMethod.POST)
	public ResponseEntity<?> atualizarEstadio(Estadio estadio) {
		try {
			this.fachada.atualizarEstadio(estadio);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (EstadioInexistenteException e) {
			return new ResponseEntity<EstadioInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/estadio/remov", method = RequestMethod.POST)
	public ResponseEntity<?> removerEstadio(Estadio estadio) {
		try {
			this.fachada.removerEstadio(estadio);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (EstadioInexistenteException e) {
			return new ResponseEntity<EstadioInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// SETOR
	
	@RequestMapping(value = "/setor/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarSetor(Setor setor) {
		try {
			this.fachada.adicionarSetor(setor);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (SetorExistenteException e) {
			return new ResponseEntity<SetorExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/setor/att", method = RequestMethod.POST)
	public ResponseEntity<?> atualizarSetor(Setor setor) {
		try {
			this.fachada.atualizarSetor(setor);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (SetorInexistenteException e) {
			return new ResponseEntity<SetorInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/setor/remov", method = RequestMethod.POST)
	public ResponseEntity<?> removerSetor(Setor setor) {
		try {
			this.fachada.removerSetor(setor);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (SetorInexistenteException e) {
			return new ResponseEntity<SetorInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}
}
