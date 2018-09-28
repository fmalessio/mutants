package com.fmalessio.mercadolibre.Mutants.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "count_mutant_dna", "count_human_dna", "ratio" })
public class StatsDTO {

	@JsonProperty("count_human_dna")
	private long humans;

	@JsonProperty("count_mutant_dna")
	private long mutants;

	@JsonProperty("ratio")
	private double ratio;

	@JsonCreator
	public StatsDTO(long humans, long mutants, double ratio) {
		this.humans = humans;
		this.mutants = mutants;
		this.ratio = ratio;
	}

	public long getHumans() {
		return humans;
	}

	public void setHumans(long humans) {
		this.humans = humans;
	}

	public long getMutants() {
		return mutants;
	}

	public void setMutants(long mutants) {
		this.mutants = mutants;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

}
