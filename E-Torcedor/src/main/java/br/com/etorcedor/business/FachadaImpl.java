package br.com.etorcedor.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etorcedor.entity.Compra;
import br.com.etorcedor.entity.Delito;
import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.entity.odc.EstadioShort;
import br.com.etorcedor.entity.odc.JogoLong;
import br.com.etorcedor.entity.odc.JogoShort;
import br.com.etorcedor.entity.odc.SetorShort;
import br.com.etorcedor.entity.odc.TimeLong;
import br.com.etorcedor.entity.odc.TimeShort;
import br.com.etorcedor.entity.odc.UsuarioLong;
import br.com.etorcedor.entity.odc.UsuarioShort;
import br.com.etorcedor.exception.DelitoExistenteException;
import br.com.etorcedor.exception.DelitoNaoEncontradoException;
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
import br.com.etorcedor.exception.UsuarioExistenteException;
import br.com.etorcedor.exception.UsuarioInexistenteException;

@Service
public class FachadaImpl implements Fachada {

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

	@Autowired
	private ServiceDelito delitoServ;

	@Autowired
	private ServiceCompra compraServ;

	// USUARIO

	public void adicionarUsuario(UsuarioShort u) throws UsuarioExistenteException {
		this.usuarioServ.adicionarUsuario(u);
	}

	public void atualizarUsuario(UsuarioShort u) throws UsuarioInexistenteException {
		this.usuarioServ.atualizarUsuario(u);
	}

	public void removerUsuario(Long id) throws UsuarioInexistenteException {
		this.usuarioServ.removerUsuario(id);
	}

	public UsuarioShort findByCpf(String cpf) throws UsuarioInexistenteException {
		return this.usuarioServ.findByCpf(cpf);
	}

	public UsuarioLong findByEmail(String email) throws UsuarioInexistenteException {
		return this.usuarioServ.findByEmail(email);
	}

	public List<UsuarioShort> findByNomeOrderByNomeAsc(String nome) {
		return this.usuarioServ.findByNomeOrderByNomeAsc(nome);
	}

	public List<UsuarioShort> findByClubeOrderByNomeAsc(Time clube) {
		return this.usuarioServ.findByClubeOrderByNomeAsc(clube);
	}

	public List<UsuarioShort> findByTorcidaOrderByNomeAsc(Torcida torcida) {
		return this.usuarioServ.findByTorcidaOrderByNomeAsc(torcida);
	}

	public List<UsuarioLong> findAllUsuario() {
		return this.usuarioServ.findAll();
	}

	// TORCIDA

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

	public List<Torcida> findByTime(Time time) {
		return this.torcidaServ.findByTime(time);
	}

	public List<Torcida> findAllTorcida() {
		return this.torcidaServ.findAllTorcida();
	}

	// TIME

	public void adicionarTime(TimeShort time) throws TimeExistenteException {
		this.timeServ.adicionarTime(time);
	}

	public void removerTime(Long time)
			throws TimeInexistenteException, TorcidaInexistenteException, JogoInexistenteException {
		this.timeServ.removerTime(time);
	}

	public void atualizarTime(TimeShort time) throws TimeInexistenteException {
		this.timeServ.atualizarTime(time);
	}

	public TimeLong findByOne(Long id) throws TimeInexistenteException {
		return this.timeServ.findByOne(id);
	}

	public TimeShort timeFindByNome(String nome) throws TimeInexistenteException {
		return this.timeServ.findByNome(nome);
	}

	public List<TimeLong> findAllTime() {
		return this.timeServ.findAll();
	}

	// JOGO

	public void adicionarJogo(JogoLong jogo) throws JogoExistenteException {
		this.jogoServ.adicionarJogo(jogo);
	}

	public void atualizarJogo(JogoLong jogo) throws JogoInexistenteException {
		this.jogoServ.atualizarJogo(jogo);
	}

	public void removerJogo(Long id) throws JogoInexistenteException {
		this.jogoServ.removerJogo(id);
	}

	public JogoLong findOneJogo(Long id) throws JogoInexistenteException {
		return this.jogoServ.findOneJogo(id);
	}

	public List<JogoShort> findByDataJogo(Date data) {
		return this.jogoServ.findByDataJogo(data);
	}

	public List<JogoShort> findByEstadio(Estadio estadio) {
		return this.jogoServ.findByEstadio(estadio);
	}

	public List<JogoShort> findAllJogo() {
		return this.jogoServ.findAllJogo();
	}

	// INGRESSO
	public void adicionarIngreco(Ingresso i) throws IngressoExistenteException {
		this.jogoServ.adicionarIngresso(i);
	}

	public void removerIngreco(Long i) throws IngressoInexistenteException {
		this.jogoServ.removerIngresso(i);
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

	public Ingresso findOneIngresso(Long id) throws IngressoInexistenteException {
		return this.jogoServ.findOneIngresso(id);
	}

	public List<Ingresso> findAllIngresso() {
		return this.jogoServ.findAllIngresso();
	}

	// ESTADIO

	public void adicionarEstadio(EstadioShort estadio) throws EstadioExistenteException {
		this.estadioServ.adicionarEstadio(estadio);
	}

	public void atualizarEstadio(EstadioShort estadio) throws EstadioInexistenteException {
		this.estadioServ.atualizarEstadio(estadio);
	}

	public void removerEstadio(Long id) throws EstadioInexistenteException {
		this.estadioServ.removerEstadio(id);;
	}

	public EstadioShort findOneEstadio(Long id) throws EstadioInexistenteException {
		return this.estadioServ.findOneEstadio(id);
	}

	public List<EstadioShort> findAllEstadio() {
		return this.estadioServ.findAllEstadio();
	}

	public EstadioShort findByNomeEstadio(String nome) throws EstadioInexistenteException {
		return this.estadioServ.findByNomeEstadio(nome);
	}

	public EstadioShort findByApelido(String apelido) throws EstadioInexistenteException {
		return this.estadioServ.findByApelido(apelido);
	}

	// SETOR

	public void adicionarSetor(SetorShort e) throws SetorExistenteException {
		this.estadioServ.adicionarSetor(e);
	}

	public void atualizarSetor(SetorShort e) throws SetorInexistenteException {
		this.estadioServ.atualizarSetor(e);
	}

	public void removerSetor(Long id) throws SetorInexistenteException {
		this.estadioServ.removerSetor(id);
	}

	public SetorShort findOneSetor(Long id) throws SetorInexistenteException {
		return this.estadioServ.findOneSetor(id);
	}

	public List<SetorShort> findByNome(String nome) throws SetorInexistenteException {
		return this.estadioServ.findByNome(nome);
	}
	
	public List<SetorShort> findAllSetores() {
		return this.estadioServ.findAllSetores();
	}

	// DELITO

	public Delito findByBo(long bo) throws DelitoNaoEncontradoException {
		return this.delitoServ.findByBo(bo);
	}

	public List<Delito> findByDia(Date dia) {
		return this.delitoServ.findByDia(dia);
	}

	public List<Delito> findAll() {
		return this.delitoServ.findAll();
	}

	// COMPRA

	public void adicionarComprar(Compra compra) throws DelitoExistenteException, JogoInexistenteException {
		this.compraServ.adicionarComprar(compra);
	}

	public Compra findByOneCompra(Long id) {
		return this.compraServ.findByOneCompra(id);
	}

	public List<Compra> findByUsuario(Usuario usuario) {
		return this.compraServ.findByUsuario(usuario);
	}

	public List<Compra> findByAllCompras() {
		return this.findByAllCompras();
	}
}
