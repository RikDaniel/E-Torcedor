package br.com.etorcedor.ui;

public class Teste {
	public static String criadorTracinhos(int tamanho) {
		StringBuilder builder = new StringBuilder();
		builder.append("\n\n\n\n+");
		for(int i =0; i< tamanho ; i++)
			builder.append("-");
		builder.append("+\n\n\n\n");
		
		return builder.toString();
	}

}
