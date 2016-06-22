package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.List;

import br.com.etorcedor.entity.Torcida;

public class TorcidaShort {

	private Long id;
	private int socios;
	private String nome;

	public TorcidaShort() {
		
	}
	
	public TorcidaShort(int socios, String nome) {
		this.socios = socios;
		this.nome = nome;
	}

	public TorcidaShort(Long id, int socios, String nome) {
		this.id = id;
		this.socios = socios;
		this.nome = nome;
	}
	
	public static TorcidaShort toTorcidaShort(Torcida torcida) {
		TorcidaShort short1 = new TorcidaShort();
		short1.setId(torcida.getId());
		short1.setNome(torcida.getNome());
		short1.setSocios(torcida.getSocios());
		return short1;
	}
	
	public static Torcida toTorcida(TorcidaShort torcidashort) {
		Torcida torcida = new Torcida();
		torcida.setId(torcidashort.getId());
		torcida.setNome(torcidashort.getNome());
		torcida.setSocios(torcidashort.getSocios());
		return torcida;
	}
	
	public static List<Torcida> toTorcida(List<TorcidaShort> torcidashort) {
		Torcida torcida = new Torcida();
		List<Torcida> torcidas = new ArrayList<Torcida>();
		for(TorcidaShort short1: torcidashort) {
			torcida.setId(short1.getId());
			torcida.setNome(short1.getNome());
			torcida.setSocios(short1.getSocios());
			torcidas.add(torcida);
		}
		return torcidas;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSocios() {
		return socios;
	}

	public void setSocios(int socios) {
		this.socios = socios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + socios;
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
		if (socios != other.socios)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TorcidaShort [id=" + id + ", socios=" + socios + ", nome=" + nome + "]";
	}

}
