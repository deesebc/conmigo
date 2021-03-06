package com.conmigo.app.bbdd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.conmigo.app.bbdd.jpa.User;

public interface UserDao extends GenericDao<User, Long> {

    @EntityGraph("graph.user.role")
    User findByUsernameOrEmail(final String username, final String email);

    @Query(value = "SELECT EVENT from user_event where USER = :idUser", nativeQuery = true)
    List<Long> getEventIdsByUser(@Param("idUser") Long idUser);

    @Query(value = "SELECT count(*) from User u where u.id <> :actualId and u.username=:username")
    Long existUsername(@Param("actualId") final Long actualId, @Param("username") final String username);

    @Query(value = "SELECT count(*) from User u where u.id <> :actualId and u.email=:email")
    Long existEmail(@Param("actualId") final Long actualId, @Param("email") final String email);

}
