package fr.greta91.coursSpring.temp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.greta91.coursSpring.model.Message;

public class LocalStorage implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Message> messages = new ArrayList<Message>();
	
	public List<Message> getMessages() {
		return messages;
		
	}
	
	public void setMessages(List<Message> messages) {
		this.messages = messages;
		
	}
	
	public void add(Message m) {
		messages.add(m);
	}
	
	public void update(Message message) {
		messages = messages.stream().map(m -> {
			if(m.getId() == message.getId()) {
				return m;
			}
			else {
				return message;
			}
		}).collect(Collectors.toList());
	}
	
	
}
