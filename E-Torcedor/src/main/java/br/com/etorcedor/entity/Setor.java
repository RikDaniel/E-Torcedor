package br.com.etorcedor.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Setor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private int numero_cadeiras;
	private Estadio estadio;
	private List<Ingresso> ingrecos;

	public Setor() {
		
	}

	public Setor(Long id, String nome, int numero_cadeiras, Estadio estadio) {
		this.id = id;
		this.nome = nome;
		this.numero_cadeiras = numero_cadeiras;
		this.estadio = estadio;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public int getNumero_cadeiras() {
		return numero_cadeiras;
	}

	public void setNumero_cadeiras(int numero_cadeiras) {
		this.numero_cadeiras = numero_cadeiras;
	}

	@ManyToOne
	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
	
	@OneToMany
	public List<Ingresso> getIngrecos() {
		return ingrecos;
	}

	public void setIngrecos(List<Ingresso> ingrecos) {
		this.ingrecos = ingrecos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadio == null) ? 0 : estadio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingrecos == null) ? 0 : ingrecos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numero_cadeiras;
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
		Setor other = (Setor) obj;
		if (estadio == null) {
			if (other.estadio != null)
				return false;
		} else if (!estadio.equals(other.estadio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingrecos == null) {
			if (other.ingrecos != null)
				return false;
		} else if (!ingrecos.equals(other.ingrecos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero_cadeiras != other.numero_cadeiras)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", nome=" + nome + ", numero_cadeiras=" + numero_cadeiras + ", estadio=" + estadio
				+ ", ingrecos=" + ingrecos + "]";
	}
}