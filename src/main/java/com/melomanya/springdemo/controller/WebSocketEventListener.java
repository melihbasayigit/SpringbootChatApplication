package com.melomanya.springdemo.controller;

import com.melomanya.springdemo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;


@Component
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageSendingOperations;

    public WebSocketEventListener(SimpMessageSendingOperations messageSendingOperations) {
        this.messageSendingOperations = messageSendingOperations;
    }

    @EventListener
    public void handleWebSocketConnectionListener(SessionConnectedEvent event) {
        System.out.println("Recieved a new web socket connection");
    }

    @EventListener
    public void handleWebSocketSubscribeListener(SessionSubscribeEvent event) {
        System.out.println("New player joined the room" + event.getMessage());
    }

    /*@EventListener
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


    }*/


}
