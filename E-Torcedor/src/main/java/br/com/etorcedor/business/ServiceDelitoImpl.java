package br.com.etorcedor.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.etorcedor.entity.Delito;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.entity.odc.DelitoLong;
import br.com.etorcedor.entity.odc.DelitoShort;
import br.com.etorcedor.exception.DelitoNaoEncontradoException;
import br.com.etorcedor.persistence.RepositorioDelito;

@Service
public class ServiceDelitoImpl implements ServiceDelito {

	private static final long serialVersionUID = -5380965596587382220L;
	
	@Autowired
	private RepositorioDelito repDelito;
	
	public void adicionarDelito(DelitoLong delitoLong) {
		if(delitoLong != null) {
			this.repDelito.save(DelitoLong.toDelito(delitoLong));
		}
	}
	public DelitoLong findByBo(long bo) throws DelitoNaoEncontradoException {
		Delito delito = this.repDelito.findByBo(bo);
		if(delito == null) 
			throw new DelitoNaoEncontradoException();
		return DelitoLong.toDelitoLong(delito);
	}
	

	@Transactional(rollbackFor = DelitoNaoEncontradoException.class)
	public void removeDelito(long bo)throws DelitoNaoEncontradoException {
		Delito delito = DelitoLong.toDelito(this.findByBo(bo));
		if(delito != null)
			this.repDelito.delete(delito);
		else
			throw new DelitoNaoEncontradoException();
	}

	public List<DelitoShort> findByDia(Date dia) {
		return DelitoShort.toDelitoShort(this.repDelito.findByDia(dia));
	}

	public List<DelitoShort> findAll() {
		return DelitoShort.toDelitoShort((List<Delito>) this.repDelito.findAll());
	}
	
	public List<DelitoShort> findByUsuarios(List<Usuario> usuarios) {
		return DelitoShort.toDelitoShort((List<Delito>) this.repDelito.findByUsuarios(usuarios));
	}
}
