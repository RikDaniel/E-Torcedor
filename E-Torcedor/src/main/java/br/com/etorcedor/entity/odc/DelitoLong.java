package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Delito;

public class DelitoLong extends DelitoPai{
	
	private List<UsuarioShort> usuarios;

	public DelitoLong() {
	
	}

	public DelitoLong(long bo, Date dia, String descricaoDelito, int numeroJogosSuspensao) {
		super(bo, dia, descricaoDelito, numeroJogosSuspensao);
	}

	public DelitoLong(long bo, Date dia, String descricaoDelito, int numeroJogosSuspensao, List<UsuarioShort> usuarios) {
		super(bo, dia, descricaoDelito, numeroJogosSuspensao);
		this.usuarios = usuarios;
	}
	
	public DelitoLong(Long id, long bo, Date dia, String descricaoDelito, int numeroJogosSuspensao) {
		super(id, bo, dia, descricaoDelito, numeroJogosSuspensao);
	}
	
	public DelitoLong(Long id, long bo, Date dia, String descricaoDelito, int numeroJogosSuspensao, List<UsuarioShort> usuarios) {
		super(id, bo, dia, descricaoDelito, numeroJogosSuspensao);
		this.usuarios = usuarios;
	}
	
	public static DelitoLong toDelitoLong(Delito delito) {
		DelitoLong delitoLong = new DelitoLong();
		if(delito != null) {
			delitoLong.setBo(delito.getBo());
			delitoLong.setDescricaoDelito(delito.getDescricaoDelito());
			delitoLong.setDia(delito.getDia());
			delitoLong.setId(delito.getId());
			delitoLong.setNumeroJogosSuspensao(delito.getNumeroJogosSuspensao());
			delitoLong.setUsuarios(UsuarioShort.toUsuarioShort(delito.getUsuarios()));
			delitoLong.setNumeroJogosSuspensao(delito.getNumeroJogosSuspensao());
		}
		return delitoLong;
	}
	
	public static List<DelitoLong> toDelitoLong(List<Delito> delitos) {
		List<DelitoLong> delitosLong = new ArrayList<DelitoLong>();
		if(delitos != null) {
			for(Delito delito : delitos) {
				delitosLong.add(DelitoLong.toDelitoLong(delito));
			}
		}
		return delitosLong;
	}
	
	public static Delito toDelito(DelitoLong delitoLong) {
		Delito delito = new Delito();
		if(delitoLong != null) {
			delito.setBo(delitoLong.getBo());
			delito.setDescricaoDelito(delitoLong.getDescricaoDelito());
			delito.setDia(delitoLong.getDia());
			delito.setId(delitoLong.getId());
			delito.setNumeroJogosSuspensao(delitoLong.getNumeroJogosSuspensao());
			delito.setUsuarios(UsuarioShort.toUsuario(delitoLong.getUsuarios()));
		}
		return delito;
	}
	
	public List<Delito> toDelito(List<DelitoLong> delitoLongs) {
		List<Delito> delitos = new ArrayList<Delito>();
		if(delitoLongs != null){
			for(DelitoLong delito : delitoLongs) {
				delitos.add(DelitoLong.toDelito(delito));
			}
		}
		return delitos;
	}

	public List<UsuarioShort> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioShort> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DelitoLong other = (DelitoLong) obj;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DelitoLong [usuarios=" + usuarios + "]";
	}
}
