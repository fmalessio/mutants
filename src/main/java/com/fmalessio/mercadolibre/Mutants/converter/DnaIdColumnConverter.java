package com.fmalessio.mercadolibre.Mutants.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DnaIdColumnConverter implements AttributeConverter<String[], String> {

	private String DNA_CONCATENATION_SYMBOL = "-";

	@Override
	public String convertToDatabaseColumn(String[] dna) {
		return String.join(DNA_CONCATENATION_SYMBOL, dna);
	}

	@Override
	public String[] convertToEntityAttribute(String id) {
		return id.split(DNA_CONCATENATION_SYMBOL);
	}

}
