package com.fmalessio.mercadolibre.Mutants;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fmalessio.mercadolibre.Mutants.controller.MutantController;

@RunWith(SpringRunner.class)
@WebMvcTest(MutantController.class)
public class MutantsApiTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void isMutant() {
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

		// TODO: call API

		fail("Not yet implemented");
	}

}
