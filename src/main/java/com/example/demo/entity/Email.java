package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;

public class Email implements Serializable {
    private String sentTo;
    private String subject;
    private String content;

    public Email(String sentTo, String subject, String content) {
        this.sentTo = sentTo;
        this.subject = subject;
        this.content = content;

    }

    public void excute(JavaMailSender emailSender) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent(this.content, "text/html");
        helper.setTo(this.sentTo);
        helper.setSubject(this.subject);
        emailSender.send(message);
    }
}
