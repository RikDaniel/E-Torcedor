package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

public interface Fachada extends Serializable {

	//USUARIO

	/**
	 * 
	 * @param u
	 * @throws UsuarioExistenteException
	 */
	public void adicionarUsuario(Usuario u)throws UsuarioExistenteException;

	/**
	 * 
	 * @param u
	 * @throws UsuarioInexistenteException
	 */
	public void atualizarUsuario(Usuario u)throws UsuarioInexistenteException;

	/**
	 * 
	 * @param id
	 * @throws UsuarioInexistenteException
	 */
	public void removerUsuario(Long id)throws UsuarioInexistenteException;


	/**
	 * 
	 * Procura um usuário pelo seu cpf.
	 * @param cpf
	 * @return Uma entidade do tipo Usuario
	 */
	public Usuario findByCpf(String cpf)throws UsuarioInexistenteException;

	/**
	 * 
	 * Procura um usuário pelo seu e-mail.
	 * @param email
	 * @return Uma entidade do tipo Usuario
	 */
	public Usuario findByEmail(String email)throws UsuarioInexistenteException;
	
	/**
	 * Retorna todos os usuarios do sistema
	 * @return
	 */
	public List<Usuario> findAllUsuario();

	//Torcida
	/**
	 * 
	 * @param t
	 * @throws TorcidaExistenteException
	 */
	public void adicionarTorcida(Torcida t)throws TorcidaExistenteException;

	/**
	 * 
	 * @param t
	 * @throws TorcidaInexistenteException
	 */
	public void atualizarTorcida(Torcida t)throws TorcidaInexistenteException;

	/**
	 * 
	 * @param id
	 * @throws TorcidaInexistenteException
	 */
	public void removerTorcida(Long id)throws TorcidaInexistenteException;

	/**
	 * Recupera uma torcidas pelo seu nome. 
	 * @param nome
	 * @return uma entidade do tipo Torcida
	 */
	public Torcida torcidaFindByNome(String nome)throws TorcidaInexistenteException;


	/**
	 * Recupera todas as torcida pelo Time
	 * @param time
	 * @return uma coleção de Torcida do tipo List
	 */
	public List<Torcida> findByTime(Time time);

	/**
	 * Retorna uma lista com todas as torcidas.
	 * @return
	 */
	public List<Torcida> findAllTorcida();

	//TIME

	public Time findByOne(Long id)throws TimeInexistenteException;

	/**
	 * Recupera um time pelo seu nome.
	 * @param nome
	 * @return uma entidade do tipo Time.
	 */
	public Time timeFindByNome(String nome)throws TimeInexistenteException;

	/**
	 * Retorna uma lista com todos os times
	 */
	public List<Time> findAllTime();

	//JOGO
	public Jogo findOneJogo(Long id)throws JogoInexistenteException;

	/**
	 * Recupera uma lista de Jogos em um determinada Data.
	 * @param data
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByDataJogo(Date data);

	/**
	 * Recupera uma lista de Jogos em um estadio.
	 * @param estadio
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByEstadio(Estadio estadio);

	/**
	 * 
	 * @return
	 */
	public List<Jogo> findAllJogo();

	//INGRESSO

	/**
	 * 
	 * @param i
	 * @throws IngressoExistenteException
	 */
	public void adicionarIngreco(Ingresso i) throws IngressoExistenteException;

	/**
	 * 
	 * @param i
	 * @throws IngressoInexistenteException
	 */
	public void atualizarIngreco(Ingresso i) throws IngressoInexistenteException;

	/**
	 * 
	 * @param i
	 * @throws IngressoInexistenteException
	 */
	public void removerIngreco(Long i)throws IngressoInexistenteException;

	/**
	 * Recupera todos os ingressos de um determinado jogo.
	 * @param jogo
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByJogo(Jogo jogo);

	/**
	 * Recupera todos os ingressos de uma data.
	 * @param data
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByDataIngresso(Date data);

	/**
	 * Recupera todos os ingressos pelo numero do acento.
	 * @param numeroAcento
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByNumeroAcento(int numeroAcento);

	/**
	 * 
	 * @param id
	 * @return
	 * @throws IngressoInexistenteException
	 */
	public Ingresso findOneIngresso(Long id)throws IngressoInexistenteException;

	public List<Ingresso> findAllIngresso();

	//ESTADIO

	public Estadio findOneEstadio(Long id)throws EstadioInexistenteException;
	
	public List<Estadio> findAllEstadio();
	
	//SETOR

	public Setor findOneSetor(Long id)throws SetorInexistenteException;

	/**
	 * Recupera um setor pelo seu nome.
	 * @param nome
	 * @return Uma entidade do tipo Setor.
	 */
	public Setor findByNome(String nome)throws SetorInexistenteException;
}