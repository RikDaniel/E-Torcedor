package br.com.etorcedor.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String cpf;
	private String nome;
	private Byte imagem;
	private String genero;
	private String telefone;
	private String email;
	private Date data_nascimento;
	private Torcida torcida;
	private Time clube;
	private List<Ingreco> ingrecos;
	
	public Usuario() {
		super();
	}

	public Usuario(Long id, String cpf, String nome, Byte imagem, String genero, String telefone, String email,
			Date data_nascimento, Torcida torcida, Time clube, List<Ingreco> ingrecos) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.imagem = imagem;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.data_nascimento = data_nascimento;
		this.torcida = torcida;
		this.clube = clube;
		this.ingrecos = ingrecos;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public Byte getImagem() {
		return imagem;
	}

	public void setImagem(Byte imagem) {
		this.imagem = imagem;
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

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
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

	@OneToMany(mappedBy= "usuario")
	public List<Ingreco> getIngrecos() {
		return ingrecos;
	}

	public void setIngrecos(List<Ingreco> ingrecos) {
		this.ingrecos = ingrecos;
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
		result = prime * result + ((data_nascimento == null) ? 0 : data_nascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
		result = prime * result + ((ingrecos == null) ? 0 : ingrecos.hashCode());
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
		if (data_nascimento == null) {
			if (other.data_nascimento != null)
				return false;
		} else if (!data_nascimento.equals(other.data_nascimento))
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
		if (imagem == null) {
			if (other.imagem != null)
				return false;
		} else if (!imagem.equals(other.imagem))
			return false;
		if (ingrecos == null) {
			if (other.ingrecos != null)
				return false;
		} else if (!ingrecos.equals(other.ingrecos))
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
		return "Usuario [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", imagem=" + imagem + ", genero=" + genero
				+ ", telefone=" + telefone + ", email=" + email + ", data_nascimento=" + data_nascimento + ", torcida="
				+ torcida + ", clube=" + clube + ", ingrecos=" + ingrecos + "]";
	}
	
	
	
}
