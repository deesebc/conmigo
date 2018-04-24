package com.conmigo.app.service;

import java.util.List;

import com.conmigo.app.bbdd.jpa.Chatroom;
import com.conmigo.app.dto.ChatroomDto;

public interface ChatroomService extends GenericBS<ChatroomDto, Chatroom, Long> {
    List<ChatroomDto> findByUser(final Long idUser);
}
