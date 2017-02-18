package com.conmigo.app.bbdd.jpa;
// Generated 16-feb-2017 12:22:59 by Hibernate Tools 5.1.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User generated by hbm2java
 */
@Entity
@Table( name = "user", catalog = "conmigodb" )
public class User extends GenericEntity<Long> {

	private static final long serialVersionUID = 1L;

	protected Long id;
	protected String name;
	@JsonProperty( "first_name" )
	protected String firstName;
	@JsonProperty( "last_name" )
	protected String lastName;
	protected String email;
	protected String username;
	protected String password;
	protected boolean enable;

	public User() {
	}

	public User( final String name, final String firstName, final String lastName, final String email ) {
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
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

	@Column( name = "FIRST_NAME", length = 50 )
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( final String firstName ) {
		this.firstName = firstName;
	}

	@Column( name = "LAST_NAME", length = 50 )
	public String getLastName() {
		return lastName;
	}

	public void setLastName( final String lastName ) {
		this.lastName = lastName;
	}

	@Column( name = "EMAIL", unique = true, length = 50 )
	public String getEmail() {
		return email;
	}

	public void setEmail( final String email ) {
		this.email = email;
	}

	@Column( name = "USERNAME", length = 50 )
	public String getUsername() {
		return username;
	}

	public void setUsername( final String username ) {
		this.username = username;
	}

	@Column( name = "PASSWORD", length = 100 )
	public String getPassword() {
		return password;
	}

	public void setPassword( final String password ) {
		this.password = password;
	}

	@Column( name = "ENABLE" )
	public boolean isEnable() {
		return enable;
	}

	public void setEnable( final boolean enable ) {
		this.enable = enable;
	}

}
