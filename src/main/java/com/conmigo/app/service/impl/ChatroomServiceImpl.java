package com.conmigo.app.service.impl;

import java.util.List;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.ChatroomDao;
import com.conmigo.app.bbdd.dao.GenericDao;
import com.conmigo.app.bbdd.jpa.Chatroom;
import com.conmigo.app.bbdd.jpa.User;
import com.conmigo.app.dto.ChatroomDto;
import com.conmigo.app.function.ChatroomFromDto;
import com.conmigo.app.function.ChatroomToDto;
import com.conmigo.app.service.ChatroomService;

@Service
@Transactional
public class ChatroomServiceImpl extends GenericBSImpl<ChatroomDto, Chatroom, Long> implements ChatroomService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ChatroomDao dao;

    @Override
    protected GenericDao<Chatroom, Long> getDao() {
        return dao;
    }

    @Override
    protected Function<Chatroom, ChatroomDto> getConverterToDTO() {
        return ChatroomToDto.INSTANCE;
    }

    @Override
    protected Function<ChatroomDto, Chatroom> getConverterToEntity() {
        return ChatroomFromDto.INSTANCE;
    }

    public void setDao(final ChatroomDao dao) {
        this.dao = dao;
    }

    @Override
    public List<ChatroomDto> findByUser(final Long idUser) {
        User user = new User();
        user.setId(idUser);
        List<Chatroom> list = dao.findByUserByComponent1OrUserByComponent2AndMessagesIsNotEmpty(user, user);
        return getDtoList(list);
    }

}
