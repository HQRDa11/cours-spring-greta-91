package fr.greta91.coursSpring.model;

public class Message {
	private int id;
	private String message;

	
	public Message() {
		this.message = "";
	}
	
	public Message(String message) {
		this.message = message;
	}
	
	public Message(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean validate() {
		if(this.message.trim().isEmpty()) {
			return false;
		}
		return true;
	}
}
