package br.com.etorcedor.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso implements Serializable {

	private static final long serialVersionUID = -1692556219162243475L;
	private Long id;
	private Date data;
	private Jogo jogo;
	private int numeroAcento;
	private float valorIngresso;
	private Usuario usuario;
	private Setor setor;

	public Ingresso() {

	}

	public Ingresso(Date data, Jogo jogo, int numeroAcento, float valorIngresso, Usuario usuario, Setor setor) {
		this.data = data;
		this.jogo = jogo;
		this.numeroAcento = numeroAcento;
		this.valorIngresso = valorIngresso;
		this.usuario = usuario;
		this.setor = setor;
	}

	public Ingresso(Long id, Date data, Jogo jogo, int numeroAcento, float valorIngresso, Usuario usuario,
			Setor setor) {
		this.id = id;
		this.data = data;
		this.jogo = jogo;
		this.numeroAcento = numeroAcento;
		this.valorIngresso = valorIngresso;
		this.usuario = usuario;
		this.setor = setor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@ManyToOne
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public int getNumeroAcento() {
		return numeroAcento;
	}

	public void setNumeroAcento(int numeroAcento) {
		this.numeroAcento = numeroAcento;
	}

	public float getValorIngresso() {
		return valorIngresso;
	}

	public void setValorIngresso(float valorIngresso) {
		this.valorIngresso = valorIngresso;
	}

	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}

	@ManyToOne
	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jogo == null) ? 0 : jogo.hashCode());
		result = prime * result + numeroAcento;
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + Float.floatToIntBits(valorIngresso);
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
		Ingresso other = (Ingresso) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jogo == null) {
			if (other.jogo != null)
				return false;
		} else if (!jogo.equals(other.jogo))
			return false;
		if (numeroAcento != other.numeroAcento)
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (Float.floatToIntBits(valorIngresso) != Float.floatToIntBits(other.valorIngresso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingresso [id=" + id + ", data=" + data + ", jogo=" + jogo + ", numeroAcento=" + numeroAcento
				+ ", valorIngresso=" + valorIngresso + ", usuario=" + usuario + ", setor=" + setor + "]";
	}
}