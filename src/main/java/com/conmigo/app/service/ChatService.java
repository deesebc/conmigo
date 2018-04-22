package com.conmigo.app.service;

import org.springframework.data.domain.Page;

import com.conmigo.app.bbdd.jpa.Chat;
import com.conmigo.app.bbdd.jpa.ChatId;
import com.conmigo.app.dto.ChatDto;

public interface ChatService extends GenericBS<ChatDto, Chat, ChatId> {
    Page<ChatDto> findByUser(Long idUser);
}
