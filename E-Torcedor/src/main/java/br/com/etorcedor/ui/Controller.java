package br.com.etorcedor.ui;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etorcedor.business.Fachada;
import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.exception.EstadioInexistenteException;
import br.com.etorcedor.exception.IngressoInexistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.exception.SetorInexistenteException;
import br.com.etorcedor.exception.TimeInexistenteException;
import br.com.etorcedor.exception.TorcidaExistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;
import br.com.etorcedor.exception.UsuarioInexistenteException;

@RestController
@RequestMapping("/etorcedor")
public class Controller {

	@Autowired
	private Fachada fachada;

	@RequestMapping("/usuario/add")
	public ResponseEntity<?> adicionarUsuario(Usuario u) {

		try {

			this.fachada.adicionarUsuario(u);

		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping("/usuario/att")
	public ResponseEntity<?> atualizarUsuario(Usuario u) {

		try {
			this.fachada.atualizarUsuario(u);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping("/usuario/remov")
	public ResponseEntity<?> removerUsuario(Long id) {

		try {
			this.fachada.removerUsuario(id);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/usuario/find/cpf", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario findByCpf(String cpf) {
		try {
			return this.fachada.findByCpf(cpf);
		} catch (UsuarioInexistenteException e) {
			return null;
		}
	}

	@RequestMapping(value = "/usuario/find/email", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario findByEmail(String email) {
		try {
			return this.fachada.findByEmail(email);
		} catch (UsuarioInexistenteException e) {
			return null;
		}
	}

	@RequestMapping(value = "/usuario/find/nome/orderly", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> findByNomeOrderByNomeAsc(String nome) {
		return this.fachada.findByNomeOrderByNomeAsc(nome);
	}

	@RequestMapping(value = "/usuario/find/nome/contain", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> usuarioFindByNomeContaining(String nome) {
		return this.fachada.usuarioFindByNomeContaining(nome);
	}

	@RequestMapping(value = "/usuario/find/nome/start", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> usuarioFindByNomeStartingWith(String nome) {
		return this.fachada.usuarioFindByNomeStartingWith(nome);
	}

	@RequestMapping(value = "/usuario/find/clube", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> findByClubeOrderByNomeAsc(Time clube) {
		return this.fachada.findByClubeOrderByNomeAsc(clube);
	}

	@RequestMapping("/usuario/find/torcida")
	public List<Usuario> findByTorcidaOrderByNomeAsc(Torcida torcida) {
		return this.fachada.findByTorcidaOrderByNomeAsc(torcida);
	}

	// TORCIDA
	@RequestMapping("/torcida/add")
	public ResponseEntity<?> adicionarTorcida(Torcida t) {
		try {
			this.fachada.adicionarTorcida(t);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping("/torcida/att")
	public ResponseEntity<?> atualizarTorcida(Torcida t) {
		try {
			this.fachada.atualizarTorcida(t);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping("/torcida/remov")
	public ResponseEntity<?> removerTorcida(Long id) {

		try {
			this.fachada.removerTorcida(id);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/torcida/find/nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public Torcida torcidaFindByNome(String nome) {
		try {
			return this.fachada.torcidaFindByNome(nome);
		} catch (TorcidaInexistenteException e) {
			return null ;
		}
	}

	@RequestMapping(value = "/torcida/find/nome/contain", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Torcida> torcidaFindByNomeContaining(String nome) {
		return this.fachada.torcidaFindByNomeContaining(nome);
	}

	@RequestMapping(value = "/torcida/find/nome/start", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Torcida> torcidaFindByNomeStartingWith(String nome) {
		return this.fachada.torcidaFindByNomeStartingWith(nome);
	}

	@RequestMapping(value = "/torcida/find/nome/orderly/asc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Torcida> torcidaFindByNomeOrderByNomeAsc(String nome) {
		return this.fachada.torcidaFindByNomeOrderByNomeAsc(nome);
	}

	@RequestMapping(value = "/torcida/find/nome/orderly/desc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Torcida> findByNomeOrderByNomeDesc(String nome) {
		return this.fachada.findByNomeOrderByNomeDesc(nome);
	}

	@RequestMapping(value = "/torcida/find/time", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Torcida> findByTime(Time time) {
		return this.fachada.findByTime(time);
	}

	@RequestMapping(value = "/torcida/find/time/ordely/asc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Torcida> findByTimeOrderByNomeAsc(Time time) {
		return this.fachada.findByTimeOrderByNomeAsc(time);
	}

	@RequestMapping(value = "/torcida/find/time/ordely/desc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Torcida> findByTimeOrderByNomeDesc(Time time) {
		return this.fachada.findByTimeOrderByNomeDesc(time);
	}

	// TIME

	@RequestMapping(value = "/time/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public Time findByOne(Long id) {
		try {
			return this.fachada.findByOne(id);
		} catch (TimeInexistenteException e) {
			return null;
		}
	}

	@RequestMapping(value = "/time/find/nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public Time timeFindByNome(String nome) {
		try {
			return this.fachada.timeFindByNome(nome);
		} catch (TimeInexistenteException e) {
			return null;
		}
	}

	@RequestMapping(value = "/time/find/nome/start", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Time> timeFindByNomeStartingWith(String nome) {
		return this.fachada.timeFindByNomeStartingWith(nome);
	}

	@RequestMapping(value = "/time/find/nome/contain", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Time> timeFByNomeContaining(String nome) {
		return this.fachada.timeFByNomeContaining(nome);
	}

	// JOGO

	@RequestMapping(value = "/jogo/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public Jogo findOneJogo(Long id) {
		try {
			return this.fachada.findOneJogo(id);
		} catch (JogoInexistenteException e) {
			return null;
		}
	}

	@RequestMapping(value = "/jogo/find/data", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Jogo> findByDataJogo(Date data) {
		return this.fachada.findByDataJogo(data);
	}

	@RequestMapping(value = "/jogo/find/data/asc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Jogo> findByDataOrderByDataAsc(Date data) {
		return this.fachada.findByDataOrderByDataAsc(data);
	}

	@RequestMapping(value = "/jogo/find/data/desc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Jogo> findByDataOrderByDataDesc(Date data) {
		return this.fachada.findByDataOrderByDataDesc(data);
	}

	@RequestMapping(value = "/jogo/find/estadio", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Jogo> findByEstadio(Estadio estadio) {
		return this.fachada.findByEstadio(estadio);
	}

	@RequestMapping(value = "/jogo/find/estadio/data/asc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Jogo> findByEstadioOrderByDataAsc(Estadio estadio) {
		return this.fachada.findByEstadioOrderByDataAsc(estadio);
	}

	@RequestMapping(value = "/jogo/find/estadio/data/desc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Jogo> findByEstadioOrderByDataDesc(Estadio estadio) {
		return this.fachada.findByEstadioOrderByDataDesc(estadio);
	}

	//INGRESSO
	
	@RequestMapping("/ingresso/add")
	public ResponseEntity<?> adicionarIngreco(Ingresso i){		
		try {
			this.fachada.adicionarIngreco(i);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping("/ingresso/att")
	public ResponseEntity<?> atualizarIngreco(Ingresso i){
		try {
			this.fachada.atualizarIngreco(i);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping("/ingresso/remov")
	public ResponseEntity<?> removerIngreco(Ingresso i){
		try {
			this.fachada.removerIngreco(i.getId());
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ingresso/find/jogo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ingresso> findByJogo(Jogo jogo){
		return this.fachada.findByJogo(jogo);
	}
	
	@RequestMapping(value = "/ingresso/find/data", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ingresso> findByDataIngresso(Date data){
		return this.fachada.findByDataIngresso(data);
	}
	
	@RequestMapping(value = "/ingresso/find/acento", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ingresso> findByNumeroAcento(int numeroAcento){
		return this.fachada.findByNumeroAcento(numeroAcento);
	}
	
	@RequestMapping(value = "/ingresso/find/acento/setor/ordely/asc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ingresso> findByNumeroAcentoAndSetorOrderByDataAsc(int numeroAcento, Setor setor){
		return this.fachada.findByNumeroAcentoAndSetorOrderByDataAsc(numeroAcento, setor);
	}
	
	@RequestMapping(value = "/ingresso/find/acento/setor/jogo/ordely/asc", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ingresso findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(int numeroAcento, Setor setor, Jogo jogo){
		try {
			return this.fachada.findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(numeroAcento, setor, jogo);
		} catch (IngressoInexistenteException e) {
			return null;
		}
	}
	
	@RequestMapping(value = "/ingresso/find/jogo/ordely/asc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ingresso> findByJogoOrderByDataAsc(Jogo jogo){
		return this.fachada.findByJogoOrderByDataAsc(jogo);
	}
	
	@RequestMapping(value = "/ingresso/find/jogo/ordely/desc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ingresso> findByJogoOrderByDataDesc(Jogo jogo){
		return this.fachada.findByJogoOrderByDataDesc(jogo);
	}
 	
	@RequestMapping(value = "/ingresso/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ingresso findOneIngresso(Long id){
		try {
			return this.fachada.findOneIngresso(id);
		} catch (IngressoInexistenteException e) {
			return null;
		}		
	}
	
	//Estadio
	
	@RequestMapping(value = "/estadio/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public Estadio findOneEstadio(Long id){
		try {
			return this.fachada.findOneEstadio(id);
		} catch (EstadioInexistenteException e) {
			return null;
		}
	}
	
	
	//Setor
	
	@RequestMapping(value = "/setor/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public Setor findOneSetor(Long id){
		try {
			return this.fachada.findOneSetor(id);
		} catch (SetorInexistenteException e) {
			return null;
		}
	}
	
	@RequestMapping(value = "/setor/find/nome",  produces = MediaType.APPLICATION_JSON_VALUE)
	public Setor findByNome(String nome){
		try {
			return this.fachada.findByNome(nome);
		} catch (SetorInexistenteException e) {
			return null;
		}
	}
 	
	@RequestMapping(value = "/setor/find/nome/start", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Setor> findByNomeStartingWith(String nome){
		return this.fachada.findByNomeStartingWith(nome);
	}
	
	@RequestMapping(value = "/setor/find/nome/contain", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Setor> findByNomeContaining(String nome){
		return this.fachada.findByNomeContaining(nome);
	}
}