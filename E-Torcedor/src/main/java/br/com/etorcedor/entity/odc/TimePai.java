package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.List;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;

public abstract class TimePai {

	protected Long id;
	protected String nome;

	public TimePai() {

	}

	public TimePai(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public TimePai(String nome) {
		this.nome = nome;
	}

	public static Time toTime(TimePai timepai) {
		Time time = new Time();
		List<Torcida> list = new ArrayList<Torcida>();

		if (timepai != null) {
			time.setId(timepai.getId());
			time.setNome(timepai.getNome());
			time.setTorcidas(list);
		}
		return time;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		TimePai other = (TimePai) obj;
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
		return "TimePai [id=" + id + ", nome=" + nome + "]";
	}

}
