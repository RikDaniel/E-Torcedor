package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.List;

import br.com.etorcedor.entity.Estadio;

public class EstadioShort {
	
	private Long id;
	private String nome;
	private String apelido;
	private List<SetorShort> setorShort;
	
	public EstadioShort() {
	
	}
	
	public EstadioShort(String nome, String apelido) {
		this.nome = nome;
		this.apelido = apelido;
	}
	
	public EstadioShort(Long id, String nome, String apelido, List<SetorShort> setorShort) {
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
		this.setorShort = setorShort;
	}
	
	public static EstadioShort toEstadioShort(Estadio estadio) {
		EstadioShort estadioShort = new EstadioShort();
		if(estadio != null) {
			estadioShort.setId(estadio.getId());
			estadioShort.setNome(estadio.getNome());
			estadioShort.setApelido(estadio.getApelido());
			estadioShort.setSetorShort(SetorShort.toSetorShort(estadio.getSetores()));
		}
		return estadioShort;
	}
	
	public static List<EstadioShort> toEstadioShort(List<Estadio> estadios) {
		List<EstadioShort> estadioShort = new ArrayList<EstadioShort>();
		if(estadios != null) {
			for(Estadio estadio : estadios) {
				estadioShort.add(EstadioShort.toEstadioShort(estadio));
			}
		}
		return estadioShort;
	}
	
	public static Estadio toEstadio(EstadioShort estadioShort) {
		Estadio estadio = new Estadio();
		if(estadioShort != null) {
			estadio.setId(estadioShort.getId());
			estadio.setNome(estadioShort.getNome());
			estadio.setApelido(estadioShort.getApelido());
			estadio.setSetores(SetorShort.toSetor(estadioShort.getSetorShort()));
		}
		return estadio;
	}
	
	public static List<Estadio> toEstadio(List<EstadioShort> estadiosShort) {
		List<Estadio> estadios = new ArrayList<Estadio>();
		if(estadiosShort != null) {
			for(EstadioShort estadioShort : estadiosShort){
				estadios.add(EstadioShort.toEstadio(estadioShort));
			}
		}
		return estadios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<SetorShort> getSetorShort() {
		return setorShort;
	}

	public void setSetorShort(List<SetorShort> setorShort) {
		this.setorShort = setorShort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((setorShort == null) ? 0 : setorShort.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadioShort other = (EstadioShort) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (setorShort == null) {
			if (other.setorShort != null)
				return false;
		} else if (!setorShort.equals(other.setorShort))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstadioShort [id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", setorShort=" + setorShort
				+ "]";
	}	
}
