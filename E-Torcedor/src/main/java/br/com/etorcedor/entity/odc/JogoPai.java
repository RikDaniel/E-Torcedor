package br.com.etorcedor.entity.odc;

import java.util.Date;

import br.com.etorcedor.entity.Jogo;

public class JogoPai {
	
	private Long id;
	private Date data;
	private String estadioNome;
	private String estadioApelido;
	
	public JogoPai() {
		
	}
	
	public JogoPai(Long id, Date data, String estadioNome, String estadioApelido) {
		super();
		this.id = id;
		this.data = data;
		this.estadioNome = estadioNome;
		this.estadioApelido = estadioApelido;
	}

	public JogoPai(Date data, String estadioNome, String estadioApelido) {
		super();
		this.data = data;
		this.estadioNome = estadioNome;
		this.estadioApelido = estadioApelido;
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

	public String getEstadioApelido() {
		return estadioApelido;
	}

	public void setEstadioApelido(String estadioApelido) {
		this.estadioApelido = estadioApelido;
	}
	
	public static JogoPai toJogoPai(Jogo jogo) {
		JogoPai jogoPai = new JogoPai();
		if(jogo != null) {
			jogoPai.setEstadioApelido(jogo.getEstadio().getApelido());
			jogoPai.setEstadioNome(jogo.getEstadio().getNome());
			jogoPai.setData(jogo.getData());
			jogoPai.setId(jogo.getId());
		}
		return jogoPai;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((estadioApelido == null) ? 0 : estadioApelido.hashCode());
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
		JogoPai other = (JogoPai) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (estadioApelido == null) {
			if (other.estadioApelido != null)
				return false;
		} else if (!estadioApelido.equals(other.estadioApelido))
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
		return "JogoPai [id=" + id + ", data=" + data + ", estadioNome=" + estadioNome + ", estadioApelido="
				+ estadioApelido + "]";
	}	
}