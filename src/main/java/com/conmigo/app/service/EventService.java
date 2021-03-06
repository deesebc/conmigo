package com.conmigo.app.service;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.conmigo.app.bbdd.jpa.Event;
import com.conmigo.app.dto.EventDto;

public interface EventService extends GenericBS<EventDto, Event, Long> {

    public Page<EventDto> findByNameContainingIgnoreCase(Pageable pageRequest, String name);

    public Page<EventDto> findByNameContainingIgnoreCaseAndDateAfter(Pageable pageRequest, final String name,
            final LocalDateTime date);

    public Page<EventDto> findByDateAfter(Pageable pageRequest, LocalDateTime date);

    Page<EventDto> findByDateAfterAndProvinceOrderByDateAsc(Pageable pageRequest, final LocalDateTime date,
            final Long provinceId);

    Page<EventDto> findByDateAfterOrderByDateAsc(Pageable pageRequest, final LocalDateTime date);

}
