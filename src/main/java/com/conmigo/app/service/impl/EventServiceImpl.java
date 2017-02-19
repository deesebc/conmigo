package com.conmigo.app.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.EventDao;
import com.conmigo.app.bbdd.dao.GenericDao;
import com.conmigo.app.bbdd.jpa.Event;
import com.conmigo.app.converter.EventFromDto;
import com.conmigo.app.converter.EventToDto;
import com.conmigo.app.dto.EventDto;
import com.conmigo.app.service.EventService;

@Service
@Transactional
public class EventServiceImpl extends GenericBSImpl<EventDto, Event, Long> implements EventService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EventDao dao;

	@Override
	protected GenericDao<Event, Long> getDao() {
		return dao;
	}

	@Override
	protected Converter<Event, EventDto> getConverterToDTO() {
		return EventToDto.INSTANCE;
	}

	@Override
	protected Converter<EventDto, Event> getConverterToEntity() {
		return EventFromDto.INSTANCE;
	}

	public void setDao( final EventDao dao ) {
		this.dao = dao;
	}

}
