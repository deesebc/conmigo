package com.conmigo.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.conmigo.app.bbdd.jpa.Message;
import com.conmigo.app.dto.MessageDto;
import com.conmigo.app.dto.UserDto;

public interface MessageService extends GenericBS<MessageDto, Message, Long> {

	public Page<MessageDto> findByReceiver( Pageable pageRequest, final UserDto receiver );

}
