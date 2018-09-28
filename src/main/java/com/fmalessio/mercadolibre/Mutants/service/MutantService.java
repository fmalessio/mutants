package com.fmalessio.mercadolibre.Mutants.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fmalessio.mercadolibre.Mutants.exception.DnaNotValidException;

public interface MutantService {

	boolean isMutant(String[] dna) throws DnaNotValidException;

	String getStats() throws JsonProcessingException;

}
