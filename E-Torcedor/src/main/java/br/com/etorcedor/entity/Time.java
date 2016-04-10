package br.com.etorcedor.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Time implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private List<Torcida> torcidas;
	private List<Jogo> jogos;
	
	public Time() {
		super();
	}
	
	public Time(Long id, String nome, List<Torcida> torcidas, List<Jogo> jogos) {
		super();
		this.id = id;
		this.nome = nome;
		this.torcidas = torcidas;
		this.jogos = jogos;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@OneToMany(mappedBy="time")
	public List<Torcida> getTorcidas() {
		return torcidas;
	}

	public void setTorcidas(List<Torcida> torcidas) {
		this.torcidas = torcidas;
	}
	
	@ManyToMany
	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jogos == null) ? 0 : jogos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((torcidas == null) ? 0 : torcidas.hashCode());
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
		Time other = (Time) obj;
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (torcidas == null) {
			if (other.torcidas != null)
				return false;
		} else if (!torcidas.equals(other.torcidas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + ", torcidas=" + torcidas + ", jogos=" + jogos + "]";
	}
	
	
	
}
