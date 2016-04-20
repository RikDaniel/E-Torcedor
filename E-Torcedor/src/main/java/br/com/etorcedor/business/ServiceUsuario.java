package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.List;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.exception.UsuarioExistenteException;
import br.com.etorcedor.exception.UsuarioInexistenteException;

public interface ServiceUsuario extends Serializable {

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
	public List<Usuario> findByNomeContaining(String nome)throws UsuarioInexistenteException;
	
	/**
	 * Recupera uma lista de usuario iniciado com um nome.
	 * @param nome
	 * @return Uma coleção do tipo List de Usuario
	 */
	public List<Usuario> findByNomeStartingWith(String nome)throws UsuarioInexistenteException;
	
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

}
