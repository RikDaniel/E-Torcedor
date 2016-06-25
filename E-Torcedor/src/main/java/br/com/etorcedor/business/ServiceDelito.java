package br.com.etorcedor.business;

import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.entity.odc.DelitoLong;
import br.com.etorcedor.entity.odc.DelitoShort;
import br.com.etorcedor.exception.DelitoNaoEncontradoException;

import java.util.List;
import java.io.Serializable;
import java.util.Date;

public interface ServiceDelito extends Serializable {

	public void adicionarDelito(DelitoLong delitoLong);
	public DelitoLong findByBo(long bo)throws DelitoNaoEncontradoException;
	public List<DelitoShort> findByDia(Date dia);
	public void removeDelito(long bo)throws DelitoNaoEncontradoException;
 	public List<DelitoShort> findAll();
	public List<DelitoShort> findByUsuarios(List<Usuario> usuarios);
}
