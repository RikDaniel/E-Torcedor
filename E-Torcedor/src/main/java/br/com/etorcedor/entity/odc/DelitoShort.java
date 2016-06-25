package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Delito;

public class DelitoShort extends DelitoPai{
	
	public DelitoShort() {
	
	}
	
	public DelitoShort(long bo, Date dia, String descricaoDelito, int numeroJogosSuspensao) {
		super(bo, dia, descricaoDelito, numeroJogosSuspensao);
	}

	public DelitoShort(Long id, long bo, Date dia, String descricaoDelito, int numeroJogosSuspensao) {
		super(id, bo, dia, descricaoDelito, numeroJogosSuspensao);
	}

	public static DelitoShort toDelitoShort(Delito delito) {
		DelitoShort delitoShort = new DelitoShort();
		if(delito != null) {
			delitoShort.setId(delito.getId());
			delitoShort.setBo(delito.getBo());
			delitoShort.setDescricaoDelito(delito.getDescricaoDelito());
			delitoShort.setDia(delito.getDia());
			delitoShort.setNumeroJogosSuspensao(delito.getNumeroJogosSuspensao());
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
	
	public static Delito toDelito(DelitoShort delitoShort) {
		Delito delito = new Delito();
		if(delitoShort != null) {
			delito.setBo(delitoShort.getBo());
			delito.setDescricaoDelito(delitoShort.getDescricaoDelito());
			delito.setDia(delitoShort.getDia());
			delito.setId(delitoShort.getId());
			delito.setNumeroJogosSuspensao(delitoShort.getNumeroJogosSuspensao());
		}
		return delito;
	}

	@Override
	public String toString() {
		return "DelitoShort [getId()=" + getId() + ", getBo()=" + getBo() + ", getDia()=" + getDia()
				+ ", getDescricaoDelito()=" + getDescricaoDelito() + ", getNumeroJogosSuspensao()="
				+ getNumeroJogosSuspensao() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}
}
