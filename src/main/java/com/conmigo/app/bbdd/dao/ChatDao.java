package com.conmigo.app.bbdd.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.conmigo.app.bbdd.jpa.Chat;
import com.conmigo.app.bbdd.jpa.ChatId;
import com.conmigo.app.bbdd.jpa.User;

public interface ChatDao extends GenericDao<Chat, ChatId> {

    Page<Chat> findByUserByReceiverOrUserBySenderOrderByDateAsc(Pageable pageRequest, final User user);
}
