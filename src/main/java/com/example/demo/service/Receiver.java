package com.example.demo.service;

import com.example.demo.entity.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class Receiver {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }
    @Autowired
    JavaMailSender emailSender;

    @JmsListener(destination = "helloworld.q")
    public void receive(Email email) {
        try {
            LOGGER.info("received message='{}'", email);
            email.excute(emailSender);
            latch.countDown();
        } catch(Exception ex) {
            LOGGER.error("error: ", ex.getMessage());
        }
    }
}
