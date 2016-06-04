package br.com.etorcedor.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Delito;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.exception.DelitoNaoEncontradoException;
import br.com.etorcedor.persistence.RepositorioDelito;

@Service
public class ServiceDelitoImpl implements ServiceDelito {

	private static final long serialVersionUID = -5380965596587382220L;
	
	@Autowired
	private RepositorioDelito repDelito;
	
	public Delito findByBo(long bo) throws DelitoNaoEncontradoException {
		Delito delito = this.repDelito.findByBo(bo);
		if(delito == null) 
			throw new DelitoNaoEncontradoException();
		return delito ;
	}
	

	@Transactional(rollbackFor = DelitoNaoEncontradoException.class)
	public void removeDelito(long bo)throws DelitoNaoEncontradoException {
		Delito delito = this.findByBo(bo);
		if(delito != null)
			this.repDelito.delete(delito);
		else
			throw new DelitoNaoEncontradoException();
	}

	public List<Delito> findByDia(Date dia) {
		return this.repDelito.findByDia(dia);
	}

	public List<Delito> findAll() {
		return (List<Delito>) this.repDelito.findAll();
	}
	
	public List<Delito> findByUsuarios(List<Usuario> usuarios) {
		return (List<Delito>) this.findByUsuarios(usuarios);
	}
}
