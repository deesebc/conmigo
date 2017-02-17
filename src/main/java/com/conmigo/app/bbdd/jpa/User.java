package com.conmigo.app.bbdd.jpa;
// Generated 16-feb-2017 12:22:59 by Hibernate Tools 5.1.0.Beta1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table( name = "user", catalog = "conmigodb" )
public class User extends GenericEntity<Integer> {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String surname;
	private String lastname;
	private String email;

	public User() {
	}

	public User( final String name, final String surname, final String lastname, final String email ) {
		this.name = name;
		this.surname = surname;
		this.lastname = lastname;
		this.email = email;
	}

	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "ID", unique = true, nullable = false )
	public Integer getId() {
		return id;
	}

	public void setId( final Integer id ) {
		this.id = id;
	}

	@Column( name = "NAME", nullable = false, length = 50 )
	public String getName() {
		return name;
	}

	public void setName( final String name ) {
		this.name = name;
	}

	@Column( name = "SURNAME", nullable = false, length = 50 )
	public String getSurname() {
		return surname;
	}

	public void setSurname( final String surname ) {
		this.surname = surname;
	}

	@Column( name = "LASTNAME", nullable = false, length = 50 )
	public String getLastname() {
		return lastname;
	}

	public void setLastname( final String lastname ) {
		this.lastname = lastname;
	}

	@Column( name = "EMAIL", nullable = false, length = 50 )
	public String getEmail() {
		return email;
	}

	public void setEmail( final String email ) {
		this.email = email;
	}

}