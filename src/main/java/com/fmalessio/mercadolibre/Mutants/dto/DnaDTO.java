package com.fmalessio.mercadolibre.Mutants.dto;

import com.fmalessio.mercadolibre.Mutants.entity.Dna;

public class DnaDTO {

	private String DNA_CONCATENATION_SYMBOL = "-";

	private String[] dna;
	private boolean isMutant;

	public DnaDTO(String[] dna, boolean isMutant) {
		this.dna = dna;
		this.isMutant = isMutant;
	}

	public Dna convertToDnaEntity() {
		String dnaColumn = String.join(DNA_CONCATENATION_SYMBOL, dna);
		return new Dna(dnaColumn, isMutant);
	}

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	public boolean isMutant() {
		return isMutant;
	}

	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}

}
