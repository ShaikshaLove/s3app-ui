package io.s3soft.proxyapp.model;

import java.util.UUID;

public class Greeting {
	
	private String id;
	private String message;
	@Override
	public String toString() {
		return "Greeting [id=" + id + ", message=" + message + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Greeting() {
		super();
	}
	public Greeting(String message) {
		super();
		id=UUID.randomUUID().toString();
		this.message = message;
	}
	
	

}
