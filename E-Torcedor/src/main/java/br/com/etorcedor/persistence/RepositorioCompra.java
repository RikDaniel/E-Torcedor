package br.com.etorcedor.persistence;

import org.springframework.data.repository.CrudRepository;

import br.com.etorcedor.entity.Compra;
import br.com.etorcedor.entity.Usuario;

import java.util.Date;
import java.util.List;

public interface RepositorioCompra extends CrudRepository<Compra, Long> {
	
	public List<Compra> findByDia(Date dia);
	public List<Compra> findByUsuario(Usuario usuario);
	
}
