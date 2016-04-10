package br.com.etorcedor.service;

import java.util.List;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.exception.UsuarioExistenteException;
import br.com.etorcedor.exception.UsuarioInexistenteException;

public interface ServiceUsuario {

	public void adicionarUsuario(Usuario u)throws UsuarioExistenteException;
	public void atualizarUsuario(Usuario u)throws UsuarioInexistenteException;
	public void removerUsuario(Long id)throws UsuarioInexistenteException;
	public Usuario buscarUsuario(Long id)throws UsuarioInexistenteException;
	public Usuario buscarUsuario(String cpf)throws UsuarioInexistenteException;
	public List<Usuario> buscarUsuarioNome(String nome);
	
}
