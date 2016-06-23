package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.etorcedor.entity.Ingresso;

public class IngressoShort {

	private Long id;
	private Date data;
	private int numeroAcento;
	private float valorIngresso;
	private String setorNome;
	private List<TimeShort> times;

	public IngressoShort() {

	}

	public IngressoShort(Date data, int numeroAcento, float valorIngresso, String setorNome) {

		this.data = data;
		this.numeroAcento = numeroAcento;
		this.valorIngresso = valorIngresso;
		this.setorNome = setorNome;
	}

	public IngressoShort(Long id, Date data, int numeroAcento, float valorIngresso, String setorNome,
			List<TimeShort> times) {
		super();
		this.id = id;
		this.data = data;
		this.numeroAcento = numeroAcento;
		this.valorIngresso = valorIngresso;
		this.setorNome = setorNome;
		this.times = times;
	}

	public static IngressoShort toIngressoShort(Ingresso ingresso) {
		IngressoShort ingressoShort = new IngressoShort();
		if (ingresso != null) {
			ingressoShort.setId(ingresso.getId());
			ingressoShort.setData(ingresso.getData());
			ingressoShort.setNumeroAcento(ingresso.getNumeroAcento());
			ingressoShort.setSetorNome(ingresso.getSetor().getNome());
			ingressoShort.setTimes(TimeShort.toTimeShort(ingresso.getJogo().getTimes()));
			ingressoShort.setValorIngresso(ingresso.getValorIngresso());
		}
		return ingressoShort;
	}

	public static List<IngressoShort> toIngressoShort(List<Ingresso> ingressos) {
		List<IngressoShort> ingressoShort = new ArrayList<IngressoShort>();
		if (ingressos != null) {
			for (Ingresso ingresso : ingressos) {
				ingressoShort.add(IngressoShort.toIngressoShort(ingresso));
			}
		}
		return ingressoShort;
	}

	public static Ingresso toIngresso(IngressoShort ingressoShort) {
		Ingresso ingresso = new Ingresso();
		if (ingressoShort != null) {
			ingresso.setId(ingresso.getId());
			ingresso.setData(ingresso.getData());
			ingresso.setNumeroAcento(ingresso.getNumeroAcento());
			ingresso.setValorIngresso(ingresso.getValorIngresso());
		}
		return ingresso;
	}

	public static List<Ingresso> toIngresso(List<IngressoShort> ingressosShort) {
		List<Ingresso> ingressos = new ArrayList<Ingresso>();
		if (ingressosShort != null) {
			for (IngressoShort ingressoShort : ingressosShort) {
				ingressos.add(IngressoShort.toIngresso(ingressoShort));
			}
		}
		return ingressos;
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

	public int getNumeroAcento() {
		return numeroAcento;
	}

	public void setNumeroAcento(int numeroAcento) {
		this.numeroAcento = numeroAcento;
	}

	public float getValorIngresso() {
		return valorIngresso;
	}

	public void setValorIngresso(float valorIngresso) {
		this.valorIngresso = valorIngresso;
	}

	public String getSetorNome() {
		return setorNome;
	}

	public void setSetorNome(String setorNome) {
		this.setorNome = setorNome;
	}

	public List<TimeShort> getTimes() {
		return times;
	}

	public void setTimes(List<TimeShort> times) {
		this.times = times;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numeroAcento;
		result = prime * result + ((setorNome == null) ? 0 : setorNome.hashCode());
		result = prime * result + ((times == null) ? 0 : times.hashCode());
		result = prime * result + Float.floatToIntBits(valorIngresso);
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
		IngressoShort other = (IngressoShort) obj;
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
		if (numeroAcento != other.numeroAcento)
			return false;
		if (setorNome == null) {
			if (other.setorNome != null)
				return false;
		} else if (!setorNome.equals(other.setorNome))
			return false;
		if (times == null) {
			if (other.times != null)
				return false;
		} else if (!times.equals(other.times))
			return false;
		if (Float.floatToIntBits(valorIngresso) != Float.floatToIntBits(other.valorIngresso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IngressoShort [id=" + id + ", data=" + data + ", numeroAcento=" + numeroAcento + ", valorIngresso="
				+ valorIngresso + ", setorNome=" + setorNome + ", times=" + times + "]";
	}
}
