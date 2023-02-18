package com.melomanya.springdemo.controller;

import com.melomanya.springdemo.entity.Message;
import com.melomanya.springdemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @MessageMapping("/chat/send-message")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        service.saveMessage(message);
        Message messageFromDB = service.getMessageById(message.getMessageId());
        return messageFromDB;
    }

    @MessageMapping("/chat/get-all")
    @SendTo("/topic/public")

    public List<Message> getAllMessages() {
        return service.getAllMessage();
    }




}
