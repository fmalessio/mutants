package com.fmalessio.mercadolibre.Mutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fmalessio.mercadolibre.Mutants.entity.Mutant;
import com.fmalessio.mercadolibre.Mutants.exception.NotMutantException;
import com.fmalessio.mercadolibre.Mutants.service.MutantService;

@Controller
public class MutantController {

	@Autowired
	private MutantService mutantService;

	@GetMapping("/testApi")
	public @ResponseBody String testApi(@RequestParam(name = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@PostMapping("/mutant")
	@ResponseStatus(value = HttpStatus.OK)
	public void isMutant(@RequestBody Mutant mutant) throws NotMutantException {
		if (!mutantService.isMutant(mutant.getDna())) {
			throw new NotMutantException();
		}
	}

	// Convert a predefined exception to an HTTP Status code
	@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Is not a mutant") // 403
	@ExceptionHandler(NotMutantException.class)
	public void notMutantHandler() {
	}

}
