package com.conmigo.app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.EventDao;
import com.conmigo.app.bbdd.dao.GenericDao;
import com.conmigo.app.bbdd.jpa.Event;
import com.conmigo.app.bbdd.jpa.Province;
import com.conmigo.app.dto.EventDto;
import com.conmigo.app.function.EventFromDto;
import com.conmigo.app.function.EventToDto;
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
    protected Function<Event, EventDto> getConverterToDTO() {
        return EventToDto.INSTANCE;
    }

    @Override
    protected Function<EventDto, Event> getConverterToEntity() {
        return EventFromDto.INSTANCE;
    }

    public void setDao(final EventDao dao) {
        this.dao = dao;
    }

    @Override
    public Page<EventDto> findByNameContainingIgnoreCase(final Pageable pageRequest, final String name) {
        final Page<Event> pageEntities = dao.findByNameContainingIgnoreCase(pageRequest, name);
        return pageEntities.map(getConverterToDTO());
    }

    @Override
    public Page<EventDto> findByDateAfter(final Pageable pageRequest, final LocalDateTime date) {
        final Page<Event> pageEntities = dao.findByDateAfter(pageRequest, date);
        return pageEntities.map(getConverterToDTO());
    }

    @Override
    public Page<EventDto> findByNameContainingIgnoreCaseAndDateAfter(final Pageable pageRequest, final String name,
            final LocalDateTime date) {
        final Page<Event> pageEntities = dao.findByNameContainingIgnoreCaseAndDateAfter(pageRequest, name, date);
        return pageEntities.map(getConverterToDTO());
    }

    @Override
    public List<EventDto> findByDateAfterAndProvinceOrderByDateAsc(final Pageable pageRequest, final LocalDateTime date,
            final Long provinceId) {
        Province province = new Province();
        province.setId(provinceId);
        final List<Event> pageEntities = dao.findTop5ByDateAfterAndProvinceOrderByDateAsc(date, province);
        return getDtoList(pageEntities);
    }

    @Override
    public List<EventDto> findByDateAfterOrderByDateAsc(final Pageable pageRequest, final LocalDateTime date) {
        final List<Event> pageEntities = dao.findTop5ByDateAfterOrderByDateAsc(date);
        return getDtoList(pageEntities);
    }

}
