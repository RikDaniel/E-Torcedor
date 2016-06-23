package br.com.etorcedor.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.etorcedor.business.Fachada;
import br.com.etorcedor.entity.Compra;
import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.entity.odc.JogoLong;
import br.com.etorcedor.entity.odc.JogoShort;
import br.com.etorcedor.entity.odc.TimeLong;
import br.com.etorcedor.entity.odc.TimeShort;
import br.com.etorcedor.exception.DelitoExistenteException;
import br.com.etorcedor.exception.EstadioInexistenteException;
import br.com.etorcedor.exception.IngressoInexistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.exception.SetorInexistenteException;
import br.com.etorcedor.exception.TimeInexistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;
import br.com.etorcedor.exception.UsuarioExistenteException;
import br.com.etorcedor.exception.UsuarioInexistenteException;

@RestController
@RequestMapping("/")
public class Controller {

	private static final Logger logger = Logger.getLogger(Controller.class);

	@Autowired
	private Fachada fachada;

	@RequestMapping(value = "/usuario/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarUsuario(@RequestBody Usuario u) {

		logger.debug(Log.traits(u.toString().length()) + "CADASTRANDO O USUARIO: \n" + u.toString()
				+ Log.traits(u.toString().length()));
		try {
			if (u.getNome() != null)

				this.fachada.adicionarUsuario(u);
			else {
				logger.debug("PARAMETRO NULO OU INEXISTENTE");
				return new ResponseEntity<String>("CAMPOS EM BRANCO", HttpStatus.BAD_REQUEST);
			}
		} catch (UsuarioExistenteException e) {
			return new ResponseEntity<UsuarioExistenteException>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Usuario: " + u.toString() + "Cadastrado com sucesso", HttpStatus.OK);
	}

	@RequestMapping(value = "/usuario/att", method = RequestMethod.POST)
	public ResponseEntity<?> atualizarUsuario(Usuario u) {
		logger.debug(Log.traits(u.toString().length()) + "ATUALIZANDO O USUARIO: \n" + u.toString()
				+ Log.traits(u.toString().length()));
		try {
			if (u.getNome() != null)
				this.fachada.atualizarUsuario(u);
			else {
				logger.debug("PARAMETRO NULO OU INVALIDO");
				return new ResponseEntity<String>("CAMPOS EM BRANCO", HttpStatus.BAD_REQUEST);
			}
		} catch (UsuarioInexistenteException e) {
			return new ResponseEntity<UsuarioInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Usuario atualizado com sucesso", HttpStatus.OK);
	}

	@RequestMapping(value = "/usuario/remov", method = RequestMethod.GET)
	public ResponseEntity<?> removerUsuario(Long id) {
		logger.debug(Log.traits(30) + "TENTANDO REMOVER O USUARIO: \n" + id + Log.traits(30));
		try {
			if (id != null && id >= 1)
				this.fachada.removerUsuario(id);
			else {
				logger.debug("PARAMETRO INVALIDO");
				return new ResponseEntity<String>("ID INVALIDO", HttpStatus.BAD_REQUEST);
			}
		} catch (UsuarioInexistenteException e) {
			return new ResponseEntity<UsuarioInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Usuario removido com sucesso !!!", HttpStatus.OK);
	}

	@RequestMapping(value = "/usuario/find/cpf", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByCpf(String cpf) {
		try {
			if ((cpf != null) && (cpf.length() <= 12)) {
				Usuario usuario = this.fachada.findByCpf(cpf);
				return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
			} else {
				logger.debug("PARAMETRO INVALIDO");
				return new ResponseEntity<String>("CPF INVALIDO", HttpStatus.BAD_REQUEST);
			}
		} catch (UsuarioInexistenteException e) {
			return new ResponseEntity<UsuarioInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/usuario/find/email", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByEmail(String email) {
		try {
			if (email.contains("@")) {
				Usuario usuario = this.fachada.findByEmail(email);
				return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
			} else {
				logger.debug("PARAMETRO INVALIDO");
				return new ResponseEntity<String>("EMAIL INVALIDO", HttpStatus.BAD_REQUEST);
			}
		} catch (UsuarioInexistenteException e) {
			return new ResponseEntity<UsuarioInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/usuario/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> findByAllUser() {
		return this.fachada.findAllUsuario();
	}

	@RequestMapping(value = "/torcida/find/nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> torcidaFindByNome(String nome) {
		try {
			if (nome != null) {
				Torcida torcida = this.fachada.torcidaFindByNome(nome);
				return new ResponseEntity<Torcida>(torcida, HttpStatus.OK);
			} else {
				logger.debug("PARAMETRO NULO OU INVALIDO");
				return new ResponseEntity<String>("NOME INVALIDO", HttpStatus.BAD_REQUEST);
			}
		} catch (TorcidaInexistenteException e) {
			return new ResponseEntity<TorcidaInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/torcida/find/time", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Torcida> findByTime(String nomeTime) {
		if (nomeTime != null) {
			try {
				return this.fachada.findByTime(TimeShort.toTime(this.fachada.timeFindByNome(nomeTime)));
			} catch (TimeInexistenteException e) {
			}
		}
		return null;
	}

	@RequestMapping(value = "/torcida/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Torcida> findAllTorcida() {
		return this.fachada.findAllTorcida();
	}

	// TIME

	@RequestMapping(value = "/time/find/one", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByOne(Long id) {
		try {
			if (id != null && id >= 1) {
				TimeLong timelong = this.fachada.findByOne(id);
				return new ResponseEntity<TimeLong>(timelong, HttpStatus.OK);
			} else
				return new ResponseEntity<String>("DADOS INVALIDOS", HttpStatus.BAD_REQUEST);
		} catch (TimeInexistenteException e) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/time/find/nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> timeFindByNome(String nome) {
		try {
			if (nome != null) {
				TimeShort timeshort = this.fachada.timeFindByNome(nome);
				return new ResponseEntity<TimeShort>(timeshort, HttpStatus.OK);
			} else
				return new ResponseEntity<String>("DADOS INVALIDOS", HttpStatus.BAD_REQUEST);
		} catch (TimeInexistenteException e) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/time/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TimeLong> findAllTime() {
		return this.fachada.findAllTime();
	}

	// JOGO

	@RequestMapping(value = "/jogo/find/one", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findOneJogo(Long id) {
		try {
			if (id != null && id >= 1) {
				JogoLong jogolong = this.fachada.findOneJogo(id);
				return new ResponseEntity<JogoLong>(jogolong, HttpStatus.OK);
			} else
				return new ResponseEntity<String>("DADOS INVALIDOS", HttpStatus.BAD_REQUEST);
		} catch (JogoInexistenteException e) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/jogo/find/data", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JogoShort> findByDataJogo(Date dia) {

		if (dia != null)
			return this.fachada.findByDataJogo(dia);
		else
			return null;
	}

	@RequestMapping(value = "/jogo/find/estadio", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JogoShort> findByEstadio(String nomeEstadio) {
		try {
			
			if (nomeEstadio != null) {
				return this.fachada.findByEstadio(this.fachada.findByNomeEstadio(nomeEstadio));
			} else
				return null;
		} catch (EstadioInexistenteException e) {
			return null;
		}
	}

	// INGRESSO

	@RequestMapping(value = "/ingresso/find/jogo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ingresso> findByJogo(Jogo jogo) {
		if (jogo != null)
			return this.fachada.findByJogo(jogo);
		else
			return null;
	}

	@RequestMapping(value = "/ingresso/find/data", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ingresso> findByDataIngresso(Date data) {
		if (data != null)
			return this.fachada.findByDataIngresso(data);
		else
			return null;
	}

	@RequestMapping(value = "/ingresso/find/acento", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ingresso> findByNumeroAcento(int numeroAcento) {
		if (numeroAcento >= 1)
			return this.fachada.findByNumeroAcento(numeroAcento);
		else
			return null;
	}

	@RequestMapping(value = "/ingresso/find/one", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findOneIngresso(Long id) {
		try {
			if (id != null && id >= 1) {
				Ingresso ingresso = this.fachada.findOneIngresso(id);
				return new ResponseEntity<Ingresso>(ingresso, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} catch (IngressoInexistenteException e) {
			return new ResponseEntity<IngressoInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// ESTADIO
	@RequestMapping(value = "/estadio/find/one", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findOneEstadio(Long id) {
		try {
			if (id != null && id >= 1) {
				Estadio estadio = this.fachada.findOneEstadio(id);
				return new ResponseEntity<Estadio>(estadio, HttpStatus.OK);
			} else
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (EstadioInexistenteException e) {
			return new ResponseEntity<String>("Estadio Inexistente", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/estadio/find/nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByNomeEstadio(String nome) {
		try {
			if (nome != null) {
				Estadio estadio = this.fachada.findByNomeEstadio(nome);
				if (estadio == null)
					estadio = this.fachada.findByApelido(nome);
				return new ResponseEntity<Estadio>(estadio, HttpStatus.OK);
			} else
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (EstadioInexistenteException e) {
			return new ResponseEntity<String>("Estadio Inexistente", HttpStatus.BAD_REQUEST);
		}
	}

	// SETOR
	@RequestMapping(value = "/setor/find/one", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findOneSetor(Long id) {
		try {
			if (id != null && id >= 1) {
				Setor setor = this.fachada.findOneSetor(id);
				return new ResponseEntity<Setor>(setor, HttpStatus.OK);
			} else
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (SetorInexistenteException e) {
			return new ResponseEntity<SetorInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/setor/find/nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByNome(String nome) {
		try {
			if (nome != null) {
				Setor setor = this.fachada.findByNome(nome);
				return new ResponseEntity<Setor>(setor, HttpStatus.OK);
			} else
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (SetorInexistenteException e) {
			return new ResponseEntity<SetorInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/compra/ingresso")
	public ResponseEntity<?> compraIngresso(String cpf, Long idIngresso) {
		Compra compra;
		Date dia = new Date();
		List<Ingresso> ingressos = new ArrayList<Ingresso>();
		Usuario usuario = new Usuario();

		try {
			usuario = this.fachada.findByCpf(cpf);

			ingressos.add(this.fachada.findOneIngresso(idIngresso));

			compra = new Compra(dia, usuario, ingressos);
			this.fachada.adicionarComprar(compra);
			return new ResponseEntity<String>("Compra Realizada com Sucesso", HttpStatus.OK);
		} catch (UsuarioInexistenteException e) {
			return new ResponseEntity<UsuarioInexistenteException>(e, HttpStatus.BAD_REQUEST);
		} catch (IngressoInexistenteException e) {
			return new ResponseEntity<IngressoInexistenteException>(e, HttpStatus.BAD_REQUEST);
		} catch (DelitoExistenteException e) {
			return new ResponseEntity<DelitoExistenteException>(e, HttpStatus.BAD_REQUEST);
		} catch (JogoInexistenteException e) {
			return new ResponseEntity<JogoInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}
}