package com.iktobuka.email_example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.email_example.models.EmailObject;
import com.iktobuka.email_example.services.EmailService;

@RestController
@RequestMapping(path = "/")
public class EmailController {

	@Autowired
	private EmailService emailService;

	private static String PATH_TO_ATTACHMENT = "E://rammstein.jpg";

	@PostMapping("/simpleEmail")
	public String sendSimpleMessage(@RequestBody EmailObject object) {
		if (
				object == null ||
				object.getTo() == null || 
				object.getText() == null || 
				object.getText().equals("")
			) {
			return null;
		}

		emailService.sendSimpleMessage(object);

		return "Your mail has been sent!";
	}

	@PostMapping("/templateEmail")
	public String sendTemplateMessage(
			@RequestBody EmailObject object
			) throws Exception {
		if (
				object == null ||
				object.getTo() == null ||
				object.getText() == null
			) {
			return null;
		}

		emailService.sendTemplateMessage(object);

		return "Your mail has been sent!";
	}

	@PostMapping("/emailWithAttachment")
	public String sendMessageWithAttachment(
			@RequestBody EmailObject object
			) throws Exception {
		if (
				object == null ||
				object.getTo() == null ||
				object.getText() == null
				) {
			return null;
		}
		
		emailService.sendMessageWithAttachment(object, PATH_TO_ATTACHMENT);
		
		return "Your mail has been sent!";
	}
}
