package com.conmigo.app.service;

import com.conmigo.app.bbdd.jpa.Event;
import com.conmigo.app.dto.EventDto;

public interface EventService extends GenericBS<EventDto, Event, Long> {

}
