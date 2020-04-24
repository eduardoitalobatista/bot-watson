package br.com.teste.watson.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.watson.model.Bots;
import br.com.teste.watson.service.BotsService;

/**
 * Controlador da API de Bots.
 *
 * @author  Eduardo Batista
 * @see     BotsService
 * @see     Bots
 * @since   1.0.0
 * @version 1.0.0, 23 Abr 2020
 */

@RestController
@RequestMapping("/bots")
public class BotsController {

	@Autowired
	private BotsService botsService;

	/**
	 * Método GET.
	 *
	 * @param ObjectId id
	 * @return Bots
	 */
	@GetMapping("/{id}")
	public Bots read(@PathVariable String id) {
		Bots bots = botsService.read(id);
		return bots;
	}

	/**
	 * Método POST.
	 *
	 * @param Bots
	 * @return Bots
	 */
	@PostMapping
	public Bots create(@Valid @RequestBody Bots bots) {
		botsService.create(bots);
		return bots;
	}

}
