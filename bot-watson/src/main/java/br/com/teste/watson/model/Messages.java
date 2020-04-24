package br.com.teste.watson.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Messages {

	@Id
	public ObjectId _id;	  
	public String conversationId;
	public String timestamp;
	public String from;
	public String to;
	public String text;

	// Constructors
	public Messages() {}

	public Messages (ObjectId _id, String conversationId, String timestamp, String from, String to,
			String text) {
		this._id = _id;
		this.conversationId = conversationId;
		this.timestamp = timestamp;
		this.from = from;
		this.to = to;
		this.text = text;
	}

	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id.toHexString();
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	/**
	 * @return the conversationId
	 */
	public String getConversationId() {
		return conversationId;
	}

	/**
	 * @param conversationId the conversationId to set
	 */
	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}

	/**
	 * @return the timestamp
	 */

	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
}
