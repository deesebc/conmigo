package com.conmigo.app.service.impl;

import java.util.List;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.ComboDao;
import com.conmigo.app.bbdd.dao.GenericDao;
import com.conmigo.app.bbdd.jpa.Combo;
import com.conmigo.app.dto.ComboDto;
import com.conmigo.app.function.ComboFromDto;
import com.conmigo.app.function.ComboToDto;
import com.conmigo.app.service.ComboService;

@Service
@Transactional
public class ComboServiceImpl extends GenericBSImpl<ComboDto, Combo, Long> implements ComboService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ComboDao dao;

    @Override
    protected GenericDao<Combo, Long> getDao() {
        return dao;
    }

    @Override
    protected Function<Combo, ComboDto> getConverterToDTO() {
        return ComboToDto.INSTANCE;
    }

    @Override
    protected Function<ComboDto, Combo> getConverterToEntity() {
        return ComboFromDto.INSTANCE;
    }

    public void setDao(final ComboDao dao) {
        this.dao = dao;
    }

    @Override
    public List<ComboDto> getCombosByType(final String type) {
        return getDtoList(dao.findByType(type));
    }

}
