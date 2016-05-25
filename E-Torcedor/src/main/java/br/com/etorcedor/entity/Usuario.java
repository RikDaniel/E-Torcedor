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
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String cpf;
	private String nome;
	private String genero;
	private String telefone;
	private String email;
	private Date dataNascimento;
	private Torcida torcida;
	private Time clube;
	private List<Ingresso> ingressos;

	public Usuario() {

	}

	public Usuario(Long id, String cpf, String nome, String genero, String telefone, String email,
			Date dataNascimento) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Usuario(Long id, String cpf, String nome, String genero, String telefone, String email, Date dataNascimento,
			Torcida torcida, Time clube, List<Ingresso> ingressos) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.torcida = torcida;
		this.clube = clube;
		this.ingressos = ingressos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@ManyToOne
	public Torcida getTorcida() {
		return torcida;
	}

	public void setTorcida(Torcida torcida) {
		this.torcida = torcida;
	}

	public Time getClube() {
		return clube;
	}

	public void setClube(Time clube) {
		this.clube = clube;
	}

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingrecos) {
		this.ingressos = ingrecos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		result = prime * result + ((ingressos == null) ? 0 : ingressos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((torcida == null) ? 0 : torcida.hashCode());
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
		Usuario other = (Usuario) obj;
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
		if (ingressos == null) {
			if (other.ingressos != null)
				return false;
		} else if (!ingressos.equals(other.ingressos))
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
		if (torcida == null) {
			if (other.torcida != null)
				return false;
		} else if (!torcida.equals(other.torcida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", genero=" + genero + ", telefone=" + telefone
				+ ", email=" + email + ", dataNascimento=" + dataNascimento + ", torcida=" + torcida + ", clube="
				+ clube + ", ingressos=" + ingressos + "]";
	}
}