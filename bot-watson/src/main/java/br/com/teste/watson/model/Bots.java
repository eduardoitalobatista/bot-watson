package br.com.teste.watson.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Bots {

	@Id
	public ObjectId _id;	  
	public String name;

	public Bots() {}

	public Bots (ObjectId _id, String name) {
		this._id = _id;
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
