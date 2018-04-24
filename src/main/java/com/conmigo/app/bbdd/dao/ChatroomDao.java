package com.conmigo.app.bbdd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.conmigo.app.bbdd.jpa.Chatroom;
import com.conmigo.app.bbdd.jpa.User;

public interface ChatroomDao extends GenericDao<Chatroom, Long> {

    @Query("select c from Chatroom c where c.userByComponent1.id = :userId or c.userByComponent1.id = :userId and c.id in (select m.chatroom.id from Message m order by m.date desc)")
    List<Chatroom> findMessagesOrderByDate(@Param("userId") final Long userId);

    List<Chatroom> findByUserByComponent1OrUserByComponent2AndMessagesIsNotEmptyOrderByMessages(final User user1,
            final User user2);
}
