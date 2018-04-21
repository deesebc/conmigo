package com.conmigo.app.service.impl;

import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.ChatDao;
import com.conmigo.app.bbdd.dao.GenericDao;
import com.conmigo.app.bbdd.jpa.Chat;
import com.conmigo.app.bbdd.jpa.ChatId;
import com.conmigo.app.dto.ChatDto;
import com.conmigo.app.function.ChatFromDto;
import com.conmigo.app.function.ChatToDto;
import com.conmigo.app.service.ChatService;

@Service
@Transactional
public class ChatServiceImpl extends GenericBSImpl<ChatDto, Chat, ChatId> implements ChatService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ChatDao dao;

    @Override
    protected GenericDao<Chat, ChatId> getDao() {
        return dao;
    }

    @Override
    protected Function<Chat, ChatDto> getConverterToDTO() {
        return ChatToDto.INSTANCE;
    }

    @Override
    protected Function<ChatDto, Chat> getConverterToEntity() {
        return ChatFromDto.INSTANCE;
    }

    public void setDao(final ChatDao dao) {
        this.dao = dao;
    }

}
