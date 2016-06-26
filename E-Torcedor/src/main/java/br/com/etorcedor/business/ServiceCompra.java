package br.com.etorcedor.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Compra;
import br.com.etorcedor.entity.Usuario;
import br.com.etorcedor.exception.DelitoExistenteException;
import br.com.etorcedor.exception.JogoInexistenteException;

public interface ServiceCompra extends Serializable {
	
	public void adicionarComprar(Compra compra)throws DelitoExistenteException, JogoInexistenteException;
	public void removerCompras(Compra compra);
	public Compra findByOneCompra(Long id);
	public List<Compra> findByDia(Date dia);
	public List<Compra> findByUsuario(Long id);
	public List<Compra> findByAllCompras();
	
}
