package com.conmigo.app.bbdd.dao;

import java.util.List;

import com.conmigo.app.bbdd.jpa.Chatroom;
import com.conmigo.app.bbdd.jpa.User;

public interface ChatroomDao extends GenericDao<Chatroom, Long> {

    List<Chatroom> findByUserByComponent1OrUserByComponent2AndMessagesIsNotEmpty(final User user1, final User user2);
}
