package com.conmigo.app.bbdd.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.conmigo.app.bbdd.jpa.Event;

public interface EventDao extends GenericDao<Event, Long> {

	Page<Event> findByNameContainingIgnoreCase( Pageable pageRequest, final String name );

}
