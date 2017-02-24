package com.conmigo.app.bbdd.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.conmigo.app.bbdd.jpa.Message;
import com.conmigo.app.bbdd.jpa.User;

public interface MessageDao extends GenericDao<Message, Long> {

	public Page<Message> findByReceiver( Pageable pageRequest, final User receiver );

}
