package com.conmigo.app.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.conmigo.app.bbdd.dao.GenericDao;
import com.conmigo.app.bbdd.jpa.GenericEntity;
import com.conmigo.app.dto.GenericDto;
import com.conmigo.app.service.GenericBS;

public abstract class GenericBSImpl<D extends GenericDto<K>, E extends GenericEntity<K>, K extends Serializable> implements GenericBS<D, E, K> {

	private static final long serialVersionUID = 1L;

	protected abstract GenericDao<E, K> getDao();

	protected abstract Converter<E, D> getConverterToDTO();

	protected abstract Converter<D, E> getConverterToEntity();

	@Autowired
	ConversionService conversionService;

	@Override
	public List<D> findAll() {
		List<E> entities = getDao().findAll();
		return getDtoList( entities );
	}

	@Override
	public void delete( final D dto ) {
		getDao().delete( getConverterToEntity().convert( dto ) );
	}

	@Override
	public void deleteById( final K key ) {
		getDao().delete( key );
	}

	@Override
	public D findById( final K key ) {
		return getConverterToDTO().convert( getDao().getOne( key ) );
	}

	@Override
	public D save( final D dto ) {
		return getConverterToDTO().convert( getDao().save( getConverterToEntity().convert( dto ) ) );
	}

	@Override
	public Page<D> getPage( final Pageable page ) {
		Page<E> pageEntities = getDao().findAll( page );
		return pageEntities.map( getConverterToDTO() );
	}

	@Override
	public Page<D> getAdminPage( final Pageable page ) {
		Page<E> pageEntities = getDao().findAll( page );
		return pageEntities.map( getConverterToDTO() );
	}

	protected List<D> getDtoList( final List<E> entities ) {
		List<D> dtos = new ArrayList<D>();
		if( entities != null && entities.size() > 0 ) {
			for( E entity : entities ) {
				dtos.add( getConverterToDTO().convert( entity ) );
			}
		}
		return dtos;
	}

	protected List<D> getDtoList( final Collection<E> entities ) {
		List<D> dtos = new ArrayList<D>();
		if( entities != null && entities.size() > 0 ) {
			for( E entity : entities ) {
				dtos.add( getConverterToDTO().convert( entity ) );
			}
		}
		return dtos;
	}

	protected List<E> getEntityList( final List<D> dtos ) {
		List<E> entities = new ArrayList<E>();
		if( dtos != null && dtos.size() > 0 ) {
			for( D dto : dtos ) {
				entities.add( getConverterToEntity().convert( dto ) );
			}
		}
		return entities;
	}

}
