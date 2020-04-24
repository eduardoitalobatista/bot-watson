package br.com.teste.watson.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.teste.watson.model.Messages;

public interface MessagesRepository extends MongoRepository<Messages, String> {

	Messages findBy_id(ObjectId _id);

}