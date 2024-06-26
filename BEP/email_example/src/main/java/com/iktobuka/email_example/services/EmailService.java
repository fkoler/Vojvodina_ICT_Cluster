package com.iktobuka.email_example.services;

import com.iktobuka.email_example.models.EmailObject;

public interface EmailService {

	void sendSimpleMessage (EmailObject object);
	
	void sendTemplateMessage (EmailObject object) throws
	Exception;
	
	void sendMessageWithAttachment (EmailObject object,
	String pathToAttachment) throws Exception;	
}
