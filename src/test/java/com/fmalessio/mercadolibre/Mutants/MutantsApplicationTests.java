package com.fmalessio.mercadolibre.Mutants;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fmalessio.mercadolibre.Mutants.controller.MutantController;
import com.fmalessio.mercadolibre.Mutants.service.MutantService;

@RunWith(SpringRunner.class)
@WebMvcTest(MutantController.class)
public class MutantsApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private MutantService mutantService;

	@Test
	public void contextLoads() throws Exception {
		// Check status
		MvcResult result = mvc.perform(get("/testApi?name=Mutant").contentType(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk()).andReturn();
		// Check response
		assertEquals("Hello Mutant!", result.getResponse().getContentAsString());
	}

}
