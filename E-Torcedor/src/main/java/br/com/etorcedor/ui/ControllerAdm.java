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
import br.com.etorcedor.entity.odc.DelitoLong;
import br.com.etorcedor.entity.odc.EstadioShort;
import br.com.etorcedor.entity.odc.IngressoShort;
import br.com.etorcedor.entity.odc.JogoLong;
import br.com.etorcedor.entity.odc.SetorShort;
import br.com.etorcedor.entity.odc.TimeShort;
import br.com.etorcedor.entity.odc.TorcidaShort;
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
	public ResponseEntity<?> adicionarTorcida(@RequestBody TorcidaShort t) {
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
	public ResponseEntity<?> atualizarTorcida(@RequestBody TorcidaShort t) {
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
	public ResponseEntity<?> removerTorcida(Long id) {
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
	public ResponseEntity<?> adicionarTime(@RequestBody TimeShort time) {
		logger.debug(Log.traits(time.toString().length()) + "CADASTRANDO O Time: \n" + time.toString()
		+ Log.traits(time.toString().length()));
		try {
			this.fachada.adicionarTime(time);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (TimeExistenteException e) {
			logger.debug(e.getMessage());
			return new ResponseEntity<TimeExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/time/remov")
	public ResponseEntity<?> removerTime(Long id) {
		try {
			if(id != null && id >= 1) {
				this.fachada.removerTime(id);
				return new ResponseEntity<String>(HttpStatus.OK);
			}
			return new ResponseEntity<String>("ID NULO", HttpStatus.BAD_REQUEST);
		} catch (TimeInexistenteException e) {
			return new ResponseEntity<TimeInexistenteException>(e, HttpStatus.BAD_REQUEST);
		} catch (TorcidaInexistenteException e) {
			return new ResponseEntity<TorcidaInexistenteException>(e, HttpStatus.BAD_REQUEST);
		} catch (JogoInexistenteException e) {
			return new ResponseEntity<JogoInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/time/att", method = RequestMethod.POST)
	public ResponseEntity<?> atualizarTime(@RequestBody  TimeShort time) {
		logger.debug("\n\n\n\n\n" + time.getId()+ time.getNome());
		try {
			this.fachada.atualizarTime(time);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (TimeInexistenteException e) {
			return new ResponseEntity<TimeInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// JOGO

	@RequestMapping(value = "/jogo/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarJogo(@RequestBody JogoLong jogo) {
		try {
			this.fachada.adicionarJogo(jogo);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (JogoExistenteException e) {
			return new ResponseEntity<JogoExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/jogo/att", method = RequestMethod.POST)
	public ResponseEntity<?> atualizarJogo(@RequestBody JogoLong jogo) {
		try {
			this.fachada.atualizarJogo(jogo);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (JogoInexistenteException e) {
			return new ResponseEntity<JogoInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/jogo/remov", method = RequestMethod.GET)
	public ResponseEntity<?> removerJogo(Long id) {
		try {
			this.fachada.removerJogo(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (JogoInexistenteException e) {
			return new ResponseEntity<JogoInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// INGRESSO

	@RequestMapping(value = "/ingresso/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarIngreco(@RequestBody IngressoShort i) {
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
	public ResponseEntity<?> adicionarEstadio(EstadioShort estadio) {
		try {
			this.fachada.adicionarEstadio(estadio);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (EstadioExistenteException e) {
			return new ResponseEntity<EstadioExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/estadio/att", method = RequestMethod.POST)
	public ResponseEntity<?> atualizarEstadio(EstadioShort estadio) {
		try {
			this.fachada.atualizarEstadio(estadio);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (EstadioInexistenteException e) {
			return new ResponseEntity<EstadioInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/estadio/remov", method = RequestMethod.GET)
	public ResponseEntity<?> removerEstadio(Long id) {
		try {
			this.fachada.removerEstadio(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (EstadioInexistenteException e) {
			return new ResponseEntity<EstadioInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// SETOR
	
	@RequestMapping(value = "/setor/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarSetor(@RequestBody SetorShort setor) {
		try {
			this.fachada.adicionarSetor(setor);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (SetorExistenteException e) {
			return new ResponseEntity<SetorExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/setor/att", method = RequestMethod.POST)
	public ResponseEntity<?> atualizarSetor(@RequestBody SetorShort setor) {
		try {
			this.fachada.atualizarSetor(setor);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (SetorInexistenteException e) {
			return new ResponseEntity<SetorInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/setor/remov", method = RequestMethod.GET)
	public ResponseEntity<?> removerSetor(Long id) {
		try {
			this.fachada.removerSetor(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (SetorInexistenteException e) {
			return new ResponseEntity<SetorInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	//DELITO
	@RequestMapping(value = "/delito/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarDelito(@RequestBody DelitoLong delitoLong) {
		try {
			this.fachada.adicionarDelito(delitoLong);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
}
