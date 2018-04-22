package com.conmigo.app.service.impl;

import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.GenericDao;
import com.conmigo.app.bbdd.dao.MessageDao;
import com.conmigo.app.bbdd.jpa.Message;
import com.conmigo.app.dto.MessageDto;
import com.conmigo.app.function.MessageFromDto;
import com.conmigo.app.function.MessageToDto;
import com.conmigo.app.service.MessageService;

@Service
@Transactional
public class MessageServiceImpl extends GenericBSImpl<MessageDto, Message, Long> implements MessageService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private MessageDao dao;

    @Override
    protected GenericDao<Message, Long> getDao() {
        return dao;
    }

    @Override
    protected Function<Message, MessageDto> getConverterToDTO() {
        return MessageToDto.INSTANCE;
    }

    @Override
    protected Function<MessageDto, Message> getConverterToEntity() {
        return MessageFromDto.INSTANCE;
    }

    public void setDao(final MessageDao dao) {
        this.dao = dao;
    }

}
