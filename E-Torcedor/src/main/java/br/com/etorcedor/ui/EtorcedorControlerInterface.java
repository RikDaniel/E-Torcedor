package br.com.etorcedor.ui;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/etorcedor")
public class EtorcedorControlerInterface {

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

	@RequestMapping("/usuario/find/cpf")
	public ResponseEntity<?> findByCpf(String cpf) {

		return this.fachada.findByCpf(cpf);

	}

	@RequestMapping("/usuario/find/email")
	public ResponseEntity<?> findByEmail() {

		return this.fachada.findByEmail(email);

	}

	@RequestMapping("/usuario/find/nome/orderly")
	public ResponseEntity<?> findByNomeOrderByNomeAsc(String nome) {

		return this.fachada.findByNomeOrderByNomeAsc(nome);

	}

	@RequestMapping("/usuario/find/nome/contain")
	public ResponseEntity<?> usuarioFindByNomeContaining(String nome) {

		return this.fachada.usuarioFindByNomeContaining(nome);

	}

	@RequestMapping("/usuario/find/nome/start")
	public ResponseEntity<?> usuarioFindByNomeStartingWith(String nome) {

		return this.fachada.usuarioFindByNomeStartingWith(nome);

	}

	@RequestMapping("/usuario/find/clube")
	public ResponseEntity<?> findByClubeOrderByNomeAsc(Time clube) {

		return this.fachada.findByClubeOrderByNomeAsc(clube);

	}

