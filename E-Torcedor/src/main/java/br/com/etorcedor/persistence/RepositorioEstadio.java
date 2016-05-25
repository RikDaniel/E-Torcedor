package br.com.etorcedor.persistence;

import org.springframework.data.repository.CrudRepository;

import br.com.etorcedor.entity.Estadio;

public interface RepositorioEstadio extends CrudRepository<Estadio, Long> {

}
