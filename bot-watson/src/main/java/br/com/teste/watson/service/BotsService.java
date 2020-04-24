package br.com.teste.watson.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.watson.model.Bots;
import br.com.teste.watson.repository.BotsRepository;

/**
 * Camada de Transação para Bots.
 *
 * @author  Eduardo Batista
 * @see     Bots
 * @since   1.0.0
 * @version 1.0.0, 23 Abr 2020
 */

@Service
public class BotsService {

	@Autowired
	BotsRepository botsRepository;

	/**
	 * Método de leitura de um registro.
	 *
	 * @param ObjectId _id
	 * @return Bots
	 */	
	public Bots read(String _id) {
		Bots bots = botsRepository.findBy_id(_id);
		return bots;
	}

	/**
	 * Método de criação de um registro.
	 *
	 * @param Bots
	 * @return Bots
	 */	
	public Bots create(Bots bots) {
		bots.set_id(ObjectId.get());
		Bots botsSalvo = botsRepository.save(bots);
		return botsSalvo;
	}

}
