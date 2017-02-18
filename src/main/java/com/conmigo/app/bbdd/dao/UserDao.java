package com.conmigo.app.bbdd.dao;

import com.conmigo.app.bbdd.jpa.User;

public interface UserDao extends GenericDao<User, Long> {

	User findByUsernameOrEmail( final String username, final String email );

}
