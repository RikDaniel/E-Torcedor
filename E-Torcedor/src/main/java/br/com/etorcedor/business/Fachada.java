package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Compra;
import br.com.etorcedor.entity.Delito;
import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Ingresso;
import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.entity.odc.JogoLong;
import br.com.etorcedor.entity.odc.JogoShort;
import br.com.etorcedor.entity.odc.TimeLong;
import br.com.etorcedor.entity.odc.TimeShort;
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

	public void adicionarUsuario(Usuario u) throws UsuarioExistenteException;

	public void atualizarUsuario(Usuario u) throws UsuarioInexistenteException;

	public void removerUsuario(Long id) throws UsuarioInexistenteException;

	public Usuario findByCpf(String cpf) throws UsuarioInexistenteException;

	public Usuario findByEmail(String email) throws UsuarioInexistenteException;

	public List<Usuario> findAllUsuario();

	// TOCIDA

	public void adicionarTorcida(Torcida t) throws TorcidaExistenteException;

	public void atualizarTorcida(Torcida t) throws TorcidaInexistenteException;

	public void removerTorcida(Long id) throws TorcidaInexistenteException;

	public Torcida torcidaFindByNome(String nome) throws TorcidaInexistenteException;

	public List<Torcida> findByTime(Time time);

	public List<Torcida> findAllTorcida();

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

	public void adicionarIngreco(Ingresso i) throws IngressoExistenteException;

	public void removerIngreco(Long i) throws IngressoInexistenteException;

	public List<Ingresso> findByJogo(Jogo jogo);

	public List<Ingresso> findByDataIngresso(Date data);

	public List<Ingresso> findByNumeroAcento(int numeroAcento);

	public Ingresso findOneIngresso(Long id) throws IngressoInexistenteException;

	public List<Ingresso> findAllIngresso();

	// ESTADIO

	public void adicionarEstadio(Estadio estadio) throws EstadioExistenteException;

	public void atualizarEstadio(Estadio estadio) throws EstadioInexistenteException;

	public void removerEstadio(Estadio estadio) throws EstadioInexistenteException;

	public Estadio findOneEstadio(Long id) throws EstadioInexistenteException;

	public List<Estadio> findAllEstadio();

	public Estadio findByNomeEstadio(String nome) throws EstadioInexistenteException;

	public Estadio findByApelido(String apelido) throws EstadioInexistenteException;

	// SETOR
	public void adicionarSetor(Setor e) throws SetorExistenteException;

	public void atualizarSetor(Setor e) throws SetorInexistenteException;

	public void removerSetor(Setor e) throws SetorInexistenteException;

	public Setor findOneSetor(Long id) throws SetorInexistenteException;

	public Setor findByNome(String nome) throws SetorInexistenteException;

	// DELITO

	public Delito findByBo(long bo) throws DelitoNaoEncontradoException;

	public List<Delito> findByDia(Date dia);

	public List<Delito> findAll();

	// COMPRA
	public void adicionarComprar(Compra compra) throws DelitoExistenteException, JogoInexistenteException;

	public Compra findByOneCompra(Long id);

	public List<Compra> findByUsuario(Usuario usuario);

	public List<Compra> findByAllCompras();

}