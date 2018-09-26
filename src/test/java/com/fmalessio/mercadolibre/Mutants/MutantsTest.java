package com.fmalessio.mercadolibre.Mutants;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fmalessio.mercadolibre.Mutants.repository.DnaRepository;
import com.fmalessio.mercadolibre.Mutants.service.MutantService;
import com.fmalessio.mercadolibre.Mutants.service.MutantServiceImpl;

@RunWith(SpringRunner.class)
public class MutantsTest {

	@Autowired
	private MutantService mutantService;
	
	@MockBean
	private DnaRepository dnaRepository;

	@TestConfiguration
	static class serviceImplTestContextConfiguration {
		@Bean
		public MutantService mutantService() {
			return new MutantServiceImpl();
		}
	}

	@Test
	public void isMutantFrontDirectionTest() {
		System.out.println("Front direction:");

		String[] dna = { "FTGCGA", "CAGTAC", "TTATGT", "AGAAGG", "AAAATA", "CCCCTA" };
		printDnaInCosole(dna);

		assertEquals(true, mutantService.isMutant(dna));
	}

	@Test
	public void isMutantDownDirectionTest() {
		System.out.println("Down direction:");

		String[] dna = { "FTGCGA", "CAGGGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG" };
		printDnaInCosole(dna);

		assertEquals(true, mutantService.isMutant(dna));
	}

	@Test
	public void isMutantDiagonalDownDirectionTest() {
		System.out.println("Diaginal down direction:");

		String[] dna = { "ATCCGA", "CAGCTC", "TTATCT", "AGAAGC", "ACCCTA", "TCACTG" };
		printDnaInCosole(dna);

		assertEquals(true, mutantService.isMutant(dna));
	}

	@Test
	public void isMutantDiagonalUpDirectionTest() {
		System.out.println("Diaginal up direction:");

		String[] dna = { "TTGAAT", "CAATTC", "TAGTGT", "AGTGGG", "ATCCGA", "TCACTT" };
		printDnaInCosole(dna);

		assertEquals(true, mutantService.isMutant(dna));
	}

	@Test
	public void isMutantMixTest() {
		System.out.println("Diaginal up direction:");

		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		printDnaInCosole(dna);

		assertEquals(true, mutantService.isMutant(dna));
	}

	@Test
	public void isHumanTest() {
		System.out.println("Human:");

		String[] dna = { "ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG" };
		printDnaInCosole(dna);

		assertEquals(false, mutantService.isMutant(dna));
	}

	private void printDnaInCosole(String[] dna) {
		for (String chain : dna) {
			System.out.println(chain);
		}
		System.out.println("");
	}

}
