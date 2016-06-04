package br.com.etorcedor.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.etorcedor.entity.Delito;
import br.com.etorcedor.entity.Usuario;

public interface RepositorioDelito extends CrudRepository<Delito, Long> {
	
	public Delito findByBo(long bo);
	public List<Delito> findByDia(Date dia);
	public List<Delito> findByUsuarios(List<Usuario> usuarios);
}
