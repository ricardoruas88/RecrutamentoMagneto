package br.com.ml.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class DNAStats {

	@Getter
	@Setter
	@JsonIgnore
	private long total;

	@Getter
	@Setter
	@JsonProperty(value = "count_mutant_dna")
	private long countMutantDNA;

	@Getter
	@Setter
	@JsonProperty(value = "count_human_dna")
	private long countHumanDNA;

	@Getter
	@Setter
	@JsonProperty(value = "ratio")
	private String ratio;

	public DNAStats(long total, long countMutanteDNA) {

		this.countMutantDNA = countMutanteDNA;
		this.countHumanDNA = total - countMutanteDNA;
		
		this.ratio = String.format("%.2f",total > 0 ? ((double) countMutanteDNA / total) : 0);

	}

}
