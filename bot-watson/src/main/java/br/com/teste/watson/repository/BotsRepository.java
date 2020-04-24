package br.com.teste.watson.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.teste.watson.model.Bots;

public interface BotsRepository extends MongoRepository<Bots, String> {

	Bots findBy_id(String _id);

}