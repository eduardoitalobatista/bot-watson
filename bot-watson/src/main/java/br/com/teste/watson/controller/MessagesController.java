package br.com.teste.watson.controller;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.assistant.v2.model.MessageResponse;

import br.com.teste.watson.model.Messages;
import br.com.teste.watson.service.MessagesService;

/**
 * Controlador da API de Messages.
 *
 * @author  Eduardo Batista
 * @see     MessagesService
 * @see     Messages
 * @since   1.0.0
 * @version 1.0.0, 23 Abr 2020
 */

@RestController
@RequestMapping("/messages")
public class MessagesController {

	@Autowired
	private MessagesService messagesService;

	/**
	 * Método GET.
	 *
	 * @param ObjectId id
	 * @return Messages
	 */
	@GetMapping("/{id}")
	public Messages read(@PathVariable ObjectId id) {
		Messages messages = messagesService.read(id);
		return messages;
	}

	/**
	 * Método POST.
	 *
	 * @param Messages
	 * @return Messages
	 */
	@PostMapping
	public Messages create(@Valid @RequestBody Messages messages) {
		messagesService.create(messages);
		return messages;
	}
	
	/**
	 * Método POST, para utilizar o chat.
	 *
	 * @param Messages
	 * @return String response
	 */
	@PostMapping("/chat")
	public String callWatson(@RequestBody Messages messages) {
		MessageResponse messageResponse = messagesService.callWatson(messages);
		return messageResponse.toString();
	}


}
