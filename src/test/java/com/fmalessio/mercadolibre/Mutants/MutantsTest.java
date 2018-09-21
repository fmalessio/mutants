package com.fmalessio.mercadolibre.Mutants;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fmalessio.mercadolibre.Mutants.controllers.MutantController;
import com.fmalessio.mercadolibre.Mutants.services.MutantService;
import com.fmalessio.mercadolibre.Mutants.services.MutantServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(MutantController.class)
public class MutantsTest {

	// String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"
	// };

	@Autowired
	private MockMvc mvc;

	@Autowired
	private MutantService mutantService;

	@TestConfiguration
	static class serviceImplTestContextConfiguration {
		@Bean
		public MutantService mutantService() {
			return new MutantServiceImpl();
		}
	}

	@Test
	public void isMutantFrontDireccionTest() {
		System.out.println("Front direction:");

		String[] dna = { "FTGCGA", "CAGTAC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		printDnaInCosole(dna);

		assertEquals(mutantService.isMutant(dna), true);
	}

	@Test
	public void isMutantDownDireccionTest() {
		System.out.println("Down direction:");

		String[] dna = { "FTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG" };
		printDnaInCosole(dna);

		assertEquals(mutantService.isMutant(dna), true);
	}

	private void printDnaInCosole(String[] dna) {
		for (String chain : dna) {
			System.out.println(chain);
		}
		System.out.println("");
	}

}
