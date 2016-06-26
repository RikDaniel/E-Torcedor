package br.com.etorcedor.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Compra;
import br.com.etorcedor.entity.Delito;
import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.entity.odc.UsuarioLong;
import br.com.etorcedor.entity.odc.UsuarioShort;
import br.com.etorcedor.exception.DelitoNaoEncontradoException;
import br.com.etorcedor.exception.UsuarioExistenteException;
import br.com.etorcedor.exception.UsuarioInexistenteException;
import br.com.etorcedor.persistence.RepositorioUsuario;

@Service
public class ServiceUsuarioImpl implements ServiceUsuario {

	private static final long serialVersionUID = 1336061289381836117L;

	@Autowired
	private RepositorioUsuario usuarioRep;
		
	@Autowired
	private ServiceDelito delitoServ;
	
	@Autowired
	private ServiceCompra compraServ;

	@Transactional(rollbackFor = UsuarioExistenteException.class)
	public void adicionarUsuario(UsuarioShort u) throws UsuarioExistenteException {
		try {
			UsuarioShort usuario = this.findByCpf(u.getCpf());
			if (usuario.getNome() != null)
				throw new UsuarioExistenteException();
		} catch (UsuarioInexistenteException e) {
			this.usuarioRep.save(UsuarioShort.toUsuario(u));
		}
	}

	@Transactional(rollbackFor = UsuarioInexistenteException.class)
	public void atualizarUsuario(UsuarioShort u) throws UsuarioInexistenteException {
		UsuarioShort old = this.findByCpf(u.getCpf());
		old.setCpf(u.getCpf());
		old.setNome(u.getNome());
		old.setGenero(u.getGenero());
		old.setTelefone(u.getTelefone());
		old.setEmail(u.getEmail());
		old.setDataNascimento(u.getDataNascimento());
		old.setClube(u.getClube());
		old.setClube(u.getClube());
		this.usuarioRep.save(UsuarioShort.toUsuario(old));

	}

	@Transactional(rollbackFor = UsuarioInexistenteException.class)
	public void removerUsuario(Long id) throws UsuarioInexistenteException {
		Usuario old = this.usuarioRep.findOne(id);
		
		if(old != null) {
			List<Compra> compras = old.getCompras();
			List<Delito> delito = old.getDelitos();
			try {
				for (Compra c : compras) {
					this.compraServ.removerCompras(c);
				}
				if(delito != null) {
					for(Delito d : delito) {
						this.delitoServ.removeDelito(d.getBo());
					}
				}
				this.usuarioRep.delete(old);
			} catch (DelitoNaoEncontradoException e1) {
				throw new UsuarioInexistenteException();
			}
		}
		else
			throw new UsuarioInexistenteException();
	}

	public UsuarioShort findByCpf(String cpf) throws UsuarioInexistenteException {
		UsuarioShort usuario = UsuarioShort.toUsuarioShort(this.usuarioRep.findByCpf(cpf));
		if (usuario.getNome() == null)
			throw new UsuarioInexistenteException();
		return usuario;
	}

	public UsuarioLong findByEmail(String email) {
		return UsuarioLong.toUsuarioLong(this.usuarioRep.findByEmail(email));
	} 

	public List<UsuarioShort> findByNomeOrderByNomeAsc(String nome) {
		return UsuarioShort.toUsuarioShort(this.usuarioRep.findByNomeOrderByNomeAsc(nome));
	}

	public List<UsuarioShort> findByClubeOrderByNomeAsc(Time clube) {
		return UsuarioShort.toUsuarioShort(this.usuarioRep.findByClubeOrderByNomeAsc(clube));
	}

	public List<UsuarioShort> findByTorcidaOrderByNomeAsc(Torcida torcida) {
		return UsuarioShort.toUsuarioShort(this.usuarioRep.findByTorcidaOrderByNomeAsc(torcida));
	}
	
	public UsuarioShort findOneUsuario(Long id) {
		return UsuarioShort.toUsuarioShort(this.usuarioRep.findOne(id));
	}

	/**
	 * Retorna todos os usuarios do sistema
	 * 
	 * @return
	 */
	public List<UsuarioLong> findAll() {
		return UsuarioLong.toUsuarioLong((List<Usuario>) this.usuarioRep.findAll());
	}
}
