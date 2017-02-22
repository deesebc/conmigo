package com.conmigo.app.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EventDto extends GenericDto<Long> {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Date date;
	private String place;
	private String type;
	private Set<UserDto> users = new HashSet<UserDto>( 0 );

	public EventDto() {
		super();
	}

	public EventDto( final String name, final Date date, final String place, final String type, final Long createdBy, final Date createdDate, final Long lastModifiedBy, final Date lastModifiedDate, final Set<UserDto> users ) {
		this.name = name;
		this.date = date;
		this.place = place;
		this.type = type;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
		this.users = users;
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

	/**
	 * @return Valor de la propiedad place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            Valor de la propiedad place a setear
	 */
	public void setPlace( final String place ) {
		this.place = place;
	}

	/**
	 * @return Valor de la propiedad type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            Valor de la propiedad type a setear
	 */
	public void setType( final String type ) {
		this.type = type;
	}

	public Set<UserDto> getUsers() {
		return users;
	}

	public void setUsers( final Set<UserDto> users ) {
		this.users = users;
	}

}
