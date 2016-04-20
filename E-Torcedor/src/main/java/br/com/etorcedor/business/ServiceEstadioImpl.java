package br.com.etorcedor.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.exception.EstadioExistenteException;
import br.com.etorcedor.exception.EstadioInexistenteException;
import br.com.etorcedor.exception.SetorExistenteException;
import br.com.etorcedor.exception.SetorInexistenteException;
import br.com.etorcedor.persistence.RepositorioEstadio;
import br.com.etorcedor.persistence.RepositorioSetor;

@Service
public class ServiceEstadioImpl implements ServiceEstadio {

	/**
	 * Falta adicionar os rollback da vida
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private RepositorioEstadio estadioRep;
	@Autowired
	private RepositorioSetor setorRep;

	public void adicionarEstadio(Estadio e) throws EstadioExistenteException {

		try {
			findOneEstadio(e.getId());
			throw new EstadioExistenteException();
		} catch (EstadioInexistenteException ei) {
			estadioRep.save(e);
		}
	}

	public void atualizarEstadio(Estadio e) throws EstadioInexistenteException {
		Estadio old = findOneEstadio(e.getId());
		old.setJogos(e.getJogos());
		old.setSetores(e.getSetores());
		estadioRep.save(old);
	}

	public void removerEstadio(Estadio e) throws EstadioInexistenteException {
		
	}

	public Estadio findOneEstadio(Long id) throws EstadioInexistenteException {
		Estadio e = estadioRep.findOne(id);

		if (e == null) {
			throw new EstadioInexistenteException();
		}
		return e;
	}

	public void adicionarSetor(Setor e) throws SetorExistenteException {
		try {
			findOneSetor(e.getId());
			throw new SetorExistenteException();
		} catch (SetorInexistenteException ei) {
			setorRep.save(e);
		}

	}

	public void atualizarSetor(Setor e) throws SetorInexistenteException {
		Setor old = findOneSetor(e.getId());
			old.setNome(e.getNome());
			old.setEstadio(e.getEstadio());
			old.setIngrecos(e.getIngrecos());
			old.setNumero_cadeiras(e.getNumero_cadeiras());
			setorRep.save(old);
	}

	public void removerSetor(Setor e) throws SetorInexistenteException {
		// TODO Auto-generated method stub

	}

	public Setor findOneSetor(Long id) throws SetorInexistenteException {
		Setor s = setorRep.findOne(id);
		if(s==null){
			throw new SetorInexistenteException();
		}
		return s;
		
	}

	public Setor findByNome(String nome) throws SetorInexistenteException {
		Setor s = setorRep.findByNome(nome);
		if(s==null){
			throw new SetorInexistenteException();
		}
		return s;
	}

	public List<Setor> findByNomeStartingWith(String nome) throws SetorInexistenteException {
	
		return setorRep.findByNomeStartingWith(nome);
	}

	public List<Setor> findByNomeContaining(String nome) throws SetorInexistenteException {
		
		return setorRep.findByNomeContaining(nome);
	}

}
