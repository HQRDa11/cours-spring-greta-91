package fr.greta91.coursSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
	
	@GetMapping("/messages")
	public String list(Model model) {
		List<String> list = new ArrayList<String>();
		list.add("Message 1");
		list.add("Message 2");
		list.add("Message 3");
		model.addAttribute("messages", list );
		//on renvoie le nom de la vue (fichier jsp)
		return "messages/list";
	}
}
