package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Usuario;

public class UsuarioLong extends UsuarioPai {
	
	private TorcidaShort torcidaShort;
	private List<CompraShort> compras;
	
	public UsuarioLong() {
	
	}
	
	public UsuarioLong(TorcidaShort torcidaShort, List<CompraShort> compras) {
		this.torcidaShort = torcidaShort;
		this.compras = compras;
	}

	public UsuarioLong(Long id, String cpf, String nome, String genero, String telefone, String email,
			Date dataNascimento, TimeShort clube, boolean suspenso) {
		super(id, cpf, nome, genero, telefone, email, dataNascimento, clube,suspenso);
	}

	public UsuarioLong(String cpf, String nome, String genero, String telefone, String email, Date dataNascimento,
			TimeShort clube, boolean suspenso) {
		super(cpf, nome, genero, telefone, email, dataNascimento, clube,suspenso);
	}
	
	public static UsuarioLong toUsuarioLong(Usuario usuario) {
		UsuarioLong usuariolong = new UsuarioLong();
		UsuarioPai usuarioPai = toUsuarioPai(usuario);
		if(usuario != null) {
			usuariolong.setId(usuarioPai.getId());
			usuariolong.setCpf(usuarioPai.getCpf());
			usuariolong.setNome(usuarioPai.getNome());
			usuariolong.setGenero(usuarioPai.getGenero());
			usuariolong.setTelefone(usuarioPai.getTelefone());
			usuariolong.setEmail(usuarioPai.getEmail());
			usuariolong.setDataNascimento(usuarioPai.getDataNascimento());
			usuariolong.setClube(usuarioPai.getClube());		
			usuariolong.setSuspenso(usuario.isSuspenso());
			usuariolong.setTorcidaShort(TorcidaShort.toTorcidaShort(usuario.getTorcida()));
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
		if (torcidaShort == null) {
			if (other.torcidaShort != null)
				return false;
		} else if (!torcidaShort.equals(other.torcidaShort))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UsuarioLong [torcidaShort=" + torcidaShort + ", compras=" + compras + "]";
	}
}
