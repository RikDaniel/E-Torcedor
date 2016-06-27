package br.com.etorcedor.entity.odc;

public abstract class EstadioPai {
	private Long id;
	private String nome;
	private String apelido;
	
	public EstadioPai() {
		
	}
	
	public EstadioPai(String nome, String apelido) {
		this.nome = nome;
		this.apelido = apelido;
	}
	
	public EstadioPai(Long id, String nome, String apelido) {
		super();
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		EstadioPai other = (EstadioPai) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
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
		return true;
	}

	@Override
	public String toString() {
		return "EstadioPai [id=" + id + ", nome=" + nome + ", apelido=" + apelido + "]";
	}	
}
