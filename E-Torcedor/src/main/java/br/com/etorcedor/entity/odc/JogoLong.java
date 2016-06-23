package br.com.etorcedor.entity.odc;

import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Jogo;
import br.com.etorcedor.entity.Time;

public class JogoLong extends JogoPai {

	private List<Time> times;
	private List<IngressoShort> ingressos;
	private int ingressos_quantidade;
	private int ingressos_vendidos;

	public JogoLong() {
		super();
	}

	public JogoLong(Date data, String estadioNome, String estadioApelido, List<Time> times, List<IngressoShort> ingressos,
			int ingressos_quantidade, int ingressos_vendidos) {
		this(data, estadioNome, estadioApelido);
		this.times = times;
		this.ingressos = ingressos;
		this.ingressos_quantidade = ingressos_quantidade;
		this.ingressos_vendidos = ingressos_vendidos;
	}

	public JogoLong(Long id, Date data, String estadioNome, String estadioApelido, List<Time> times,
			List<IngressoShort> ingressos, int ingressos_quantidade, int ingressos_vendidos) {
		this(id, data, estadioNome, estadioApelido);
		this.times = times;
		this.ingressos = ingressos;
		this.ingressos_quantidade = ingressos_quantidade;
		this.ingressos_vendidos = ingressos_vendidos;
	}

	public JogoLong toJogoLong(Jogo jogo) {
		JogoLong jogoLong = new JogoLong();
		if (jogo != null) {
			jogoLong.setId(jogo.getId());
			jogoLong.setData(jogo.getData());
			jogoLong.setEstadioApelido(jogo.getEstadio().getApelido());
			jogoLong.setEstadioNome(jogo.getEstadio().getNome());
			jogoLong.setIngressos(IngressoShort.toIngressoShort(jogo.getIngressos()));
			jogoLong.setIngressos_quantidade(jogo.getIngressos_quantidade());
			jogoLong.setIngressos_vendidos(jogo.getIngressos_vendidos());
			jogoLong.setTimes(jogo.getTimes());
		}
		return jogoLong;
	}
	
	public static Jogo toJogo(JogoLong jogoLong) {
		Jogo jogo = new Jogo();
		if (jogo != null) {
			jogo.setId(jogoLong.getId());
			jogo.setData(jogoLong.getData());
			jogo.setEstadio(EstadioShort.toEstadio((new EstadioShort(jogoLong.getEstadioNome(), jogoLong.getEstadioApelido()))));
			jogo.setIngressos_vendidos(jogoLong.getIngressos_vendidos());
			jogo.setIngressos_quantidade(jogoLong.getIngressos_quantidade());
			jogo.setTimes(jogoLong.getTimes());
			jogo.setIngressos(IngressoShort.toIngresso(jogoLong.getIngressos()));
		}
		return jogo;
	}

	public JogoLong(Date data, String estadioNome, String estadioApelido) {
		super(data, estadioNome, estadioApelido);
	}

	public JogoLong(Long id, Date data, String estadioNome, String estadioApelido) {
		super(id, data, estadioNome, estadioApelido);
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public List<IngressoShort> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<IngressoShort> ingressos) {
		this.ingressos = ingressos;
	}

	public int getIngressos_quantidade() {
		return ingressos_quantidade;
	}

	public void setIngressos_quantidade(int ingressos_quantidade) {
		this.ingressos_quantidade = ingressos_quantidade;
	}

	public int getIngressos_vendidos() {
		return ingressos_vendidos;
	}

	public void setIngressos_vendidos(int ingressos_vendidos) {
		this.ingressos_vendidos = ingressos_vendidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ingressos == null) ? 0 : ingressos.hashCode());
		result = prime * result + ingressos_quantidade;
		result = prime * result + ingressos_vendidos;
		result = prime * result + ((times == null) ? 0 : times.hashCode());
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
		JogoLong other = (JogoLong) obj;
		if (ingressos == null) {
			if (other.ingressos != null)
				return false;
		} else if (!ingressos.equals(other.ingressos))
			return false;
		if (ingressos_quantidade != other.ingressos_quantidade)
			return false;
		if (ingressos_vendidos != other.ingressos_vendidos)
			return false;
		if (times == null) {
			if (other.times != null)
				return false;
		} else if (!times.equals(other.times))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JogoLong [times=" + times + ", ingressos=" + ingressos + ", ingressos_quantidade="
				+ ingressos_quantidade + ", ingressos_vendidos=" + ingressos_vendidos + "]";
	}
}
