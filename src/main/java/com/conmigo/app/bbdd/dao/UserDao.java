package com.conmigo.app.bbdd.dao;

import com.conmigo.app.bbdd.jpa.User;

public interface UserDao extends GenericDao<User, Integer> {

	User findByName( String username );

}
