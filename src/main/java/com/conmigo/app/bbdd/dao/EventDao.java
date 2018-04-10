package com.conmigo.app.bbdd.dao;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.conmigo.app.bbdd.jpa.Event;

public interface EventDao extends GenericDao<Event, Long> {

    Page<Event> findByNameContainingIgnoreCase(Pageable pageRequest, final String name);

    Page<Event> findByNameContainingIgnoreCaseAndDateAfter(Pageable pageRequest, final String name, final LocalDateTime date);

    Page<Event> findByDateAfter(Pageable pageRequest, final LocalDateTime date);

}
