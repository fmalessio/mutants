package com.fmalessio.mercadolibre.Mutants;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fmalessio.mercadolibre.Mutants.exception.DnaNotValidException;
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
	public void isMutantFrontDirectionTest() throws DnaNotValidException {
		System.out.println("Front direction:");

		String[] dna = { "CTGCGA", "CAGTAC", "TTATGT", "AGAAGG", "AAAATA", "CCCCTA" };
		printDnaInCosole(dna);

		assertEquals(true, mutantService.isMutant(dna));
	}

	@Test
	public void isMutantDownDirectionTest() throws DnaNotValidException {
		System.out.println("Down direction:");

		String[] dna = { "CTGCGA", "CAGGGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG" };
		printDnaInCosole(dna);

		assertEquals(true, mutantService.isMutant(dna));
	}

	@Test
	public void isMutantDiagonalDownDirectionTest() throws DnaNotValidException {
		System.out.println("Diaginal down direction:");

		String[] dna = { "ATCCGA", "CAGCTC", "TTATCT", "AGAAGC", "ACCCTA", "TCACTG" };
		printDnaInCosole(dna);

		assertEquals(true, mutantService.isMutant(dna));
	}

	@Test
	public void isMutantDiagonalUpDirectionTest() throws DnaNotValidException {
		System.out.println("Diaginal up direction:");

		String[] dna = { "TTGAAT", "CAATTC", "TAGTGT", "AGTGGG", "ATCCGA", "TCACTT" };
		printDnaInCosole(dna);

		assertEquals(true, mutantService.isMutant(dna));
	}

	@Test
	public void isMutantMixTest() throws DnaNotValidException {
		System.out.println("Diaginal up direction:");

		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		printDnaInCosole(dna);

		assertEquals(true, mutantService.isMutant(dna));
	}

	@Test
	public void isHumanTest() throws DnaNotValidException {
		System.out.println("Human:");

		String[] dna = { "ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG" };
		printDnaInCosole(dna);

		assertEquals(false, mutantService.isMutant(dna));
	}

	@Test
	public void stats() throws Exception {
		System.out.println("Stats...");

		when(dnaRepository.countByIsMutant(true)).thenReturn(new Long(40));
		when(dnaRepository.countByIsMutant(false)).thenReturn(new Long(100));

		assertEquals("{\"count_mutant_dna\":40,\"count_human_dna\":100,\"ratio\":0.4}", mutantService.getStats());
	}

	private void printDnaInCosole(String[] dna) {
		for (String chain : dna) {
			System.out.println(chain);
		}
		System.out.println("");
	}

}
