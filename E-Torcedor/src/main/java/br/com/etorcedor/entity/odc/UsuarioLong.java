package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Usuario;

public class UsuarioLong extends UsuarioPai {
	
	private TorcidaShort torcidaShort;
	private List<DelitoShort> delitos;
	private List<CompraShort> compras;
	
	public UsuarioLong() {
	
	}
	
	public UsuarioLong(TorcidaShort torcidaShort, List<DelitoShort> delitos, List<CompraShort> compras) {
		this.torcidaShort = torcidaShort;
		this.delitos = delitos;
		this.compras = compras;
	}

	public UsuarioLong(Long id, String cpf, String nome, String genero, String telefone, String email,
			Date dataNascimento, TimeShort clube) {
		super(id, cpf, nome, genero, telefone, email, dataNascimento, clube);
	}

	public UsuarioLong(String cpf, String nome, String genero, String telefone, String email, Date dataNascimento,
			TimeShort clube) {
		super(cpf, nome, genero, telefone, email, dataNascimento, clube);
	}
	
	public static UsuarioLong toUsuarioLong(Usuario usuario) {
		UsuarioLong usuariolong = new UsuarioLong();
		if(usuario != null) {
			toUsuarioPai(usuario);
			usuariolong.setTorcidaShort(TorcidaShort.toTorcidaShort(usuario.getTorcida()));
			usuariolong.setDelitos(DelitoShort.toDelitoShort(usuario.getDelitos()));
			usuariolong.setCompras(CompraShort.toCompraShort(usuario.getCompras()));
		}
		return usuariolong;
	}
	
	public static List<UsuarioLong> toUsuarioLong(List<Usuario> usuarios) {
		List<UsuarioLong> usuariolong = new ArrayList<UsuarioLong>();
		if(usuarios != null) {
			for(Usuario usuario : usuarios) {
				usuariolong.add(UsuarioLong.toUsuarioLong(usuario));
			}
		}
		return usuariolong;
	}

	public TorcidaShort getTorcidaShort() {
		return torcidaShort;
	}
	public void setTorcidaShort(TorcidaShort torcidaShort) {
		this.torcidaShort = torcidaShort;
	}
	public List<DelitoShort> getDelitos() {
		return delitos;
	}
	public void setDelitos(List<DelitoShort> delitos) {
		this.delitos = delitos;
	}
	public List<CompraShort> getCompras() {
		return compras;
	}
	public void setCompras(List<CompraShort> compras) {
		this.compras = compras;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((compras == null) ? 0 : compras.hashCode());
		result = prime * result + ((delitos == null) ? 0 : delitos.hashCode());
		result = prime * result + ((torcidaShort == null) ? 0 : torcidaShort.hashCode());
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
		UsuarioLong other = (UsuarioLong) obj;
		if (compras == null) {
			if (other.compras != null)
				return false;
		} else if (!compras.equals(other.compras))
			return false;
		if (delitos == null) {
			if (other.delitos != null)
				return false;
		} else if (!delitos.equals(other.delitos))
			return false;
		if (torcidaShort == null) {
			if (other.torcidaShort != null)
				return false;
		} else if (!torcidaShort.equals(other.torcidaShort))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UsuarioLong [torcidaShort=" + torcidaShort + ", delitos=" + delitos + ", compras=" + compras + "]";
	}
}
