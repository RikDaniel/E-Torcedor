package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.List;

import br.com.etorcedor.entity.Estadio;
import br.com.etorcedor.entity.Setor;

public class SetorShort {

	private Long id;
	private String nome;
	private int numeroCadeira;
	private Long estadioShortId;

	public SetorShort() {

	}

	public SetorShort(Long id, String nome, int numeroCadeira, Long estadioShortId) {
		this.id = id;
		this.nome = nome;
		this.numeroCadeira = numeroCadeira;
		this.estadioShortId = estadioShortId;
	}

	public SetorShort(String nome, int numeroCadeira, Long estadioShortId) {
		this.nome = nome;
		this.numeroCadeira = numeroCadeira;
		this.estadioShortId = estadioShortId;
	}
	
	public SetorShort(String nome, int numeroCadeira) {
		this.nome = nome;
		this.numeroCadeira = numeroCadeira;
	}

	public static SetorShort toSetorShort(Setor setor) {
		SetorShort setorshort = new SetorShort();
		if (setor != null) {
			setorshort.setId(setor.getId());
			setorshort.setNome(setor.getNome());
			setorshort.setNumeroCadeira(setor.getNumeroCadeira());
			setorshort.setEstadioShortId(setor.getEstadio().getId());
		}
		return setorshort;
	}

	public static List<SetorShort> toSetorShort(List<Setor> setores) {
		List<SetorShort> setoresshort = new ArrayList<SetorShort>();
		if (setores != null) {
			for (Setor setor : setores) {
				setoresshort.add(SetorShort.toSetorShort(setor));
			}
		}
		return setoresshort;
	}

	public static Setor toSetor(SetorShort setorShort ) {
		Setor setor = new Setor();
		Estadio estadio = new Estadio();
		if(setorShort != null){
			estadio.setId(setorShort.getEstadioShortId());
			setor.setId(setorShort.getId());
			setor.setEstadio(estadio);
			setor.setNome(setorShort.getNome());
			setor.setNumeroCadeira(setorShort.getNumeroCadeira());
		}
		return setor;
	}
	public static List<Setor> toSetor(List<SetorShort> setoresShort) {
		List<Setor> setores = new ArrayList<Setor>();
		if(setoresShort != null){
			for(SetorShort setorShort : setoresShort) {
				setores.add(SetorShort.toSetor(setorShort));
			}
		}
		return setores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroCadeira() {
		return numeroCadeira;
	}

	public void setNumeroCadeira(int numeroCadeira) {
		this.numeroCadeira = numeroCadeira;
	}

	public Long getEstadioShortId() {
		return estadioShortId;
	}

	public void setEstadioShortId(Long estadioShortId) {
		this.estadioShortId = estadioShortId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadioShortId == null) ? 0 : estadioShortId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numeroCadeira;
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
		SetorShort other = (SetorShort) obj;
		if (estadioShortId == null) {
			if (other.estadioShortId != null)
				return false;
		} else if (!estadioShortId.equals(other.estadioShortId))
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
		if (numeroCadeira != other.numeroCadeira)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SetorShort [id=" + id + ", nome=" + nome + ", numeroCadeira=" + numeroCadeira + ", estadioShortId="
				+ estadioShortId + "]";
	}
}
