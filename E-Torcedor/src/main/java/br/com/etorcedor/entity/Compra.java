package br.com.etorcedor.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compra implements Serializable {

	private static final long serialVersionUID = 4485708253676759137L;
	private Long id;
	private Date dia;
	private Usuario usuario;
	private double valorTotal;
	private List<Ingresso> ingressos;
	
	public Compra() {
		
	}
	
	public Compra(Date dia, Usuario usuario, List<Ingresso> ingressos) {
		this.dia = dia;
		this.usuario = usuario;
		this.ingressos = ingressos;
	}
	
	public Compra(Long id, Date dia, Usuario usuario, double valorTotal, List<Ingresso> ingressos) {
		this.id = id;
		this.dia = dia;
		this.usuario = usuario;
		this.valorTotal = valorTotal;
		this.ingressos = ingressos;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	@OneToMany(mappedBy = "compra", fetch = FetchType.EAGER)
	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingressos == null) ? 0 : ingressos.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Compra other = (Compra) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
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
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", dia=" + dia + ", usuario=" + usuario + ", valorTotal=" + valorTotal
				+ ", ingressos=" + ingressos + "]";
	}	
}
