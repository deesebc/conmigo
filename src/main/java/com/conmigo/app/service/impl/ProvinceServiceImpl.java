package com.conmigo.app.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.GenericDao;
import com.conmigo.app.bbdd.dao.ProvinceDao;
import com.conmigo.app.bbdd.jpa.Province;
import com.conmigo.app.converter.ProvinceFromDto;
import com.conmigo.app.converter.ProvinceToDto;
import com.conmigo.app.dto.ProvinceDto;
import com.conmigo.app.service.ProvinceService;

@Service
@Transactional
public class ProvinceServiceImpl extends GenericBSImpl<ProvinceDto, Province, Long> implements ProvinceService {
    /**
     * Descripcion del campo
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    private ProvinceDao dao;

    @Override
    protected GenericDao<Province, Long> getDao() {
        return dao;
    }

    @Override
    protected Converter<Province, ProvinceDto> getConverterToDTO() {
        return ProvinceToDto.INSTANCE;
    }

    @Override
    protected Converter<ProvinceDto, Province> getConverterToEntity() {
        return ProvinceFromDto.INSTANCE;
    }

    public void setDao(final ProvinceDao dao) {
        this.dao = dao;
    }

}
