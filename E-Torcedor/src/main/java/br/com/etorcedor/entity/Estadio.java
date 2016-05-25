package br.com.etorcedor.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estadio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private List<Jogo> jogos;
	private List<Setor> setores;

	public Estadio() {

	}

	public Estadio(Long id, List<Jogo> jogos, List<Setor> setores) {
		this.id = id;
		this.jogos = jogos;
		this.setores = setores;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "estadio", fetch = FetchType.EAGER)
	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jogos == null) ? 0 : jogos.hashCode());
		result = prime * result + ((setores == null) ? 0 : setores.hashCode());
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
		Estadio other = (Estadio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jogos == null) {
			if (other.jogos != null)
				return false;
		} else if (!jogos.equals(other.jogos))
			return false;
		if (setores == null) {
			if (other.setores != null)
				return false;
		} else if (!setores.equals(other.setores))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estadio [id=" + id + ", jogos=" + jogos + ", setores=" + setores + "]";
	}
}