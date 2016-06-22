package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.List;

import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;

public class TimePai {
	
	protected Long id;
	protected String nome;
	protected List<TorcidaShort> torcidas;
	
	public TimePai() {
		
	}
	
	public TimePai(Long id, String nome, List<TorcidaShort> torcidas) {
		this.id = id;
		this.nome = nome;
		this.torcidas = torcidas;
	}
	
	public TimePai(String nome, List<TorcidaShort> torcidas) {
		this.nome = nome;
		this.torcidas = torcidas;
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
	public List<TorcidaShort> getTorcidas() {
		return torcidas;
	}
	public void setTorcidas(List<TorcidaShort> torcidas) {
		this.torcidas = torcidas;
	}
	
	public static Time toTime(TimePai timeshort) {
		Time time = new Time();	
		List<Torcida> list = new ArrayList<Torcida>();
		
		time.setId(timeshort.getId());
		time.setNome(timeshort.getNome());
		for(TorcidaShort torcidas:  timeshort.getTorcidas()) {
			list.add(TorcidaShort.toTorcida(torcidas));
		}
		time.setTorcidas(list);
		return time;	
	}
	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((torcidas == null) ? 0 : torcidas.hashCode());
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
		if (torcidas == null) {
			if (other.torcidas != null)
				return false;
		} else if (!torcidas.equals(other.torcidas))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TimePai [id=" + id + ", nome=" + nome + ", torcidas=" + torcidas + "]";
	}
	
	
}