	@RequestMapping("/usuario/find/torcida")
	public ResponseEntity<?> findByTorcidaOrderByNomeAsc(Torcida torcida) {

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

	@RequestMapping("/torcida/find/nome")
	public ResponseEntity<?> torcidaFindByNome(String nome) {

		return this.fachada.torcidaFindByNome(nome);

	}

	@RequestMapping("/torcida/find/nome/contain")
	public ResponseEntity<?> torcidaFindByNomeContaining(String nome) {

		return this.fachada.torcidaFindByNomeContaining(nome);

	}

	@RequestMapping("/torcida/find/nome/start")
	public ResponseEntity<?> torcidaFindByNomeStartingWith(String nome) {

		return this.fachada.torcidaFindByNomeStartingWith(nome);

	}

	@RequestMapping("/torcida/find/nome/orderly/asc")
	public ResponseEntity<?> torcidaFindByNomeOrderByNomeAsc(String nome) {

		return this.fachada.torcidaFindByNomeOrderByNomeAsc(nome);
	}

	@RequestMapping("/torcida/find/nome/orderly/desc")
	public ResponseEntity<?> findByNomeOrderByNomeDesc(String nome) {

		return this.fachada.findByNomeOrderByNomeDesc(nome);

	}

	@RequestMapping("/torcida/find/time")
	public ResponseEntity<?> findByTime(Time time) {

		return this.fachada.findByTime(time);

	}

	@RequestMapping("/torcida/find/time/ordely/asc")
	public ResponseEntity<?> findByTimeOrderByNomeAsc(Time time) {

		return this.fachada.findByTimeOrderByNomeAsc(time);

	}

	@RequestMapping("/torcida/find/time/ordely/desc")
	public ResponseEntity<?> findByTimeOrderByNomeDesc(Time time) {

		return this.fachada.findByTimeOrderByNomeDesc(time);

	}

	// TIME

	@RequestMapping("/time/find")
	public ResponseEntity<?> findByOne(Long id) {

		return this.fachada.findByOne(id);

	}

	@RequestMapping("/time/find/nome")
	public ResponseEntity<?> timeFindByNome(String nome) {

		return this.fachada.timeFindByNome(nome);

	}

	@RequestMapping("/time/find/nome/start")
	public ResponseEntity<?> timeFindByNomeStartingWith(String nome) {

		return this.fachada.timeFindByNomeStartingWith(nome);

	}

	@RequestMapping("/time/find/nome/contain")
	public ResponseEntity<?> timeFByNomeContaining(String nome) {

		return this.fachada.timeFByNomeContaining(nome);

	}

	// JOGO

	@RequestMapping("/jogo/find")
	public ResponseEntity<?> findOneJogo(Long id) {

		return this.fachada.findOneJogo(id);

	}

	@RequestMapping("/jogo/find/data")
	public ResponseEntity<?> findByDataJogo(Date data) {

		return this.fachada.findByDataJogo(data);
	}

	@RequestMapping("/jogo/find/data/asc")
	public ResponseEntity<?> findByDataOrderByDataAsc(Date data) {

		return this.fachada.findByDataOrderByDataAsc(data);
	}

	@RequestMapping("/jogo/find/data/desc")
	public RequestEntity<?> findByDataOrderByDataDesc(Date data) {

		return this.fachada.findByDataOrderByDataDesc(data);

	}

	@RequestMapping("/jogo/find/estadio")
	public ResponseEntity<?> findByEstadio(Estadio estadio) {

		return this.fachada.findByEstadio(estadio);

	}

	@RequestMapping("/jogo/find/estadio/data/asc")
	public ResponseEntity<?> findByEstadioOrderByDataAsc(Estadio estadio) {

		return this.fachada.findByEstadioOrderByDataAsc(estadio);

	}

	@RequestMapping("/jogo/find/estadio/data/desc")
	public ResponseEntity<?> findByEstadioOrderByDataDesc(Estadio estadio) {

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
			this.fachada.removerIngreco(i);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping("/ingresso/find/jogo")
	public ResponseEntity<?> findByJogo(Jogo jogo){
		
		return this.fachada.findByJogo(jogo);
	
	}
	
	@RequestMapping("/ingresso/find/data")
	public ResponseEntity<?> findByDataIngresso(Date data){
		
		return this.fachada.findByDataIngresso(data);
		
	}
	
	@RequestMapping("/ingresso/find/acento")
	public ResponseEntity<?> findByNumeroAcento(int numeroAcento){
		
		return this.fachada.findByNumeroAcento(numeroAcento);
		
	}
	
	@RequestMapping("/ingresso/find/acento/setor/ordely/asc")
	public ResponseEntity<?> findByNumeroAcentoAndSetorOrderByDataAsc(int numeroAcento, Setor setor){
		
		return this.fachada.findByNumeroAcentoAndSetorOrderByDataAsc(numeroAcento, setor);
		
	}
	
	@RequestMapping("/ingresso/find/acento/setor/jogo/ordely/asc")
	public ResponseEntity<?> findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(int numeroAcento, Setor setor, Jogo jogo){
		
		return this.fachada.findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(numeroAcento, setor, jogo);
		
	}
	
	@RequestMapping("/ingresso/find/jogo/ordely/asc")
	public ResponseEntity<?> findByJogoOrderByDataAsc(Jogo jogo){
		
		return this.fachada.findByJogoOrderByDataAsc(jogo);
		
	}
	
	@RequestMapping("/ingresso/find/jogo/ordely/desc")
	public ResponseEntity<?> findByJogoOrderByDataDesc(Jogo jogo){
		
		return this.fachada.findByJogoOrderByDataDesc(jogo);
		
	}
 	
	@RequestMapping("/ingresso/find")
	public ResponseEntity<?> findOneIngresso(){
		
		return this.fachada.findOneIngresso(id);
		
	}
	
	//Estadio
	
	@RequestMapping("/estadio/find")
	public ResponseEntity<?> findOneEstadio(Long id){
		
		return this.fachada.findOneEstadio(id);
	}
	
	
	//Setor
	
	@RequestMapping("/setor/find")
	public ResponseEntity<?> findOneSetor(Long id){
		
		return this.fachada.findOneSetor(id);
	}
	
	@RequestMapping("/setor/find/nome")
	public ResponseEntity<?> findByNome(String nome){
		
		return this.fachada.findByNome(nome);
		
	}
 	
	@RequestMapping("/setor/find/nome/start")
	public ResponseEntity<?> findByNomeStartingWith(){
		
		return this.fachada.findByNomeStartingWith(nome);
		
	}
	
	@RequestMapping("/setor/find/nome/contain")
	public ResponseEntity<?> findByNomeContaining(){
		
		return this.fachada.findByNomeContaining(nome);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
