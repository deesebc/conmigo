package com.conmigo.app.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.GenericDao;
import com.conmigo.app.bbdd.dao.MessageDao;
import com.conmigo.app.bbdd.jpa.Message;
import com.conmigo.app.bbdd.jpa.User;
import com.conmigo.app.converter.MessageFromDto;
import com.conmigo.app.converter.MessageToDto;
import com.conmigo.app.converter.UserFromDto;
import com.conmigo.app.dto.MessageDto;
import com.conmigo.app.dto.UserDto;
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
	protected Converter<Message, MessageDto> getConverterToDTO() {
		return MessageToDto.INSTANCE;
	}

	@Override
	protected Converter<MessageDto, Message> getConverterToEntity() {
		return MessageFromDto.INSTANCE;
	}

	public void setDao( final MessageDao dao ) {
		this.dao = dao;
	}

	@Override
	public Page<MessageDto> findByReceiver( final Pageable pageRequest, final UserDto receiver ) {
		User user = UserFromDto.INSTANCE.convert( receiver );
		final Page<Message> pageEntities = dao.findByReceiver( pageRequest, user );
		return pageEntities.map( getConverterToDTO() );
	}

}
