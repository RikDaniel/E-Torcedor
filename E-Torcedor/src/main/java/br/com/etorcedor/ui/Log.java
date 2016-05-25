package br.com.etorcedor.ui;

public class Log {
	public static String traits(int tamanho) {
		StringBuilder builder = new StringBuilder();
		builder.append("\n\n+");
		for (int i = 0; i < tamanho; i++)
			builder.append("-");
		builder.append("+\n\n");

		return builder.toString();
	}
}
