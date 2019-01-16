package br.com.ml.response;

import lombok.Getter;
import lombok.Setter;

public class DNAResponse {

	@Getter
	@Setter
	long count_mutant_dna;
	
	@Getter
	@Setter
	long count_human_dna;
	
	@Getter
	@Setter
	float ratio;
}
