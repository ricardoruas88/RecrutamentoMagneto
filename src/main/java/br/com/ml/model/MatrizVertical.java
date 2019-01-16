package br.com.ml.model;

public class MatrizVertical extends Matriz {

	public char[][] criarMatrizDeDNA(String[] itens) {

		char[][] matriz = new char[itens.length][itens[0].length()];

		for (int colunas = 0; colunas < itens[0].length(); colunas++) {
			for (int linhas = 0; linhas < itens.length; linhas++) {
				matriz[linhas][colunas] = itens[colunas].charAt(linhas);
			}
		}
		return matriz;
	}
}
