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
	 * Procura todos os usuarios pelo seu nome, 
	 * ordenando de forma ascendente.
	 * @param nome
	 * @return Uma coleção do tipo List de Usuario
	 */
	public List<Usuario> findByNomeOrderByNomeAsc(String nome)throws UsuarioInexistenteException;
	
	/**
	 * Recupera uma lista de usuario contendo um nome.
	 * @param nome
	 * @return Uma coleção do tipo List de Usuario
	 */
	public List<Usuario> usuarioFindByNomeContaining(String nome)throws UsuarioInexistenteException;
	
	/**
	 * Recupera uma lista de usuario iniciado com um nome.
	 * @param nome
	 * @return Uma coleção do tipo List de Usuario
	 */
	public List<Usuario> usuarioFindByNomeStartingWith(String nome)throws UsuarioInexistenteException;
	
	/**
	 * 
	 * Procura todos os usuário que estejam em um Time,
	 * ordenando de forma ascendente, 
	 * utilizando o nome como critério.
	 * @param clube
	 * @return Uma coleção do tipo List de Usuario
	 */
	public List<Usuario> findByClubeOrderByNomeAsc(Time clube)throws UsuarioInexistenteException;
	
	/**
	 * 
	 * Procura todos os usuarios que estejam em uma Torcida,
	 * ordenando de forma ascendente, utilizando o nome como critério.
	 * @param torcida
	 * @return Uma coleção do tipo List de Usuario
	 */
	public List<Usuario> findByTorcidaOrderByNomeAsc(Torcida torcida )throws UsuarioInexistenteException;

	
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
	public Torcida torcidaFindByNome(String nome)throws TorcidaExistenteException;
	
	/**
	 * Recupera todas as torcidas contendo um nome. 
	 * @param nome
	 * @return uma coleção do tipo List de Torcida
	 */
	public List<Torcida> torcidaFindByNomeContaining(String nome)throws TorcidaExistenteException;
	
	/**
	 * Recupera todas as torcidas começando com um nome. 
	 * @param nome
	 * @return uma coleção do tipo List de Torcida
	 */
	public List<Torcida> torcidaFindByNomeStartingWith(String nome)throws TorcidaExistenteException;
	
	/**
	 * Recupera todas as torcidas pelo seu nome, ordenado de forma ascendente,
	 * usando o nome como critério.
	 * @param nome
	 * @return uma coleção de Torcida do tipo List
	 */
	public List<Torcida> torcidaFindByNomeOrderByNomeAsc(String nome)throws TorcidaExistenteException;
	
	/**
	 * Recupera todas as torcidas pelo seu nome, ordenado de forma descendente,
	 * usando o nome como critério.
	 * @param nome
	 * @return uma coleção de Torcida do tipo List 
	 */
	public List<Torcida> findByNomeOrderByNomeDesc(String nome)throws TorcidaExistenteException;
	
	/**
	 * Recupera todas as torcida pelo Time
	 * @param time
	 * @return uma coleção de Torcida do tipo List
	 */
	public List<Torcida> findByTime(Time time)throws TorcidaExistenteException;
	
	/**
	 * Recupera todas as torcida pelo Time, ordenando de forma ascendente,
	 * utilizando o nome da torcida como critério.
	 * @param time
	 * @return
	 */
	public List<Torcida> findByTimeOrderByNomeAsc(Time time)throws TorcidaExistenteException;
	
	/**
	 * Recupera todas as torcida pelo Time, ordenando de forma descendente,
	 * utilizando o nome da torcida como critério.
	 * @param time
	 * @return
	 */
	public List<Torcida> findByTimeOrderByNomeDesc(Time time)throws TorcidaExistenteException;
	
	//TIME
	
	public Time findByOne(Long id)throws TimeInexistenteException;
	
	/**
	 * Recupera um time pelo seu nome.
	 * @param nome
	 * @return uma entidade do tipo Time.
	 */
	public Time timeFindByNome(String nome)throws TimeInexistenteException;
	
	/**
	 * Recupera uma lista de times, começando com um nome.
	 * @param nome
	 * @return uma List do tipo Time.
	 */
	public List<Time> timeFindByNomeStartingWith(String nome)throws TimeInexistenteException;
	
	/*
	 * Não sei se esse metodo funciona, Verificar com o Prof Thiago
	 * public List<Time> findByNomeStartingWithOrderByNomeAsc(String nome);
	 */
	
	/**
	 * Recupera uma Lista de time contendo um nome.
	 * @param nome
	 * @return uma List do tipo Time.
	 */
	public List<Time> timeFByNomeContaining(String nome)throws TimeInexistenteException;
	
	//JOGO
	public Jogo findOneJogo(Long id)throws JogoInexistenteException;

	/**
	 * Recupera uma lista de Jogos em um determinada Data.
	 * @param data
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByDataJogo(Date data)throws JogoInexistenteException;
	
	/**
	 * Recupera uma lista de Jogos em um determinada Data,
	 * ordenado de forma ascendente por data.
	 * @param data
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByDataOrderByDataAsc(Date data)throws JogoInexistenteException;
	
	/**
	 * Recupera uma lista de Jogos em um determinada Data,
	 * ordenado de forma descendente por data.
	 * @param data
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByDataOrderByDataDesc(Date data)throws JogoInexistenteException;
	
	/**
	 * Recupera uma lista de Jogos em um estadio.
	 * @param estadio
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByEstadio(Estadio estadio)throws JogoInexistenteException;
	
	/**
	 * Recupera uma lista de Jogos em um estadio,
	 * ordenado de forma ascendente por data.
	 * @param estadio
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByEstadioOrderByDataAsc(Estadio estadio)throws JogoInexistenteException;

	/**
	 * Recupera uma lista de Jogos em um estadio,
	 * ordenado de forma descendente por data.
	 * @param estadio
	 * @return Uma coleção do tipo List de Jogo
	 */
	public List<Jogo> findByEstadioOrderByDataDesc(Estadio estadio)throws JogoInexistenteException;
	
	
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
	public List<Ingresso> findByJogo(Jogo jogo)throws IngressoInexistenteException;
	
	/**
	 * Recupera todos os ingressos de uma data.
	 * @param data
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByDataIngresso(Date data)throws IngressoInexistenteException;
	
	/**
	 * Recupera todos os ingressos pelo numero do acento.
	 * @param numeroAcento
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByNumeroAcento(int numeroAcento)throws IngressoInexistenteException;
	
	/**
	 * Recupera todos os ingressos pelo numero do acento e setor,
	 * ordenado por data de forma ascendente.
	 * @param numeroAcento
	 * @param setor
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByNumeroAcentoAndSetorOrderByDataAsc(int numeroAcento, Setor setor)throws IngressoInexistenteException;
	
	/**
	 * Recupera todos os ingressos pelo numero do acento, setor e Jogo,
	 * ordenado por data de forma ascendente.
	 * @param numeroAcento
	 * @param setor
	 * @param jogo
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public Ingresso findByNumeroAcentoAndSetorAndJogoOrderByDataAsc(int numeroAcento, Setor setor, Jogo jogo)throws IngressoInexistenteException;
	
	/**
	 * Recupera todos os ingressos pelo Jogo, ordenado por
	 * data de forma ascendente.
	 * @param jogo
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByJogoOrderByDataAsc(Jogo jogo)throws IngressoInexistenteException;

	/**
	 * Recupera todos os ingressos pelo Jogo, ordenado por
	 * data de forma descendente.
	 * @param jogo
	 * @return Uma coleção do tipo List de Ingresso.
	 */
	public List<Ingresso> findByJogoOrderByDataDesc(Jogo jogo)throws IngressoInexistenteException;


	public Ingresso findOneIngresso(Long id)throws IngressoInexistenteException;
	
	//ESTADIO
	
		public Estadio findOneEstadio(Long id)throws EstadioInexistenteException;
		
		//SETOR
		
		public Setor findOneSetor(Long id)throws SetorInexistenteException;
		
		/**
		 * Recupera um setor pelo seu nome.
		 * @param nome
		 * @return Uma entidade do tipo Setor.
		 */
		public Setor findByNome(String nome)throws SetorInexistenteException;
		
		/**
		 * Recupera uma lista de Setor começando pelo nome.
		 * @param nome
		 * @return Uma coleção do tipo List de Setor.
		 */
		public List<Setor> findByNomeStartingWith(String nome)throws SetorInexistenteException;
		
		/**
		 * Resupera um setor contendo um determinado nome.
		 * @param nome
		 * @return Uma coleção do tipo List de Setor.
		 */
		public List<Setor> findByNomeContaining(String nome)throws SetorInexistenteException;
}