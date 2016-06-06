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
import br.com.etorcedor.exception.DelitoExistenteException;
import br.com.etorcedor.exception.DelitoNaoEncontradoException;
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

	public Time findByOne(Long id) throws TimeInexistenteException;
	public Time timeFindByNome(String nome) throws TimeInexistenteException;
	public List<Time> findAllTime();

	// JOGO
	
	public Jogo findOneJogo(Long id) throws JogoInexistenteException;
	public List<Jogo> findByDataJogo(Date data);
	public List<Jogo> findByEstadio(Estadio estadio);
	public List<Jogo> findAllJogo();

	// INGRESSO

	public void adicionarIngreco(Ingresso i) throws IngressoExistenteException;
	public void removerIngreco(Long i) throws IngressoInexistenteException;
	public List<Ingresso> findByJogo(Jogo jogo);
	public List<Ingresso> findByDataIngresso(Date data);
	public List<Ingresso> findByNumeroAcento(int numeroAcento);
	public Ingresso findOneIngresso(Long id) throws IngressoInexistenteException;
	public List<Ingresso> findAllIngresso();

	// ESTADIO

	public Estadio findOneEstadio(Long id) throws EstadioInexistenteException;
	public List<Estadio> findAllEstadio();
	public Estadio findByNomeEstadio(String nome) throws EstadioInexistenteException;
	public Estadio findByApelido(String apelido) throws EstadioInexistenteException;

	// SETOR

	public Setor findOneSetor(Long id) throws SetorInexistenteException;
	public Setor findByNome(String nome) throws SetorInexistenteException;
	
	//DELITO
	
	public Delito findByBo(long bo) throws DelitoNaoEncontradoException;
	public List<Delito> findByDia(Date dia);
 	public List<Delito> findAll();
 	
 	//COMPRA
 	public void adicionarComprar(Compra compra)throws DelitoExistenteException, JogoInexistenteException;
	public Compra findByOneCompra(Long id);
	public List<Compra> findByUsuario(Usuario usuario);
	public List<Compra> findByAllCompras();
	
}