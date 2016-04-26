package br.com.etorcedor.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.exception.UsuarioExistenteException;
import br.com.etorcedor.exception.UsuarioInexistenteException;
import br.com.etorcedor.persistence.RepositorioUsuario;

@Service
public class ServiceUsuarioImpl implements ServiceUsuario {

	/**
	 * Falta o metodo de remover
	 */
	private static final long serialVersionUID = 1336061289381836117L;

	@Autowired
	private RepositorioUsuario usuarioRep;

	@Transactional(rollbackFor = UsuarioExistenteException.class)
	public void adicionarUsuario(Usuario u) throws UsuarioExistenteException {
		try{
			this.findByCpf(u.getCpf());
			throw new UsuarioExistenteException();
		}catch(UsuarioInexistenteException e){
			usuarioRep.save(u);
		}
	}

	@Transactional(rollbackFor = UsuarioInexistenteException.class)
	public void atualizarUsuario(Usuario u) throws UsuarioInexistenteException {
		Usuario old = this.findByCpf(u.getCpf());
		old.setCpf(u.getCpf());
		old.setNome(u.getNome());
		old.setImagem(u.getImagem());
		old.setGenero(u.getGenero());
		old.setTelefone(u.getTelefone());
		old.setEmail(u.getEmail());
		old.setData_nascimento(u.getData_nascimento());
		old.setTorcida(u.getTorcida());
		old.setClube(u.getClube());
		old.setIngressos(u.getIngressos());
		this.usuarioRep.save(old);
	}

	@Transactional(rollbackFor = UsuarioInexistenteException.class)
	public void removerUsuario(Long id) throws UsuarioInexistenteException {
		// TODO Auto-generated method stub

	}

	public Usuario findByCpf(String cpf) throws UsuarioInexistenteException {
		Usuario usuario = usuarioRep.findByCpf(cpf);
		if(usuario == null) 
			throw new UsuarioInexistenteException();
		return usuario;
	}

	public Usuario findByEmail(String email) {
		return usuarioRep.findByEmail(email);
	}

	public List<Usuario> findByNomeOrderByNomeAsc(String nome) {
		return usuarioRep.findByNomeContaining(nome);
	}

	public List<Usuario> findByNomeContaining(String nome) {
		return usuarioRep.findByNomeContaining(nome);
	}

	public List<Usuario> findByNomeStartingWith(String nome) {
		return usuarioRep.findByNomeStartingWith(nome);
	}

	public List<Usuario> findByClubeOrderByNomeAsc(Time clube) {
		return usuarioRep.findByClubeOrderByNomeAsc(clube);
	}

	public List<Usuario> findByTorcidaOrderByNomeAsc(Torcida torcida) {
		return this.usuarioRep.findByTorcidaOrderByNomeAsc(torcida);
	}
	
	/**
	 * Retorna todos os usuarios do sistema
	 * @return
	 */
	public List<Usuario> findAll() {
		return (List<Usuario>) this.usuarioRep.findAll();
	}
}