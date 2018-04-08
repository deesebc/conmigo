package com.conmigo.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.GenericDao;
import com.conmigo.app.bbdd.dao.UserDao;
import com.conmigo.app.bbdd.jpa.User;
import com.conmigo.app.converter.UserFromDto;
import com.conmigo.app.converter.UserToDto;
import com.conmigo.app.dto.UserDto;
import com.conmigo.app.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends GenericBSImpl<UserDto, User, Long> implements UserService {

    /**
     * Descripcion del campo
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    private UserDao dao;

    @Override
    protected GenericDao<User, Long> getDao() {
        return dao;
    }

    @Override
    protected Converter<User, UserDto> getConverterToDTO() {
        return UserToDto.INSTANCE;
    }

    @Override
    protected Converter<UserDto, User> getConverterToEntity() {
        return UserFromDto.INSTANCE;
    }

    public void setDao(final UserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Long> getEventIdsByUser(final Long idUser) {
        return dao.getEventIdsByUser(idUser);
    }

    @Override
    public boolean existUsername(final Long actualId, final String username) {
        return dao.existUsername(actualId, username) > 0L ? true : false;
    }

    @Override
    public boolean existEmail(final Long actualId, final String email) {
        return dao.existEmail(actualId, email) > 0L ? true : false;
    }

}
