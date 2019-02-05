package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/websoketTest")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) {
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
