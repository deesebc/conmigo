package com.conmigo.app.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.conmigo.app.vo.ChatMessageVo;

@Component
public class ChatChangesListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(ChatChangesListener.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(final SessionConnectedEvent event) {
        LOGGER.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            LOGGER.info("User Disconnected : " + username);

            ChatMessageVo chatMessage = new ChatMessageVo();
            // chatMessage.setType(ChatMessage.MessageType.LEAVE);
            // chatMessage.setSender(username);

            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}
