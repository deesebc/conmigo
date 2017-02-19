package com.conmigo.app.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.conmigo.app.bbdd.jpa.GenericEntity;
import com.conmigo.app.dto.GenericDto;

/**
 * Descripcion de clase
 *
 * @author dblancoc
 * @version 1.0
 * @created: 16 de ago. de 2016
 */
public interface GenericBS<D extends GenericDto<K>, E extends GenericEntity<K>, K extends Serializable> extends Serializable {

	List<D> findAll();

	void delete( D entity );

	void deleteById( K key );

	D findById( K key );

	D save( D entity );

	Page<D> getPage( final Pageable page );

	Page<D> getAdminPage( Pageable page );

}
