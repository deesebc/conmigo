package com.conmigo.app.bbdd.dao;

import org.springframework.data.jpa.repository.EntityGraph;

import com.conmigo.app.bbdd.jpa.User;

public interface UserDao extends GenericDao<User, Long> {

	@EntityGraph( "graph.user.role" )
	User findByUsernameOrEmail( final String username, final String email );

}
