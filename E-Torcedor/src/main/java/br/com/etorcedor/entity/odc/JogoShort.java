package br.com.etorcedor.entity.odc;

import java.util.Date;

import br.com.etorcedor.entity.Jogo;

public class JogoShort {

	private Long id;
	private Date data;
	private String estadioNome;
	private String apelido;

	public JogoShort() {

	}

	public JogoShort(Date data, String estadioNome, String apelido) {
		this.data = data;
		this.estadioNome = estadioNome;
		this.apelido = apelido;
	}

	public JogoShort(Long id, Date data, String estadioNome, String apelido) {
		this.id = id;
		this.data = data;
		this.estadioNome = estadioNome;
		this.apelido = apelido;
	}

	public JogoShort toJogosShort(Jogo jogo) {
		JogoShort jogoShort = new JogoShort();
		jogoShort.setData(jogo.getData());
		jogoShort.setEstadioNome(jogo.getEstadio().getNome());
		jogoShort.setApelido(jogo.getEstadio().getApelido());
		return jogoShort;
	}

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

	public String getEstadioNome() {
		return estadioNome;
	}

	public void setEstadioNome(String estadioNome) {
		this.estadioNome = estadioNome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((estadioNome == null) ? 0 : estadioNome.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		JogoShort other = (JogoShort) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (estadioNome == null) {
			if (other.estadioNome != null)
				return false;
		} else if (!estadioNome.equals(other.estadioNome))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JogoShort [id=" + id + ", data=" + data + ", estadioNome=" + estadioNome + ", apelido=" + apelido
				+ "]";
	}
}
