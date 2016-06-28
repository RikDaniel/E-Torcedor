package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.List;

import br.com.etorcedor.entity.Usuario;

public class UsuarioShort extends UsuarioPai {
	
	public UsuarioShort() {
		super();
	}
	
	public static UsuarioShort toUsuarioShort(Usuario usuario) {
		UsuarioShort usuarioShort = new UsuarioShort();
		if(usuario!= null) {
			usuarioShort.setId(usuario.getId());
			usuarioShort.setCpf(usuario.getCpf());
			usuarioShort.setNome(usuario.getNome());
			usuarioShort.setGenero(usuario.getGenero());
			usuarioShort.setTelefone(usuario.getTelefone());
			usuarioShort.setEmail(usuario.getEmail());
			usuarioShort.setDataNascimento(usuario.getDataNascimento());
			usuarioShort.setClube(TimeShort.toTimeShort(usuario.getClube()));	
		}
		return usuarioShort;
	}
	
	public static Usuario toUsuario(UsuarioShort usuarioShort) {
		Usuario usuario = new Usuario();
		if(usuarioShort != null) {
			usuario.setId(usuarioShort.getId());
			usuario.setCpf(usuarioShort.getCpf());
			usuario.setNome(usuarioShort.getNome());
			usuario.setGenero(usuarioShort.getGenero());
			usuario.setTelefone(usuarioShort.getTelefone());
			usuario.setEmail(usuarioShort.getEmail());
			usuario.setDataNascimento(usuarioShort.getDataNascimento());
		//	usuario.setClube(TimeShort.toTime(usuarioShort.getClube()));	
		}
		
		return usuario;
	}
	
	public static List<Usuario> toUsuario(List<UsuarioShort> usuarioShorts) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		if(usuarioShorts != null) {
			for(UsuarioShort usuarioShort : usuarioShorts) {
				usuarios.add(UsuarioShort.toUsuario(usuarioShort));
			}
		}	
		return usuarios;
	}
	
	public static List<UsuarioShort> toUsuarioShort(List<Usuario> usuarios) {
		List<UsuarioShort> usuarioShorts = new ArrayList<UsuarioShort>();
		if(usuarios != null) {
			for(Usuario usuario : usuarios) {
				usuarioShorts.add(UsuarioShort.toUsuarioShort(usuario));
			}
		}
		return usuarioShorts;
	}
}
