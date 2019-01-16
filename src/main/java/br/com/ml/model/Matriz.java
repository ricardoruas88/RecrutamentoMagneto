package br.com.ml.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Matriz {

	public abstract char[][] criarMatrizDeDNA(String[] itens);

	private int criarRegistrosParaAnalise(int quantidadeRegistros, String valorLinha, int qtdeVaricaoDNA) {

		List<char[]> resultadoMutacao = new ArrayList<char[]>();
		int index = 0;

		while (quantidadeRegistros >= index + 4) {

			resultadoMutacao.add(valorLinha.substring(index, index + 4).toCharArray());

			StringBuilder sb = new StringBuilder();

			for (Character ch : resultadoMutacao.get(index)) {
				sb.append(ch);
			}

			String string = sb.toString();

			if (Arrays.asList("aaaa", "cccc", "tttt", "gggg").contains(string))
				qtdeVaricaoDNA += 1;

			if (qtdeVaricaoDNA > 1) {// encontrou 2 variacoes no dna
				return qtdeVaricaoDNA;
			}

			index++;
		}
		return qtdeVaricaoDNA;
	}

	public int verificarMutacao(char[][] matriz, int qtdeVaricaoDNA) {

		for (char[] element : matriz) {
			String valorLinha = String.valueOf(element).toLowerCase();
			qtdeVaricaoDNA = criarRegistrosParaAnalise(matriz[0].length, valorLinha, qtdeVaricaoDNA);

			if (qtdeVaricaoDNA > 1)
				return qtdeVaricaoDNA;

		}

		return qtdeVaricaoDNA;
	}

}
