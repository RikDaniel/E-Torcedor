package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.List;

import br.com.etorcedor.entity.Torcida;

public class TorcidaShort {

	private Long id;
	private String nome;
	private TimeShort timeShort;

	public TorcidaShort() {
		
	}
	
	public TorcidaShort(String nome) {
		this.nome = nome;
	}
	
	public TorcidaShort(TimeShort timeShort, String nome) {
		this.nome = nome;
		this.timeShort = timeShort;
	}
	
	public static TorcidaShort toTorcidaShort(Torcida torcida) {
		TorcidaShort short1 = new TorcidaShort();
		short1.setId(torcida.getId());
		short1.setNome(torcida.getNome());
		short1.setTimeShort(TimeShort.toTimeShort(torcida.getTime()));
		return short1;
	}
	
	public static List<TorcidaShort> toTorcidaShort(List<Torcida> torcidas) {
		List<TorcidaShort> torcidashort = new ArrayList<TorcidaShort>();
		for(Torcida torcida: torcidas) {
			torcidashort.add(TorcidaShort.toTorcidaShort(torcida));
		}
		return torcidashort;
	}
	
	public static Torcida toTorcida(TorcidaShort torcidashort) {
		Torcida torcida = new Torcida();
		torcida.setId(torcidashort.getId());
		torcida.setNome(torcidashort.getNome());
		torcida.setTime(TimeShort.toTime(torcidashort.getTimeShort()));
		return torcida;
	}
	
	public static List<Torcida> toTorcida(List<TorcidaShort> torcidashort) {
		List<Torcida> torcidas = new ArrayList<Torcida>();
		for(TorcidaShort short1: torcidashort) {
			torcidas.add(TorcidaShort.toTorcida(short1));
		}
		return torcidas;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TimeShort getTimeShort() {
		return timeShort;
	}

	public void setTimeShort(TimeShort timeShort) {
		this.timeShort = timeShort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((timeShort == null) ? 0 : timeShort.hashCode());
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
		TorcidaShort other = (TorcidaShort) obj;
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
		if (timeShort == null) {
			if (other.timeShort != null)
				return false;
		} else if (!timeShort.equals(other.timeShort))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TorcidaShort [id=" + id + ", nome=" + nome + ", timeShort=" + timeShort + "]";
	}

}
