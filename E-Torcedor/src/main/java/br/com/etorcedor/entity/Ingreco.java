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
		super();
	}

	public Ingreco(Long id, Date data, Jogo jogo, int numero_acento, float valor_ingreco, Usuario usuario,
			Setor setor) {
		super();
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

}