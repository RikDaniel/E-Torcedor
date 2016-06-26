package br.com.etorcedor.ui;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.etorcedor.business.Fachada;
import br.com.etorcedor.entity.Compra;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.entity.odc.DelitoLong;
import br.com.etorcedor.entity.odc.DelitoShort;
import br.com.etorcedor.entity.odc.EstadioShort;
import br.com.etorcedor.entity.odc.IngressoShort;
import br.com.etorcedor.entity.odc.JogoLong;
import br.com.etorcedor.entity.odc.JogoShort;
import br.com.etorcedor.entity.odc.SetorShort;
import br.com.etorcedor.entity.odc.TimeLong;
import br.com.etorcedor.entity.odc.TimeShort;
import br.com.etorcedor.entity.odc.TorcidaShort;
import br.com.etorcedor.entity.odc.UsuarioLong;
import br.com.etorcedor.entity.odc.UsuarioShort;
import br.com.etorcedor.exception.DelitoExistenteException;
import br.com.etorcedor.exception.DelitoNaoEncontradoException;
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

	// USUARIO

	@RequestMapping(value = "/usuario/add", method = RequestMethod.POST)
	public ResponseEntity<?> adicionarUsuario(@RequestBody UsuarioShort u) {

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
	public ResponseEntity<?> atualizarUsuario(UsuarioShort u) {
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
				UsuarioShort usuario = this.fachada.findByCpf(cpf);
				return new ResponseEntity<UsuarioShort>(usuario, HttpStatus.OK);
			} else {
				logger.debug("PARAMETRO INVALIDO");
				return new ResponseEntity<String>("CPF INVALIDO", HttpStatus.BAD_REQUEST);
			}
		} catch (UsuarioInexistenteException e) {
			return new ResponseEntity<UsuarioInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/usuario/find/email", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<?> findByEmail(String email) {
		logger.debug("\n\n\n\n\n" + email);
		try {
			if (email != null) {
				if (email.contains("@")) {
					UsuarioLong usuario = this.fachada.findByEmail(email);
					return new ResponseEntity<UsuarioLong>(usuario, HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("EMAIL INVALIDO", HttpStatus.BAD_REQUEST);
				}
			}else {
				return new ResponseEntity<String>("EMAIL NULO", HttpStatus.BAD_REQUEST);			
			}
		} catch (UsuarioInexistenteException e) {
			return new ResponseEntity<UsuarioInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/usuario/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UsuarioLong> findByAllUser() {
		return this.fachada.findAllUsuario();
	}

	// TORCIDA

	@RequestMapping(value = "/torcida/find/nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> torcidaFindByNome(String nome) {
		try {
			if (nome != null) {
				TorcidaShort torcida = this.fachada.torcidaFindByNome(nome);
				return new ResponseEntity<TorcidaShort>(torcida, HttpStatus.OK);
			} else {
				logger.debug("PARAMETRO NULO OU INVALIDO");
				return new ResponseEntity<String>("NOME INVALIDO", HttpStatus.BAD_REQUEST);
			}
		} catch (TorcidaInexistenteException e) {
			return new ResponseEntity<String>("TORCIDA INEXISTENTE", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/torcida/find/time", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TorcidaShort> findByTime(String nomeTime) {
		if (nomeTime != null) {
			try {
				return this.fachada.findByTime(TimeShort.toTime(this.fachada.timeFindByNome(nomeTime)));
			} catch (TimeInexistenteException e) {
			}
		}
		return null;
	}

	@RequestMapping(value = "/torcida/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TorcidaShort> findAllTorcida() {
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
				return this.fachada.findByEstadio(EstadioShort.toEstadio(this.fachada.findByNomeEstadio(nomeEstadio)));
			} else
				return null;
		} catch (EstadioInexistenteException e) {
			return null;
		}
	}

	// INGRESSO

	@RequestMapping(value = "/ingresso/find/jogo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<IngressoShort> findByJogo(Jogo jogo) {
		if (jogo != null)
			return this.fachada.findByJogo(jogo);
		else
			return null;
	}

	@RequestMapping(value = "/ingresso/find/data", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<IngressoShort> findByDataIngresso(Date data) {
		if (data != null)
			return this.fachada.findByDataIngresso(data);
		else
			return null;
	}

	@RequestMapping(value = "/ingresso/find/acento", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<IngressoShort> findByNumeroAcento(int numeroAcento) {
		if (numeroAcento >= 1)
			return this.fachada.findByNumeroAcento(numeroAcento);
		else
			return null;
	}

	@RequestMapping(value = "/ingresso/find/one", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findOneIngresso(Long id) {
		try {
			if (id != null && id >= 1) {
				IngressoShort ingresso = this.fachada.findOneIngresso(id);
				return new ResponseEntity<IngressoShort>(ingresso, HttpStatus.OK);
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
				EstadioShort estadio = this.fachada.findOneEstadio(id);
				return new ResponseEntity<EstadioShort>(estadio, HttpStatus.OK);
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
				EstadioShort estadio = this.fachada.findByNomeEstadio(nome);
				if (estadio == null)
					estadio = this.fachada.findByApelido(nome);
				return new ResponseEntity<EstadioShort>(estadio, HttpStatus.OK);
			} else
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (EstadioInexistenteException e) {
			return new ResponseEntity<String>("Estadio Inexistente", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/estadio/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EstadioShort> findAllEstadio() {
		return this.fachada.findAllEstadio();
	}

	// SETOR
	@RequestMapping(value = "/setor/find/one", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findOneSetor(Long id) {
		try {
			if (id != null && id >= 1) {
				SetorShort setor = this.fachada.findOneSetor(id);
				return new ResponseEntity<SetorShort>(setor, HttpStatus.OK);
			} else
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (SetorInexistenteException e) {
			return new ResponseEntity<SetorInexistenteException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/setor/find/nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SetorShort> findByNome(String nome) {
		try {
			return this.fachada.findByNome(nome);

		} catch (SetorInexistenteException e) {
			return null;
		}
	}

	@RequestMapping(value = "/setor/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SetorShort> findAllSetor() {
		return this.fachada.findAllSetores();
	}

	// COMPRA

	@RequestMapping(value = "/compra/ingresso")
	public ResponseEntity<?> compraIngresso(String cpf, Long idIngresso) {
		Compra compra;
		Date dia = new Date();
		List<Ingresso> ingressos = new ArrayList<Ingresso>();
		Usuario usuario = new Usuario();

		try {
			usuario = UsuarioShort.toUsuario(this.fachada.findByCpf(cpf));

			ingressos.add(IngressoShort.toIngresso(this.fachada.findOneIngresso(idIngresso)));

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

	@RequestMapping(value = "/compra/find/id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByOneCompra(Long id) {
		Compra compra = this.fachada.findByOneCompra(id);
		return new ResponseEntity<Compra>(compra, HttpStatus.OK);
	}

	@RequestMapping(value = "/compra/find/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Compra> findByUsuario(Long id) {
		return this.fachada.findByUsuario(id);
	}

	@RequestMapping(value = "/compra/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Compra> findByAllCompras() {
		return this.fachada.findByAllCompras();
	}

	// DELITO

	@RequestMapping(value = "/delito/find/bo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByBo(long bo) {

		try {
			DelitoLong delitLong = this.fachada.findByBo(bo);
			return new ResponseEntity<DelitoLong>(delitLong, HttpStatus.OK);
		} catch (DelitoNaoEncontradoException e) {
			return new ResponseEntity<DelitoNaoEncontradoException>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/delito/find/dia", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DelitoShort> findByDia(Date dia) {
		return this.fachada.findByDia(dia);
	}

	@RequestMapping(value = "/delito/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DelitoShort> findAll() {
		return this.fachada.findAll();
	}
}