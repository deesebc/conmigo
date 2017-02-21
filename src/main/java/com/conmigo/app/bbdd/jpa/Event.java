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
	private String place;
	private String type;

	public Event() {
	}

	public Event( final Long id, final Long createdBy, final Date createdDate ) {
		this.id = id;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public Event( final Long id, final String name, final Date date, final String place, final String type, final Long createdBy, final Date createdDate, final Long lastModifiedBy, final Date lastModifiedDate ) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.place = place;
		this.type = type;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
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

	@Column( name = "PLACE", length = 50 )
	public String getPlace() {
		return place;
	}

	public void setPlace( final String place ) {
		this.place = place;
	}

	@Column( name = "TYPE", length = 50 )
	public String getType() {
		return type;
	}

	public void setType( final String type ) {
		this.type = type;
	}

}
