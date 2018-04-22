package com.conmigo.app.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.conmigo.app.bbdd.jpa.ChatId;
import com.conmigo.app.dto.ChatDto;
import com.conmigo.app.service.ChatService;
import com.conmigo.app.vo.ChatMessageVo;

@Controller
public class ChatController {

    @Autowired
    ChatService cService;

    @MessageMapping("/chat.{chatroomId}.sendMessage")
    @SendTo("/topic/room/{chatroomId}")
    public ChatMessageVo sendMessage(@DestinationVariable final String chatroomId, @Payload final ChatMessageVo chatMessage) {
        ChatDto dto = new ChatDto();
        ChatId id = new ChatId();
        id.setDate(LocalDateTime.now());
        id.setEvent(chatMessage.getEventId());
        id.setReceiver(chatMessage.getReceiverId());
        id.setSender(chatMessage.getSenderId());
        dto.setId(id);
        dto.setText(chatMessage.getMessage());
        // ChatDto retorno = cService.save(dto);
        chatMessage.setReceiverUsername("receiver");
        chatMessage.setSenderUsername("sender");
        // guardar mensaje
        return chatMessage;
    }

}
