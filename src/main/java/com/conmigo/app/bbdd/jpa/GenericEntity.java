package com.conmigo.app.bbdd.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners( AuditingEntityListener.class )
public abstract class GenericEntity<K extends Serializable> implements Serializable {

	private static final long serialVersionUID = 4037578824025696367L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "ID", unique = true, nullable = false )
	public abstract K getId();

	public abstract void setId( K id );

	protected Long createdBy;
	protected Date createdDate;
	protected Long lastModifiedBy;
	protected Date lastModifiedDate;

	@Column( name = "CREATED_BY", nullable = false )
	@CreatedBy
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy( final long createdBy ) {
		this.createdBy = createdBy;
	}

	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "CREATED_DATE", nullable = false, length = 19 )
	@CreatedDate
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate( final Date createdDate ) {
		this.createdDate = createdDate;
	}

	@Column( name = "LAST_MODIFIED_BY" )
	@LastModifiedBy
	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy( final Long lastModifiedBy ) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "LAST_MODIFIED_DATE", length = 19 )
	@LastModifiedDate
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate( final Date lastModifiedDate ) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
