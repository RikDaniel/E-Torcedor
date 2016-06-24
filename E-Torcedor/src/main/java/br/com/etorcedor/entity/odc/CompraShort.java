package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Compra;

public class CompraShort {

	private Long id;
	private Date dia;
	private double valorTotal;
	private List<IngressoShort> ingressoShort;

	public CompraShort() {

	}
	
	public CompraShort(Date dia, double valorTotal) {
		this.dia = dia;
		this.valorTotal = valorTotal;
	}

	public CompraShort(Date dia, double valorTotal, List<IngressoShort> ingressoShort) {
		this.dia = dia;
		this.valorTotal = valorTotal;
		this.ingressoShort = ingressoShort;
	}

	public CompraShort(Long id, Date dia, double valorTotal, List<IngressoShort> ingressoShort) {
		this.id = id;
		this.dia = dia;
		this.valorTotal = valorTotal;
		this.ingressoShort = ingressoShort;
	}
	
	public static CompraShort toCompraShort(Compra compra) {
		CompraShort compraShort = new CompraShort();
		if(compra != null) {
			compraShort.setId(compra.getId());
			compraShort.setDia(compra.getDia());
			compraShort.setValorTotal(compra.getValorTotal());
			compraShort.setIngressoShort(IngressoShort.toIngressoShort(compra.getIngressos()));
		}
		return compraShort;
	}
	
	public static List<CompraShort> toCompraShort(List<Compra> compras) {
		List<CompraShort> compraShort = new ArrayList<CompraShort>();
		if(compras != null) {
			for(Compra compra : compras) {
				compraShort.add(CompraShort.toCompraShort(compra));
			}
		}
		return compraShort;
	}

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

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<IngressoShort> getIngressoShort() {
		return ingressoShort;
	}

	public void setIngressoShort(List<IngressoShort> ingressoShort) {
		this.ingressoShort = ingressoShort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingressoShort == null) ? 0 : ingressoShort.hashCode());
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
		CompraShort other = (CompraShort) obj;
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
		if (ingressoShort == null) {
			if (other.ingressoShort != null)
				return false;
		} else if (!ingressoShort.equals(other.ingressoShort))
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompraShort [id=" + id + ", dia=" + dia + ", valorTotal=" + valorTotal + ", ingressoShort="
				+ ingressoShort + "]";
	}
}
