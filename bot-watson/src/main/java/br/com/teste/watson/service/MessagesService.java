package br.com.teste.watson.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.RequestTooLargeException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.SessionResponse;

import br.com.teste.watson.configuration.ConfigurationEnum;
import br.com.teste.watson.model.Messages;
import br.com.teste.watson.repository.MessagesRepository;

/**
 * Camada de Transação para Messages.
 *
 * @author  Eduardo Batista
 * @see     Messages
 * @since   1.0.0
 * @version 1.0.0, 23 Abr 2020
 */

@Service
public class MessagesService {
	
	private static final String TEXT = "text";

	@Autowired
	MessagesRepository messagesRepository;

	/**
	 * Método de leitura de um registro.
	 *
	 * @param ObjectId _id
	 * @return Messages
	 */	
	public Messages read(ObjectId _id) {
		Messages messages = messagesRepository.findBy_id(_id);
		return messages;
	}
	
	/**
	 * Método de criação de um registro.
	 *
	 * @param Messages
	 * @return Messages
	 */	
	public Messages create(Messages messages) {
		messages.set_id(ObjectId.get());
		Messages messagesSalvo = messagesRepository.save(messages);
		return messagesSalvo;
	}
	
	/**
	 * Método de execução do watson bot.
	 *
	 * @param Messages
	 * @return MessageResponse
	 */	
	public MessageResponse callWatson(Messages messages) {
		MessageResponse messageResponse = new MessageResponse();
		try {
			IamAuthenticator authenticator = new IamAuthenticator(ConfigurationEnum.API_KEY.value);
			Assistant assistant = new Assistant(ConfigurationEnum.VERSION.value, authenticator);
			assistant.setServiceUrl(ConfigurationEnum.URL.value);
			CreateSessionOptions options = new CreateSessionOptions.Builder(
					ConfigurationEnum.ASSISTANT_ID.value).build();
			SessionResponse response = assistant.createSession(options).execute().getResult();
			MessageInput input = new MessageInput.Builder()
			  .messageType(TEXT)
			  .text(messages.getText())
			  .build();
			MessageOptions messageOptions = new MessageOptions
					.Builder(ConfigurationEnum.ASSISTANT_ID.value, response.getSessionId())
			  .input(input)
			  .build();
			messageResponse = assistant.message(messageOptions).execute()
					.getResult();
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date());
			messages.setTimestamp(timeStamp);
			create(messages);
		} catch (NotFoundException e) {
			System.out.println("NotFoundException status code "
					+ e.getStatusCode() + ": " + e.getMessage());
		} catch (RequestTooLargeException e) {
			System.out.println("RequestTooLargeException status code "
					+ e.getStatusCode() + ": " + e.getMessage());
		} catch (ServiceResponseException e) {
			System.out.println("Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
		}
		return messageResponse;
	}

}
