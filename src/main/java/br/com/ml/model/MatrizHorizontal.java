package br.com.ml.model;

public class MatrizHorizontal extends Matriz {

	public char[][] criarMatrizDeDNA(String[] itens) {

		char[][] matriz = new char[itens[0].length()][itens.length];;

		for (int linhas = 0; linhas < itens.length; linhas++) {
			for (int colunas = 0; colunas < itens[0].length(); colunas++) {
				matriz[linhas][colunas] = itens[linhas].charAt(colunas);
			}
		}
		
		return matriz;
	}
}
