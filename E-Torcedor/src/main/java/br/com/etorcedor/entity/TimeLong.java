package br.com.etorcedor.entity;

import java.util.List;

public class TimeLong {

	private Long id;
	private String nome;
	private List<TorcidasShort> torcidas;
	private List<JogosShort> jogos;	
	
	public TimeLong() {
		super();
	}

	public TimeLong(Long id, String nome, List<TorcidasShort> torcidas, List<JogosShort> jogos) {
		super();
		this.id = id;
		this.nome = nome;
		this.torcidas = torcidas;
		this.jogos = jogos;
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

	public List<TorcidasShort> getTorcidas() {
		return torcidas;
	}

	public void setTorcidas(List<TorcidasShort> torcidas) {
		this.torcidas = torcidas;
	}

	public List<JogosShort> getJogos() {
		return jogos;
	}

	public void setJogos(List<JogosShort> jogos) {
		this.jogos = jogos;
	}

	@Override
	public String toString() {
		return "TimeLong [id=" + id + ", nome=" + nome + ", torcidas=" + torcidas + ", jogos=" + jogos + "]";
	}
	
}
