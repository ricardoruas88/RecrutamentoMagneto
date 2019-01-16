package br.com.ml.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.ml.entity.DNA;
import br.com.ml.entity.DNAStats;
import br.com.ml.model.Matriz;
import br.com.ml.model.MatrizDiagonalBaixoParaCima;
import br.com.ml.model.MatrizDiagonalCimaParaBaixo;
import br.com.ml.model.MatrizHorizontal;
import br.com.ml.model.MatrizVertical;
import br.com.ml.repository.IDNARepository;
import br.com.ml.request.DNARequest;

@Service
public class MutantService {

	@Autowired
	IDNARepository repository;

	@Async
	@SuppressWarnings("rawtypes")
	public CompletableFuture<ResponseEntity> isMutante(DNARequest dna) {

		String[] itens = dna.getDna();

		int qtdeVaricaoDNA = 0;

		Matriz[] matrizes = { new MatrizHorizontal(), new MatrizVertical(), new MatrizDiagonalCimaParaBaixo(),
				new MatrizDiagonalBaixoParaCima() };

		for (Matriz matriz : matrizes) {
			qtdeVaricaoDNA = matriz.verificarMutacao(matriz.criarMatrizDeDNA(itens), qtdeVaricaoDNA);

			if (qtdeVaricaoDNA > 1) {
				repository.save(new DNA(itens, true));
				return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.OK));
			}
		}
		repository.save(new DNA(itens, false));
		return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.FORBIDDEN));

	}

	@Async
	public CompletableFuture<ResponseEntity<DNAStats>> stats() {

		DNAStats response = repository.findMutanteCount();
		return CompletableFuture.completedFuture(new ResponseEntity<DNAStats>(response, HttpStatus.OK));

	}
}
