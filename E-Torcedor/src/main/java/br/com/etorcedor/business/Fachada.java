package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Compra;
import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Time;
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

public interface Fachada extends Serializable {

	// USUARIO

	public void adicionarUsuario(UsuarioShort u) throws UsuarioExistenteException;

	public void atualizarUsuario(UsuarioShort u) throws UsuarioInexistenteException;

	public void removerUsuario(Long id) throws UsuarioInexistenteException;

	public UsuarioShort findByCpf(String cpf) throws UsuarioInexistenteException;

	public UsuarioLong findByEmail(String email) throws UsuarioInexistenteException;

	public List<UsuarioLong> findAllUsuario();

	// TOCIDA

	public void adicionarTorcida(TorcidaShort t) throws TorcidaExistenteException;

	public void atualizarTorcida(TorcidaShort t) throws TorcidaInexistenteException;

	public void removerTorcida(Long id) throws TorcidaInexistenteException;

	public TorcidaShort torcidaFindByNome(String nome) throws TorcidaInexistenteException;

	public List<TorcidaShort> findByTime(Time time);

	public List<TorcidaShort> findAllTorcida();

	// TIME

	public void adicionarTime(TimeShort time) throws TimeExistenteException;

	public void removerTime(Long t)
			throws TimeInexistenteException, TorcidaInexistenteException, JogoInexistenteException;

	public void atualizarTime(TimeShort time) throws TimeInexistenteException;

	public TimeLong findByOne(Long id) throws TimeInexistenteException;

	public TimeShort timeFindByNome(String nome) throws TimeInexistenteException;

	public List<TimeLong> findAllTime();

	// JOGO

	public void adicionarJogo(JogoLong jogo) throws JogoExistenteException;

	public void atualizarJogo(JogoLong jogo) throws JogoInexistenteException;

	public void removerJogo(Long id) throws JogoInexistenteException;

	public JogoLong findOneJogo(Long id) throws JogoInexistenteException;

	public List<JogoShort> findByDataJogo(Date data);

	public List<JogoShort> findByEstadio(Estadio estadio);

	public List<JogoShort> findAllJogo();

	// INGRESSO

	public void adicionarIngreco(IngressoShort i) throws IngressoExistenteException;

	public void removerIngreco(Long i) throws IngressoInexistenteException;

	public List<IngressoShort> findByJogo(Jogo jogo);

	public List<IngressoShort> findByDataIngresso(Date data);

	public List<IngressoShort> findByNumeroAcento(int numeroAcento);

	public IngressoShort findOneIngresso(Long id) throws IngressoInexistenteException;

	public List<IngressoShort> findAllIngresso();

	// ESTADIO

	public void adicionarEstadio(EstadioShort estadio) throws EstadioExistenteException;

	public void atualizarEstadio(EstadioShort estadio) throws EstadioInexistenteException;

	public void removerEstadio(Long id) throws EstadioInexistenteException;

	public EstadioShort findOneEstadio(Long id) throws EstadioInexistenteException;

	public List<EstadioShort> findAllEstadio();

	public EstadioShort findByNomeEstadio(String nome) throws EstadioInexistenteException;

	public EstadioShort findByApelido(String apelido) throws EstadioInexistenteException;

	// SETOR
	public void adicionarSetor(SetorShort e) throws SetorExistenteException;

	public void atualizarSetor(SetorShort e) throws SetorInexistenteException;

	public void removerSetor(Long id) throws SetorInexistenteException;

	public SetorShort findOneSetor(Long id) throws SetorInexistenteException;

	public List<SetorShort> findByNome(String nome) throws SetorInexistenteException;
	
	public List<SetorShort> findAllSetores();

	// DELITO

	public void adicionarDelito(DelitoLong delitoLong);
	
	public DelitoLong findByBo(long bo) throws DelitoNaoEncontradoException;

	public List<DelitoShort> findByDia(Date dia);

	public List<DelitoShort> findAll();

	// COMPRA
	public void adicionarComprar(Compra compra) throws DelitoExistenteException, JogoInexistenteException;

	public Compra findByOneCompra(Long id);

	public List<Compra> findByUsuario(Usuario usuario);

	public List<Compra> findByAllCompras();

}