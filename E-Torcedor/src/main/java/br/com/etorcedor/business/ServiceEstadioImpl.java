package br.com.etorcedor.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Setor;
import br.com.etorcedor.entity.odc.EstadioLong;
import br.com.etorcedor.entity.odc.EstadioShort;
import br.com.etorcedor.entity.odc.SetorShort;
import br.com.etorcedor.exception.EstadioExistenteException;
import br.com.etorcedor.exception.EstadioInexistenteException;
import br.com.etorcedor.exception.SetorExistenteException;
import br.com.etorcedor.exception.SetorInexistenteException;
import br.com.etorcedor.persistence.RepositorioEstadio;
import br.com.etorcedor.persistence.RepositorioSetor;

@Service
public class ServiceEstadioImpl implements ServiceEstadio {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RepositorioEstadio estadioRep;
	@Autowired
	private RepositorioSetor setorRep;

	@Transactional(rollbackFor = EstadioExistenteException.class)
	public void adicionarEstadio(EstadioShort e) throws EstadioExistenteException {
		try {
			if (this.findByNomeEstadio(e.getNome()) != null) {
				throw new EstadioExistenteException();
			}
		} catch (EstadioInexistenteException ei) {
			Estadio estadio = EstadioShort.toEstadio(e);
			this.estadioRep.save(estadio);
		}
	}

	@Transactional(rollbackFor = EstadioInexistenteException.class)
	public void atualizarEstadio(@RequestBody EstadioLong e) throws EstadioInexistenteException {
		EstadioLong old = this.findOneEstadio(e.getId());
		old.setApelido(e.getApelido());
		old.setId(e.getId());
		old.setNome(e.getNome());
	    old.setSetorShorts(e.getSetorShorts());
		this.estadioRep.save(EstadioLong.toEstadio(old));
	}

	@Transactional(rollbackFor = EstadioInexistenteException.class)
	public void removerEstadio(Long id) throws EstadioInexistenteException {
		EstadioLong old = this.findOneEstadio(id);
		try {
			List<SetorShort> setores = old.getSetorShorts();
			for (SetorShort setor : setores) {
				this.removerSetor(setor.getId());
			}
			this.estadioRep.delete(id);
		} catch (Exception e2) {
			throw new EstadioInexistenteException();
		}
	}

	public EstadioLong findOneEstadio(Long id) throws EstadioInexistenteException {
		Estadio estadio = this.estadioRep.findOne(id);
		if (estadio == null) {
			throw new EstadioInexistenteException();
		}
		return EstadioLong.toEstadioLong(estadio);
	}

	public EstadioShort findByNomeEstadio(String nome) throws EstadioInexistenteException {
		Estadio estadio = this.estadioRep.findByNome(nome);
		if (estadio == null) {
			throw new EstadioInexistenteException();
		}
		return EstadioShort.toEstadioShort(estadio);
	}

	public EstadioShort findByApelido(String apelido) throws EstadioInexistenteException {
		Estadio estadio = this.estadioRep.findByApelido(apelido);
		if (estadio == null) {
			throw new EstadioInexistenteException();
		}
		return EstadioShort.toEstadioShort(estadio);
	}

	public List<EstadioShort> findAllEstadio() {
		return EstadioShort.toEstadioShort((List<Estadio>) this.estadioRep.findAll());
	}

	// SETOR

	@Transactional(rollbackFor = SetorExistenteException.class)
	public void adicionarSetor(SetorShort e) throws SetorExistenteException {
		EstadioLong estadio;
		try {
			estadio = this.findOneEstadio(e.getEstadioShortId());
			for (SetorShort ss : estadio.getSetorShorts()) {
				if (ss.getNome() == e.getNome()) {
					throw new SetorExistenteException();
				}
			}
			this.setorRep.save(SetorShort.toSetor(e));
		} catch (EstadioInexistenteException e1) {
			throw new SetorExistenteException();
		}
	}

	@Transactional(rollbackFor = SetorInexistenteException.class)
	public void atualizarSetor(SetorShort e) throws SetorInexistenteException {
		SetorShort old = this.findOneSetor(e.getId());
		old.setNome(e.getNome());
		old.setId(e.getId());
		old.setNumeroCadeira(e.getNumeroCadeira());
		this.setorRep.save(SetorShort.toSetor(old));
	}

	@Transactional(rollbackFor = SetorInexistenteException.class)
	public void removerSetor(Long id) throws SetorInexistenteException {
		SetorShort old = this.findOneSetor(id);
		this.setorRep.delete(SetorShort.toSetor(old));
	}

	public SetorShort findOneSetor(Long id) throws SetorInexistenteException {
		Setor s = this.setorRep.findOne(id);
		if (s == null) {
			throw new SetorInexistenteException();
		}
		return SetorShort.toSetorShort(s);
	}

	public List<SetorShort> findByNome(String nome) throws SetorInexistenteException {
		List<Setor> s = this.setorRep.findByNome(nome);
		return SetorShort.toSetorShort(s);
	}

	public List<SetorShort> findAllSetores() {
		return SetorShort.toSetorShort((List<Setor>) this.setorRep.findAll());
	}
}
