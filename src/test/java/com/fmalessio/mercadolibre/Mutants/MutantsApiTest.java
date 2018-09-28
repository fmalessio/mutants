package com.fmalessio.mercadolibre.Mutants;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fmalessio.mercadolibre.Mutants.controller.MutantController;
import com.fmalessio.mercadolibre.Mutants.exception.DnaNotValidException;
import com.fmalessio.mercadolibre.Mutants.repository.DnaRepository;
import com.fmalessio.mercadolibre.Mutants.service.MutantService;

@RunWith(SpringRunner.class)
@WebMvcTest(MutantController.class)
public class MutantsApiTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private DnaRepository dnaRepository;

	@MockBean
	private MutantService mutantService;

	@Test
	public void isMutant() throws Exception, DnaNotValidException {
		String[] dna = { "FTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG" };
		JSONObject body = new JSONObject();
		body.put("dna", new JSONArray(dna));

		when(mutantService.isMutant(dna)).thenReturn(true);

		// Expected 200
		mvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON_UTF8).content(body.toString()))
				.andExpect(status().isOk());
	}

	@Test
	public void isHuman() throws Exception, DnaNotValidException {
		String[] dna = { "ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG" };
		JSONObject body = new JSONObject();
		body.put("dna", new JSONArray(dna));

		when(mutantService.isMutant(dna)).thenReturn(false);

		// Expected 403
		mvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON_UTF8).content(body.toString()))
				.andExpect(status().isForbidden());
	}

	@Test
	public void stats() throws Exception {
		// Expected 200
		mvc.perform(get("/stats").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk());
	}

}
