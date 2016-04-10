package br.com.etorcedor.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Jogo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private List<Time> times;
	private Date data;
	private int ingrecos_quantidade;
	private int ingrecos_vendidos;
	private List<Ingreco> ingrecos;
	private Estadio estadio;

	public Jogo() {
		
	}

	public Jogo(Long id, List<Time> times, Date data, int ingrecos_quantidade, int ingrecos_vendidos,
			List<Ingreco> ingrecos, Estadio estadio) {
		this.id = id;
		this.times = times;
		this.data = data;
		this.ingrecos_quantidade = ingrecos_quantidade;
		this.ingrecos_vendidos = ingrecos_vendidos;
		this.ingrecos = ingrecos;
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

	@ManyToMany(mappedBy = "jogos")
	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIngrecos_quantidade() {
		return ingrecos_quantidade;
	}

	public void setIngrecos_quantidade(int ingrecos_quantidade) {
		this.ingrecos_quantidade = ingrecos_quantidade;
	}

	public int getIngrecos_vendidos() {
		return ingrecos_vendidos;
	}

	public void setIngrecos_vendidos(int ingrecos_vendidos) {
		this.ingrecos_vendidos = ingrecos_vendidos;
	}

	@OneToMany(mappedBy = "jogo")
	public List<Ingreco> getIngrecos() {
		return ingrecos;
	}

	public void setIngrecos(List<Ingreco> ingrecos) {
		this.ingrecos = ingrecos;
	}

	@ManyToOne
	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((estadio == null) ? 0 : estadio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingrecos == null) ? 0 : ingrecos.hashCode());
		result = prime * result + ingrecos_quantidade;
		result = prime * result + ingrecos_vendidos;
		result = prime * result + ((times == null) ? 0 : times.hashCode());
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
		Jogo other = (Jogo) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
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
		if (ingrecos_quantidade != other.ingrecos_quantidade)
			return false;
		if (ingrecos_vendidos != other.ingrecos_vendidos)
			return false;
		if (times == null) {
			if (other.times != null)
				return false;
		} else if (!times.equals(other.times))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jogo [id=" + id + ", times=" + times + ", data=" + data + ", ingrecos_quantidade=" + ingrecos_quantidade
				+ ", ingrecos_vendidos=" + ingrecos_vendidos + ", ingrecos=" + ingrecos + ", estadio=" + estadio + "]";
	}
}