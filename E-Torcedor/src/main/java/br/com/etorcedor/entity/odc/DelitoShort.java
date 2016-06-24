package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Delito;

public class DelitoShort {
	
	private Long id;
	private long bo;
	private Date dia;
	private String descricaoDelito;
	private int numeroJogosSuspensao;
	
	
	
	public DelitoShort() {
	
	}
	
	public DelitoShort(long bo, Date dia, String descricaoDelito, int numeroJogosSuspensao) {
		this.bo = bo;
		this.dia = dia;
		this.descricaoDelito = descricaoDelito;
		this.numeroJogosSuspensao = numeroJogosSuspensao;
	}

	public DelitoShort(Long id, long bo, Date dia, String descricaoDelito, int numeroJogosSuspensao) {
		this.id = id;
		this.bo = bo;
		this.dia = dia;
		this.descricaoDelito = descricaoDelito;
		this.numeroJogosSuspensao = numeroJogosSuspensao;
	}
	
	public static DelitoShort toDelitoShort(Delito delito) {
		DelitoShort delitoShort = new DelitoShort();
		if(delito != null) {
			delitoShort.setId(delito.getId());
			delitoShort.setBo(delito.getBo());
			delitoShort.setDescricaoDelito(delito.getDescricaoDelito());
			delitoShort.setDia(delito.getDia());
		}
		return delitoShort;
	}
	
	public static List<DelitoShort> toDelitoShort(List<Delito> delitos) {
		List<DelitoShort> delitoShort = new ArrayList<DelitoShort>();
		if(delitos != null) {
			for(Delito delito : delitos) {
				delitoShort.add(DelitoShort.toDelitoShort(delito));
			}
		}
		return delitoShort;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getBo() {
		return bo;
	}
	public void setBo(long bo) {
		this.bo = bo;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public String getDescricaoDelito() {
		return descricaoDelito;
	}
	public void setDescricaoDelito(String descricaoDelito) {
		this.descricaoDelito = descricaoDelito;
	}
	public int getNumeroJogosSuspensao() {
		return numeroJogosSuspensao;
	}
	public void setNumeroJogosSuspensao(int numeroJogosSuspensao) {
		this.numeroJogosSuspensao = numeroJogosSuspensao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bo ^ (bo >>> 32));
		result = prime * result + ((descricaoDelito == null) ? 0 : descricaoDelito.hashCode());
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numeroJogosSuspensao;
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
		DelitoShort other = (DelitoShort) obj;
		if (bo != other.bo)
			return false;
		if (descricaoDelito == null) {
			if (other.descricaoDelito != null)
				return false;
		} else if (!descricaoDelito.equals(other.descricaoDelito))
			return false;
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
		if (numeroJogosSuspensao != other.numeroJogosSuspensao)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DelitoShort [id=" + id + ", bo=" + bo + ", dia=" + dia + ", descricaoDelito=" + descricaoDelito
				+ ", numeroJogosSuspensao=" + numeroJogosSuspensao + "]";
	}

}
