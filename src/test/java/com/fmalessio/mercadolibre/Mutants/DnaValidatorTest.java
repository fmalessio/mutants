package com.fmalessio.mercadolibre.Mutants;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.fmalessio.mercadolibre.Mutans.validator.DnaValidator;

@RunWith(SpringRunner.class)
public class DnaValidatorTest {

	@Test
	public void invalidChainDna() throws Exception {
		System.out.println("invalidDna:");

		String[] dna = { "FTGCGA", "CAGTAC", "XXXXX", "AGAAGG", "AAAATA", "CCCCTA" };
		printDnaInCosole(dna);

		assertEquals(false, DnaValidator.isValid(dna));
	}

	@Test
	public void invalidLengthDna() throws Exception {
		System.out.println("invalidDna:");

		String[] dna = { "FTGCGA", "CAGTAC", "CFCCTA", "A", "AAAATA", "CCCCTA" };
		printDnaInCosole(dna);

		assertEquals(false, DnaValidator.isValid(dna));
	}

	@Test
	public void validSmallLengthDna() throws Exception {
		System.out.println("invalidDna:");

		String[] dna = { "AT", "GC" };
		printDnaInCosole(dna);

		assertEquals(true, DnaValidator.isValid(dna));
	}

	@Test
	public void validDna() throws Exception {
		System.out.println("invalidDna:");

		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		printDnaInCosole(dna);

		assertEquals(true, DnaValidator.isValid(dna));
	}

	private void printDnaInCosole(String[] dna) {
		for (String chain : dna) {
			System.out.println(chain);
		}
		System.out.println("");
	}

}
