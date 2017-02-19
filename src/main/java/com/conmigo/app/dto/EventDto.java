package com.conmigo.app.dto;

import java.util.Date;

public class EventDto extends GenericDto<Long> {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Date date;

	public EventDto() {
	}

	public EventDto( final Long id ) {
		this.id = id;
	}

	public EventDto( final Long id, final String name, final Date date, final long createdBy, final Date createdDate, final Long lastModifiedBy, final Date lastModifiedDate ) {
		this.id = id;
		this.name = name;
		this.date = date;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId( final Long id ) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( final String name ) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate( final Date date ) {
		this.date = date;
	}

}
