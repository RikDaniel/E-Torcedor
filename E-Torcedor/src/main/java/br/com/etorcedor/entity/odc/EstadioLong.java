package br.com.etorcedor.entity.odc;

import java.util.List;

import br.com.etorcedor.entity.Estadio;

public class EstadioLong extends EstadioPai{
	private List<SetorShort> setorShorts;

	public EstadioLong() {
		super();
	}
	

	public EstadioLong(Long id, String nome, String apelido) {
		super(id, nome, apelido);
	}
	
	public EstadioLong(String nome, String apelido) {
		super(nome, apelido);
	}
	
	public EstadioLong(Long id, String nome, String apelido, List<SetorShort> setorShorts) {
		super(id, nome, apelido);
		this.setorShorts = setorShorts;
	}

	public EstadioLong(String nome, String apelido, List<SetorShort> setorShorts) {
		super(nome, apelido);
		this.setorShorts = setorShorts;
	}
	
	public static Estadio toEstadio(EstadioLong estadiolong) {
		Estadio estadio = new Estadio();
		if(estadiolong != null) {
			estadio.setId(estadiolong.getId());
			estadio.setApelido(estadiolong.getApelido());
			estadio.setNome(estadiolong.getNome());
			estadio.setSetores(SetorShort.toSetor(estadiolong.getSetorShorts()));
		}
		return estadio;
	}
	
	public static EstadioLong toEstadioLong(Estadio estadio) {
		EstadioLong estadiolong = new EstadioLong();
		if(estadiolong != null) {
			estadiolong.setId(estadio.getId());
			estadiolong.setApelido(estadio.getApelido());
			estadiolong.setNome(estadio.getNome());
			estadiolong.setSetorShorts((SetorShort.toSetorShort(estadio.getSetores())));
		}
		return estadiolong;
	}

	public List<SetorShort> getSetorShorts() {
		return setorShorts;
	}

	public void setSetorShorts(List<SetorShort> setorShorts) {
		this.setorShorts = setorShorts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((setorShorts == null) ? 0 : setorShorts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadioLong other = (EstadioLong) obj;
		if (setorShorts == null) {
			if (other.setorShorts != null)
				return false;
		} else if (!setorShorts.equals(other.setorShorts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstadioLong [setorShorts=" + setorShorts + "]";
	}
}
