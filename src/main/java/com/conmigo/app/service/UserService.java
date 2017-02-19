package com.conmigo.app.service;

import com.conmigo.app.bbdd.jpa.User;
import com.conmigo.app.dto.UserDto;

public interface UserService extends GenericBS<UserDto, User, Long> {

}
