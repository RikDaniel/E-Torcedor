package br.com.etorcedor.ui;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.etorcedor.business.Fachada;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.exception.TorcidaExistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;

@RestController
@RequestMapping("/adm")
public class ControllerAdministracao {

	@Autowired
	private Fachada fachada;

	private static final Logger logger = Logger.getLogger(Controller.class);

	// Não está disponível para usuário comum
	@RequestMapping(value = "/torcida/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarTorcida(Torcida t) {
		try {
			if (t != null) {
				this.fachada.adicionarTorcida(t);
				return new ResponseEntity<String>("Torcida cadastrada com sucesso", HttpStatus.OK);
			} else {
				logger.debug("PARAMETRO NULO OU INVALIDO");
				return new ResponseEntity<String>("CAMPOS EM BRANCO", HttpStatus.BAD_REQUEST);
			}
		} catch (TorcidaExistenteException e) {
			return new ResponseEntity<TorcidaExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// Não está disponível para usuário comum
	@RequestMapping(value = "/torcida/att", method = RequestMethod.POST)
	public ResponseEntity<?> atualizarTorcida(Torcida t) {
		try {
			if (t != null) {
				this.fachada.atualizarTorcida(t);
				return new ResponseEntity<String>("Torcida atualizada com sucesso", HttpStatus.OK);
			} else {
				logger.debug("PARAMETRO NULO OU INVALIDO");
				return new ResponseEntity<String>("CAMPOS EM BRANCO", HttpStatus.BAD_REQUEST);
			}
		} catch (TorcidaInexistenteException e) {
			return new ResponseEntity<TorcidaInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// Não está disponível para usuário comum
	@RequestMapping(value = "/torcida/remov", method = RequestMethod.GET)
	public ResponseEntity<?> removerTorcida(Long id) {
		try {
			if (id != null && id >= 1) {
				this.fachada.removerTorcida(id);
				return new ResponseEntity<String>("Torcida removida com sucesso", HttpStatus.OK);
			} else {
				logger.debug("PARAMETRO NULO OU INVALIDO");
				return new ResponseEntity<String>("ID INVALIDO", HttpStatus.BAD_REQUEST);
			}
		} catch (TorcidaInexistenteException e) {
			return new ResponseEntity<TorcidaInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}
}
