package com.melomanya.springdemo.service;

import com.melomanya.springdemo.entity.Message;
import com.melomanya.springdemo.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService{

    private MessageRepository repository;

    public MessageService(MessageRepository messageRepository) {
        repository = messageRepository;
    }

    public Message saveMessage(Message message) {
        return repository.save(message);
    }

    public Message getMessageById(String messageId) {
        return repository.findById(messageId).orElse(null);
    }

    public List<Message> getAllMessage() {
        return repository.findAll();
    }

}
