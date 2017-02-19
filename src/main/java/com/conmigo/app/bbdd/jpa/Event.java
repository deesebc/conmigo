package com.conmigo.app.bbdd.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "event", catalog = "conmigodb" )
public class Event extends GenericEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Date date;

	public Event() {
	}

	public Event( final Long id ) {
		this.id = id;
	}

	public Event( final Long id, final String name, final Date date, final long createdBy, final Date createdDate, final Long lastModifiedBy, final Date lastModifiedDate ) {
		this.id = id;
		this.name = name;
		this.date = date;
	}

	@Override
	@Id
	@Column( name = "ID", unique = true, nullable = false )
	public Long getId() {
		return id;
	}

	@Override
	public void setId( final Long id ) {
		this.id = id;
	}

	@Column( name = "NAME", length = 50 )
	public String getName() {
		return name;
	}

	public void setName( final String name ) {
		this.name = name;
	}

	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "DATE", nullable = false, length = 19 )
	public Date getDate() {
		return date;
	}

	public void setDate( final Date date ) {
		this.date = date;
	}

}
