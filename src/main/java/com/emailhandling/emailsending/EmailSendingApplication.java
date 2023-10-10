package com.emailhandling.emailsending;

import com.emailhandling.emailsending.service.EmailSenderservice;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailSendingApplication {
    @Autowired
    EmailSenderservice service;

    public static void main(String[] args) {
        SpringApplication.run(EmailSendingApplication.class, args);
    }
@EventListener(ApplicationReadyEvent.class)
    public  void triggerMail() throws MessagingException {
service.sendEmailWithAttach("ma18034@mbstu.ac.bd","i love java spring boot","sprigboot","home/sadi/Pictures");
    }


}
