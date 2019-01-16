package br.com.ml.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MatrizDiagonalBaixoParaCima extends Matriz {

	@Override
	public char[][] criarMatrizDeDNA(String[] itens) {

		List<String> list = Arrays.asList(itens);
	    Collections.reverse(list);
	    list.toArray(itens);
	    
		String[] listaItens = new String[(itens.length - 3) * (itens[0].length() - 3)];
		int count = 0;
		for (int lp = 0; lp < itens.length - 3; lp++) {
			for (int l = 0; l + lp < itens[0].length(); l++) {

				StringBuilder auxBuilder = new StringBuilder();

				for (int c = 0; c + l < itens[0].length() && auxBuilder.chars().count() < 4; c++)
					auxBuilder.append(itens[c + lp].charAt(c + l));

				if (auxBuilder.length() == 4) {
					listaItens[count] = auxBuilder.toString();
					count++;
				}

			}
		}
		
		char[][] matriz = new char[listaItens.length][listaItens[0].length()];

		for (int linhas = 0; linhas < listaItens.length; linhas++) {
			for (int colunas = 0; colunas < listaItens[0].length(); colunas++) {
				matriz[linhas][colunas] = listaItens[linhas].charAt(colunas);
			}
		}
		
		return matriz;
	}

}
