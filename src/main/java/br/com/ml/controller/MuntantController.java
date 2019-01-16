package br.com.ml.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ml.entity.DNAStats;
import br.com.ml.request.DNARequest;
import br.com.ml.service.MutantService;

@RestController
public class MuntantController {

	@Autowired
	private MutantService service;

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "mutant", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody CompletableFuture<ResponseEntity> isMutant(@RequestBody DNARequest dna) {
		return service.isMutante(dna);
	}

	@RequestMapping(value = "stats", method = RequestMethod.GET)
	public @ResponseBody CompletableFuture<ResponseEntity<DNAStats>> stats() {
		return service.stats();
	}
}
