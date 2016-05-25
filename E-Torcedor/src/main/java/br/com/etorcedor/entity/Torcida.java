package br.com.etorcedor.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Torcida implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private int socios;
	private String nome;
	private Time time;
	private List<Usuario> torcedores;

	public Torcida() {

	}

	public Torcida(Long id, int socios, String nome, Time time, List<Usuario> torcedores) {
		this.id = id;
		this.socios = socios;
		this.nome = nome;
		this.time = time;
		this.torcedores = torcedores;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@ManyToOne
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@OneToMany(mappedBy = "torcida", fetch = FetchType.EAGER)
	public List<Usuario> getTorcedores() {
		return torcedores;
	}

	public void setTorcedores(List<Usuario> torcedores) {
		this.torcedores = torcedores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + socios;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((torcedores == null) ? 0 : torcedores.hashCode());
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
		Torcida other = (Torcida) obj;
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
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (torcedores == null) {
			if (other.torcedores != null)
				return false;
		} else if (!torcedores.equals(other.torcedores))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Torcida [id=" + id + ", socios=" + socios + ", nome=" + nome + ", time=" + time + ", torcedores="
				+ torcedores + "]";
	}
}