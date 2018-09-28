package com.fmalessio.mercadolibre.Mutans.validator;

public class DnaValidator {

	private static final String VALID_LETTERS_REGEX = "[ATCG]+?";

	public static boolean isValid(String[] dna) {
		// Has content
		if (dna == null || dna.length == 0 || dna[0].length() < 2) {
			return false;
		}

		// NxN is valid, then 2x2 is valid
		int dnaChainsLengthNeeded = dna.length;

		for (String chain : dna) {
			if (chain.length() != dnaChainsLengthNeeded) {
				return false;
			}
		}

		// Correct letters
		for (String chain : dna) {
			if (!chain.matches(VALID_LETTERS_REGEX)) {
				return false;
			}
		}

		return true;
	}

}
