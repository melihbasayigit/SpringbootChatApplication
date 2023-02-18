package com.melomanya.springdemo.controller;

import com.melomanya.springdemo.entity.Message;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.sql.SQLOutput;

//@Component
public class WebSocketEventListener {

    /*@Autowired
    private SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    public void handleWebSocketConnectionListener(SessionConnectedEvent event) {
        System.out.println("Recieved a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");

        if(username != null) {
            System.out.println("User disconnected " + username);

            Message message = new Message();
            message.setSender("System");
            message.setContext(username + "disconnected.");

            messageSendingOperations.convertAndSend("/topic", message);
        }


    }
*/


}
