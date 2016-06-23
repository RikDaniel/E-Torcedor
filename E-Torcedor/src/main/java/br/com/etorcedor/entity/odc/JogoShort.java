package br.com.etorcedor.entity.odc;

import java.util.Date;

import br.com.etorcedor.entity.Jogo;

public class JogoShort extends JogoPai{

	public JogoShort() {
		super();
	}
	
	public JogoShort(Date data, String estadioNome, String estadioApelido) {
		super(data, estadioNome, estadioApelido);
	}

	public JogoShort(Long id, Date data, String estadioNome, String estadioApelido) {
		super(id, data, estadioNome, estadioApelido);
	}
	
	public static JogoShort toJogoShort(Jogo jogo) {
		JogoShort jogoShort = new JogoShort();
		if(jogo != null) {
			jogoShort.setEstadioApelido(jogo.getEstadio().getApelido());
			jogoShort.setEstadioNome(jogo.getEstadio().getNome());
			jogoShort.setData(jogo.getData());
			jogoShort.setId(jogo.getId());
		}
		return jogoShort;
	}
}
