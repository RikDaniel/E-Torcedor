package br.com.etorcedor.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Delito implements Serializable{
	
	private static final long serialVersionUID = 6048957049540648815L;
	private Long id;
	private long bo;
	private Date dia;
	private String descricaoDelito;
	private int numeroJogosSuspensao;
	private List<Usuario> usuarios;
	
	
	public Delito(long bo, Date dia, Date horario, String descricaoDelito, int numeroJogosSuspensao,
			List<Usuario> usuarios) {
		this.bo = bo;
		this.dia = dia;
		this.descricaoDelito = descricaoDelito;
		this.numeroJogosSuspensao = numeroJogosSuspensao;
		this.usuarios = usuarios;
	}
	
	public Delito(Long id, long bo, Date dia, String descricaoDelito, int numeroJogosSuspensao,
			List<Usuario> usuarios) {
		this.id = id;
		this.bo = bo;
		this.dia = dia;
		this.descricaoDelito = descricaoDelito;
		this.numeroJogosSuspensao = numeroJogosSuspensao;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Temporal(TemporalType.TIMESTAMP)
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
	
	@ManyToMany(fetch= FetchType.EAGER)
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
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
		Delito other = (Delito) obj;
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
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Delito [id=" + id + ", bo=" + bo + ", dia=" + dia + ", descricaoDelito=" + descricaoDelito
				+ ", numeroJogosSuspensao=" + numeroJogosSuspensao + ", usuarios=" + usuarios + "]";
	}
}
