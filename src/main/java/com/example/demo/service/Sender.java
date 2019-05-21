package com.example.demo.service;

import com.example.demo.entity.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Sender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Email email) {
        LOGGER.info("sending message='{}'", email);
        jmsTemplate.convertAndSend("helloworld.q", email);
    }
}
