package com.emailhandling.emailsending.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailSenderservice {
    @Autowired
    private JavaMailSender mailSender;
//    public void sendSimpleEmail(String toEmail,String body,String subject)
//    {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setFrom("abdullahit18040@gamil.com");
//        mailMessage.setTo(toEmail);
//        mailMessage.setText(body);
//        mailMessage.setSubject(subject);
//        mailSender.send(mailMessage);
//        System.out.println("mail sent successfully......");
//    }


    public void sendEmailWithAttach(String toEmail,String body,String subject,String atachment) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("abdullahit18040@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);
        FileSystemResource filesystem = new FileSystemResource(new File(atachment));
        mimeMessageHelper.addAttachment(filesystem.getFilename(),filesystem);
        mailSender.send(mimeMessage);

        System.out.println("mial send  with attachment succfully .....");
    }
}
