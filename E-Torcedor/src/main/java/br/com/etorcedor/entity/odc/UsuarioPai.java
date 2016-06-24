package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Usuario;

public abstract class UsuarioPai {
	
	private Long id;
	private String cpf;
	private String nome;
	private String genero;
	private String telefone;
	private String email;
	private Date dataNascimento;
	private TimeShort clube;
	
	public UsuarioPai() {
	
	}
	
	public UsuarioPai(String cpf, String nome, String genero, String telefone, String email,
			Date dataNascimento, TimeShort clube) {
		
		this.cpf = cpf;
		this.nome = nome;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.clube = clube;
	}
	
	public UsuarioPai(Long id, String cpf, String nome, String genero, String telefone, String email,
			Date dataNascimento, TimeShort clube) {
		
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.clube = clube;
	}
	
	public static UsuarioPai toUsuarioPai(Usuario usuario) {
		UsuarioPai usuarioPai = new UsuarioShort();
		if(usuario != null) {
			usuarioPai.setId(usuario.getId());
			usuarioPai.setCpf(usuario.getCpf());
			usuarioPai.setNome(usuario.getNome());
			usuarioPai.setGenero(usuario.getGenero());
			usuarioPai.setTelefone(usuario.getTelefone());
			usuarioPai.setEmail(usuario.getEmail());
			usuarioPai.setDataNascimento(usuario.getDataNascimento());
			usuarioPai.setClube(TimeShort.toTimeShort(usuario.getClube()));			
		}
		return usuarioPai;
	}
	
	public static List<UsuarioPai> toUsuarioPai(List<Usuario> usuarios) {
		List<UsuarioPai> usuarioPai = new ArrayList<UsuarioPai>();
		if(usuarios != null) {
			for(Usuario usuario : usuarios) {
				usuarioPai.add(UsuarioPai.toUsuarioPai(usuario));
			}
		}
		return usuarioPai;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public TimeShort getClube() {
		return clube;
	}
	public void setClube(TimeShort clube) {
		this.clube = clube;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clube == null) ? 0 : clube.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		UsuarioPai other = (UsuarioPai) obj;
		if (clube == null) {
			if (other.clube != null)
				return false;
		} else if (!clube.equals(other.clube))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UsuarioPai [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", genero=" + genero + ", telefone="
				+ telefone + ", email=" + email + ", dataNascimento=" + dataNascimento + ", clube=" + clube + "]";
	}
}
