package br.com.etorcedor.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.exception.EstadioInexistenteException;
import br.com.etorcedor.exception.IngressoExistenteException;
import br.com.etorcedor.exception.IngressoInexistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;
import br.com.etorcedor.exception.SetorInexistenteException;
import br.com.etorcedor.exception.TimeInexistenteException;
import br.com.etorcedor.exception.TorcidaExistenteException;
import br.com.etorcedor.exception.TorcidaInexistenteException;
import br.com.etorcedor.exception.UsuarioExistenteException;
import br.com.etorcedor.exception.UsuarioInexistenteException;

@Service
public class FachadaImpl implements Fachada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3823897062337010663L;

	@Autowired
	private ServiceUsuario usuarioServ;

	@Autowired
	private ServiceTorcida torcidaServ;

	@Autowired
	private ServiceTime timeServ;

	@Autowired
	private ServiceJogo jogoServ;

	@Autowired
	private ServiceEstadio estadioServ;

	//Usuario

	public void adicionarUsuario(Usuario u) throws UsuarioExistenteException {
		this.usuarioServ.adicionarUsuario(u);
	}

	public void atualizarUsuario(Usuario u) throws UsuarioInexistenteException {
		this.usuarioServ.atualizarUsuario(u);
	}

	public void removerUsuario(Long id) throws UsuarioInexistenteException {
		this.usuarioServ.removerUsuario(id);
	}

	public Usuario findByCpf(String cpf) throws UsuarioInexistenteException {
		return this.usuarioServ.findByCpf(cpf);
	}

	public Usuario findByEmail(String email) throws UsuarioInexistenteException {
		return this.usuarioServ.findByEmail(email);
	}

	public List<Usuario> findByNomeOrderByNomeAsc(String nome) {
		return this.usuarioServ.findByNomeOrderByNomeAsc(nome);
	}

	public List<Usuario> usuarioFindByNomeContaining(String nome) {
		return this.usuarioServ.findByNomeContaining(nome);
	}

	public List<Usuario> usuarioFindByNomeStartingWith(String nome) {
		return this.usuarioServ.findByNomeStartingWith(nome);
	}

	public List<Usuario> findByClubeOrderByNomeAsc(Time clube) {
		return this.usuarioServ.findByClubeOrderByNomeAsc(clube);
	}

	public List<Usuario> findByTorcidaOrderByNomeAsc(Torcida torcida) {
		return this.usuarioServ.findByTorcidaOrderByNomeAsc(torcida);
	}

	/**
	 * Retorna todos os usuarios do sistema
	 * @return
	 */
	public List<Usuario> findAllUsuario() {
		return this.usuarioServ.findAll();
	}
	//TORCIDA

	public void adicionarTorcida(Torcida t) throws TorcidaExistenteException {
		this.torcidaServ.adicionarTorcida(t);
	}

	public void atualizarTorcida(Torcida t) throws TorcidaInexistenteException {
		this.torcidaServ.atualizarTorcida(t);
	}

	public void removerTorcida(Long id) throws TorcidaInexistenteException {
		this.torcidaServ.removerTorcida(id);
	}

	public Torcida torcidaFindByNome(String nome) throws TorcidaInexistenteException {
		return this.torcidaServ.findByNome(nome);
	}

	public List<Torcida> torcidaFindByNomeContaining(String nome) {
		return this.torcidaServ.findByNomeContaining(nome);
	}

	public List<Torcida> torcidaFindByNomeStartingWith(String nome) {
		return this.torcidaServ.findByNomeStartingWith(nome);
	}

	public List<Torcida> torcidaFindByNomeOrderByNomeAsc(String nome) {
		return this.torcidaServ.findByNomeOrderByNomeAsc(nome);
	}

	public List<Torcida> findByNomeOrderByNomeDesc(String nome) {
		return this.torcidaServ.findByNomeOrderByNomeDesc(nome);
	}

	public List<Torcida> findByTime(Time time) {
		return this.torcidaServ.findByTime(time);
	}

	public List<Torcida> findByTimeOrderByNomeAsc(Time time) {
		return this.torcidaServ.findByTimeOrderByNomeAsc(time);
	}

	public List<Torcida> findByTimeOrderByNomeDesc(Time time) {
		return this.torcidaServ.findByTimeOrderByNomeDesc(time);
	}

	public List<Torcida> findAllTorcida() {
		return this.torcidaServ.findAllTorcida();
	}

	//TIME

	public Time findByOne(Long id) throws TimeInexistenteException {
		return this.timeServ.findByOne(id);
	}

	public Time timeFindByNome(String nome) throws TimeInexistenteException {
		return this.timeServ.findByNome(nome);
	}

	public List<Time> timeFindByNomeStartingWith(String nome) {
		return this.timeServ.findByNomeStartingWith(nome);
	}

	public List<Time> timeFByNomeContaining(String nome) {
		return this.timeServ.findByNomeContaining(nome);
	}

	/**
	 * Retorna uma lista com todos os times
	 */
	public List<Time> findAllTime() {
		return this.timeServ.findAll();
	}

	//JOGO

	public Jogo findOneJogo(Long id) throws JogoInexistenteException {
		return this.jogoServ.findOneJogo(id);
	}

	public List<Jogo> findByDataJogo(Date data) {
		return this.jogoServ.findByDataJogo(data);
	}

	public List<Jogo> findByDataOrderByDataAsc(Date data) {
		return this.jogoServ.findByDataOrderByDataAsc(data);
	}

	public List<Jogo> findByDataOrderByDataDesc(Date data) {
		return this.jogoServ.findByDataOrderByDataDesc(data);
	}

	public List<Jogo> findByEstadio(Estadio estadio) {
		return this.jogoServ.findByEstadio(estadio);
	}

	public List<Jogo> findByEstadioOrderByDataAsc(Estadio estadio) {
		return this.jogoServ.findByEstadioOrderByDataAsc(estadio);
	}

	public List<Jogo> findByEstadioOrderByDataDesc(Estadio estadio) {
		return this.jogoServ.findByEstadioOrderByDataDesc(estadio);
	}

	public List<Jogo> findAllJogo() {
		return this.jogoServ.findAllJogo();
	}

	//INGRESSO
	public void adicionarIngreco(Ingresso i) throws IngressoExistenteException {
		this.jogoServ.adicionarIngreco(i);
	}

	public void atualizarIngreco(Ingresso i) throws IngressoInexistenteException {
		this.jogoServ.atualizarIngreco(i);
	}

	public void removerIngreco(Ingresso i) throws IngressoInexistenteException {
		this.jogoServ.removerIngreco(i);
	}

	public List<Ingresso> findByJogo(Jogo jogo) {
		return this.jogoServ.findByJogo(jogo);
	}

	public List<Ingresso> findByDataIngresso(Date data) {
		return this.jogoServ.findByDataIngresso(data);
	}

	public List<Ingresso> findByNumeroAcento(int numeroAcento) {
		return this.jogoServ.findByNumeroAcento(numeroAcento);
	}

	public List<Ingresso> findByNumeroAcentoAndSetorOrderByDataAsc(int numeroAcento, Setor setor) {
		return this.jogoServ.findByNumeroAcentoAndSetorOrderByDataAsc(numeroAcento, setor);
	}

	public Ingresso findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(int numeroAcento, Setor setor, Jogo jogo)
			throws IngressoInexistenteException {
		return this.jogoServ.findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(numeroAcento,setor,jogo);
	}

	public List<Ingresso> findByJogoOrderByDataAsc(Jogo jogo) {
		return this.jogoServ.findByJogoOrderByDataAsc(jogo);
	}

	public List<Ingresso> findByJogoOrderByDataDesc(Jogo jogo) {
		return this.jogoServ.findByJogoOrderByDataDesc(jogo);
	}

	public Ingresso findOneIngresso(Long id) throws IngressoInexistenteException {
		return this.jogoServ.findOneIngresso(id);
	}

	public List<Ingresso> findAllIngresso() {
		return this.jogoServ.findAllIngresso();
	}

	//ESTADIO

	public Estadio findOneEstadio(Long id) throws EstadioInexistenteException {
		return this.estadioServ.findOneEstadio(id);
	}

	public List<Estadio> findAllEstadio() {
		return this.estadioServ.findAllEstadio();
	}

	//Setor

	public Setor findOneSetor(Long id) throws SetorInexistenteException {
		return this.estadioServ.findOneSetor(id);
	}

	public Setor findByNome(String nome) throws SetorInexistenteException {
		return this.estadioServ.findByNome(nome);
	}

	public List<Setor> findByNomeStartingWith(String nome) {
		return this.estadioServ.findByNomeStartingWith(nome);
	}

	public List<Setor> findByNomeContaining(String nome) {
		return this.estadioServ.findByNomeContaining(nome);
	}
}
