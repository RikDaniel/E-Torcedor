package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.List;

import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Time;
import br.com.etorcedor.entity.Torcida;

public class TimeLong extends TimePai {

	private List<JogoShort> jogos;	
	private List<TorcidaShort> torcidaShorts;
	
	public TimeLong() {
		
	}
	
	public TimeLong(Long id, String nome, List<TorcidaShort> torcidaShorts, List<JogoShort> jogos) {
		super(id, nome);
		this.jogos =jogos;
		this.torcidaShorts = torcidaShorts;
	}

	public TimeLong(String nome, List<TorcidaShort> torcidaShorts, List<JogoShort> jogos) {
		super(nome);
		this.jogos =jogos;
		this.torcidaShorts = torcidaShorts;
	}

	public static TimeLong toTimeLong(Time time) {
		TimeLong timelong = new TimeLong();
		List<JogoShort> jogoShorts = new ArrayList<JogoShort>();
		List<TorcidaShort> torcidaShorts = new ArrayList<TorcidaShort>();

		for(Jogo j : time.getJogos()) {
			jogoShorts.add(JogoShort.toJogoShort(j));
		}
		for(Torcida torcida : time.getTorcidas()) {			
			torcidaShorts.add(TorcidaShort.toTorcidaShort(torcida));
		}
		
		timelong.setId(time.getId());
		timelong.setNome(time.getNome());
		timelong.setJogos(jogoShorts);
		timelong.setTorcidaShorts(torcidaShorts);
		return timelong;	
	}
	
	public List<JogoShort> getJogos() {
		return jogos;
	}

	public void setJogos(List<JogoShort> jogos) {
		this.jogos = jogos;
	}
	
	public List<TorcidaShort> getTorcidaShorts() {
		return torcidaShorts;
	}

	public void setTorcidaShorts(List<TorcidaShort> torcidaShorts) {
		this.torcidaShorts = torcidaShorts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((jogos == null) ? 0 : jogos.hashCode());
		result = prime * result + ((torcidaShorts == null) ? 0 : torcidaShorts.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeLong other = (TimeLong) obj;
		if (jogos == null) {
			if (other.jogos != null)
				return false;
		} else if (!jogos.equals(other.jogos))
			return false;
		if (torcidaShorts == null) {
			if (other.torcidaShorts != null)
				return false;
		} else if (!torcidaShorts.equals(other.torcidaShorts))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TimeLong [jogos=" + jogos + ", torcidaShorts=" + torcidaShorts + "]";
	}
}
