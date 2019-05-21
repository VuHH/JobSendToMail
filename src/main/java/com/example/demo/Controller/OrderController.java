package com.example.demo.Controller;

import com.example.demo.core.OrderMessagingService;
import com.example.demo.entity.Email;
import com.example.demo.service.Receiver;
import com.example.demo.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {
    public static final String BASE_LINK = "/data/jms/";

    @Autowired
    OrderMessagingService orderMessagingService;

    @Autowired
    Sender sender;
    @Autowired
    Receiver receiver;
    @Autowired
    JavaMailSender javaMailSender;


//    @GetMapping(BASE_LINK + "sendMessage")
//    public String sendMessage() {
//        try {
//            //Order order = new Order("1", "order1");
//            //orderMessagingService.sendOrder(order);
//            String uniqueID = UUID.randomUUID().toString();
//            sender.send(uniqueID);
//            return "success";
//        } catch (Exception ex) {
//            return ex.getMessage();
//        }
//    }

    @GetMapping(BASE_LINK + "receiveMessage")
    public String getMessage() {
        //String message = receiver.receive("");
        return "";
    }

    @GetMapping(BASE_LINK + "sendMail")
    public String sendMail() {
        try {
            //Order order = new Order("1", "order1");
            //orderMessagingService.sendOrder(order);
            String uniqueID = UUID.randomUUID().toString();
            String htmlMsg = "<h3>Im testing send a HTML email</h3>"
                    +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
            Email email = new Email("hohoanvu1993@gmail.com", "Test send HTML email", htmlMsg);
            sender.send(email);
            return "success";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
