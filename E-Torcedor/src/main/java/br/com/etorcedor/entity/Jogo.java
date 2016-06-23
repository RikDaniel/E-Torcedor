package br.com.etorcedor.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Jogo implements Serializable {

	private static final long serialVersionUID = 1892054941459772393L;
	
	private Long id;
	private List<Time> times;
	private Date data;
	private int ingressos_quantidade;
	private int ingressos_vendidos;
	private List<Ingresso> ingressos;
	private Estadio estadio;

	public Jogo() {

	}

	public Jogo(Date data, int ingressos_quantidade, Estadio estadio) {

		this.data = data;
		this.ingressos_quantidade = ingressos_quantidade;
		this.estadio = estadio;
	}

	public Jogo(Long id, List<Time> times, Date data, int ingressos_quantidade, int ingressos_vendidos,
			List<Ingresso> ingressos, Estadio estadio) {
		this.id = id;
		this.times = times;
		this.data = data;
		this.ingressos_quantidade = ingressos_quantidade;
		this.ingressos_vendidos = ingressos_vendidos;
		this.ingressos = ingressos;
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

	public int getIngressos_quantidade() {
		return ingressos_quantidade;
	}

	public void setIngressos_quantidade(int ingressos_quantidade) {
		this.ingressos_quantidade = ingressos_quantidade;
	}

	public int getIngressos_vendidos() {
		return ingressos_vendidos;
	}

	public void setIngressos_vendidos(int ingressos_vendidos) {
		this.ingressos_vendidos = ingressos_vendidos;
	}

	@OneToMany(mappedBy = "jogo", fetch = FetchType.EAGER)
	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
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
		result = prime * result + ((ingressos == null) ? 0 : ingressos.hashCode());
		result = prime * result + ingressos_quantidade;
		result = prime * result + ingressos_vendidos;
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
		if (ingressos == null) {
			if (other.ingressos != null)
				return false;
		} else if (!ingressos.equals(other.ingressos))
			return false;
		if (ingressos_quantidade != other.ingressos_quantidade)
			return false;
		if (ingressos_vendidos != other.ingressos_vendidos)
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
		return "Jogo [id=" + id + ", times=" + times + ", data=" + data + ", ingressos_quantidade="
				+ ingressos_quantidade + ", ingressos_vendidos=" + ingressos_vendidos + ", ingressos=" + ingressos
				+ ", estadio=" + estadio + "]";
	}
}