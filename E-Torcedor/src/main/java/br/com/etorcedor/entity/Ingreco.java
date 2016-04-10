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
public class Ingreco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date data;
	private Jogo jogo;
	private int numero_acento;
	private float valor_ingreco;
	private Usuario usuario;
	private Setor setor;

	public Ingreco() {
		
	}

	public Ingreco(Long id, Date data, Jogo jogo, int numero_acento, float valor_ingreco, Usuario usuario,
			Setor setor) {
		this.id = id;
		this.data = data;
		this.jogo = jogo;
		this.numero_acento = numero_acento;
		this.valor_ingreco = valor_ingreco;
		this.usuario = usuario;
		this.setSetor(setor);
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

	public int getNumero_acento() {
		return numero_acento;
	}

	public void setNumero_acento(int numero_acento) {
		this.numero_acento = numero_acento;
	}

	public float getValor_ingreco() {
		return valor_ingreco;
	}

	public void setValor_ingreco(float valor_ingreco) {
		this.valor_ingreco = valor_ingreco;
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
		result = prime * result + numero_acento;
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + Float.floatToIntBits(valor_ingreco);
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
		Ingreco other = (Ingreco) obj;
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
		if (numero_acento != other.numero_acento)
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
		if (Float.floatToIntBits(valor_ingreco) != Float.floatToIntBits(other.valor_ingreco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingreco [id=" + id + ", data=" + data + ", jogo=" + jogo + ", numero_acento=" + numero_acento
				+ ", valor_ingreco=" + valor_ingreco + ", usuario=" + usuario + ", setor=" + setor + "]";
	}
}