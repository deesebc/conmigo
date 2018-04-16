package com.conmigo.app.service.impl;

import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.GenericDao;
import com.conmigo.app.bbdd.dao.ProvinceDao;
import com.conmigo.app.bbdd.jpa.Province;
import com.conmigo.app.dto.ProvinceDto;
import com.conmigo.app.function.ProvinceFromDto;
import com.conmigo.app.function.ProvinceToDto;
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
    protected Function<Province, ProvinceDto> getConverterToDTO() {
        return ProvinceToDto.INSTANCE;
    }

    @Override
    protected Function<ProvinceDto, Province> getConverterToEntity() {
        return ProvinceFromDto.INSTANCE;
    }

    public void setDao(final ProvinceDao dao) {
        this.dao = dao;
    }

}
