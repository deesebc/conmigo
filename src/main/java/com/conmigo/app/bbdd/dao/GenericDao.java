package com.conmigo.app.bbdd.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.conmigo.app.bbdd.jpa.GenericEntity;

@NoRepositoryBean
public interface GenericDao<E extends GenericEntity<K>, K extends Serializable> extends JpaRepository<E, K>, JpaSpecificationExecutor<E> {

}
