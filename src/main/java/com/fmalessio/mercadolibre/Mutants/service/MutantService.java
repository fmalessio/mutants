package com.fmalessio.mercadolibre.Mutants.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface MutantService {

	boolean isMutant(String[] dna);

	String getStats() throws JsonProcessingException;

}
