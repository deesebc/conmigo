package com.conmigo.app.service;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.conmigo.app.bbdd.jpa.Event;
import com.conmigo.app.dto.EventDto;

public interface EventService extends GenericBS<EventDto, Event, Long> {

    public Page<EventDto> findByNameContainingIgnoreCase(Pageable pageRequest, String name);

    public Page<EventDto> findByDateAfter(Pageable pageRequest, LocalDateTime date);

}
