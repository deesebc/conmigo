package com.conmigo.app.dto;
// Generated 24-feb-2017 10:37:08 by Hibernate Tools 5.1.0.Beta1

import java.util.Date;

/**
 * Message generated by hbm2java
 */
public class MessageDto extends GenericDto<Long> {

	private static final long serialVersionUID = 1L;
	private Long id;
	private UserDto sender;
	private UserDto receiver;
	private String message;
	private Date date;

	public MessageDto() {
	}

	public MessageDto( final UserDto userBySender, final UserDto userByReceiver ) {
		sender = userBySender;
		receiver = userByReceiver;
	}

	public MessageDto( final UserDto userBySender, final UserDto userByReceiver, final String message, final Date date, final Long createdBy, final Date createdDate, final Long lastModifiedBy, final Date lastModifiedDate ) {
		sender = userBySender;
		receiver = userByReceiver;
		this.message = message;
		this.date = date;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId( final Long id ) {
		this.id = id;
	}

	public UserDto getSender() {
		return sender;
	}

	public void setSender( final UserDto userBySender ) {
		sender = userBySender;
	}

	public UserDto getReceiver() {
		return receiver;
	}

	public void setReceiver( final UserDto userByReceiver ) {
		receiver = userByReceiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage( final String message ) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate( final Date date ) {
		this.date = date;
	}

}