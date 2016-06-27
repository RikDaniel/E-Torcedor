package br.com.etorcedor.entity.odc;

import java.util.ArrayList;
import java.util.List;

import br.com.etorcedor.entity.Estadio;

public class EstadioShort extends EstadioPai{
	
	public EstadioShort() {
		super();
	}	
	
	public EstadioShort(String nome, String apelido) {
		super(nome, apelido);
	}

	public EstadioShort(Long id, String nome, String apelido) {
		super(id, nome, apelido);
	
	}

	public static EstadioShort toEstadioShort(Estadio estadio) {
		EstadioShort estadioShort = new EstadioShort();
		if(estadio.getNome() != null) {
			estadioShort.setId(estadio.getId());
			estadioShort.setNome(estadio.getNome());
			estadioShort.setApelido(estadio.getApelido());
		}
		return estadioShort;
	}
	
	public static List<EstadioShort> toEstadioShort(List<Estadio> estadios) {
		List<EstadioShort> estadioShort = new ArrayList<EstadioShort>();
		if(estadios != null) {
			for(Estadio estadio : estadios) {
				estadioShort.add(EstadioShort.toEstadioShort(estadio));
			}
		}
		return estadioShort;
	}
	
	public static Estadio toEstadio(EstadioShort estadioShort) {
		Estadio estadio = new Estadio();
		if(estadioShort != null) {
			estadio.setId(estadioShort.getId());
			estadio.setNome(estadioShort.getNome());
			estadio.setApelido(estadioShort.getApelido());
		}
		return estadio;
	}
	
	public static List<Estadio> toEstadio(List<EstadioShort> estadiosShort) {
		List<Estadio> estadios = new ArrayList<Estadio>();
		if(estadiosShort != null) {
			for(EstadioShort estadioShort : estadiosShort){
				estadios.add(EstadioShort.toEstadio(estadioShort));
			}
		}
		return estadios;
	}
}
