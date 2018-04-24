package com.conmigo.app.bbdd.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.conmigo.app.bbdd.jpa.Event;
import com.conmigo.app.bbdd.jpa.Province;

public interface EventDao extends GenericDao<Event, Long> {
    // Top3ByLastname

    Page<Event> findByNameContainingIgnoreCase(Pageable pageRequest, final String name);

    Page<Event> findByNameContainingIgnoreCaseAndDateAfter(Pageable pageRequest, final String name, final LocalDateTime date);

    Page<Event> findByDateAfter(Pageable pageRequest, final LocalDateTime date);

    List<Event> findTop5ByDateAfterAndProvinceOrderByDateAsc(final LocalDateTime date, final Province province);

    List<Event> findTop5ByDateAfterOrderByDateAsc(final LocalDateTime date);

}
