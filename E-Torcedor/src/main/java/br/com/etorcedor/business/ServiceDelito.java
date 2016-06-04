package br.com.etorcedor.business;

import br.com.etorcedor.entity.Delito;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.exception.DelitoNaoEncontradoException;

import java.util.List;
import java.io.Serializable;
import java.util.Date;

public interface ServiceDelito extends Serializable {

	public Delito findByBo(long bo)throws DelitoNaoEncontradoException;
	public List<Delito> findByDia(Date dia);
	public void removeDelito(long bo)throws DelitoNaoEncontradoException;
 	public List<Delito> findAll();
	public List<Delito> findByUsuarios(List<Usuario> usuarios);
}
