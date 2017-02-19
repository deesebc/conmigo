package com.conmigo.app.dto;

public class UserDto extends GenericDto<Long> {

	private static final long serialVersionUID = 1L;

	protected Long id;
	protected String name;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String username;
	protected String password;
	protected boolean enable;

	public UserDto() {
	}

	public UserDto( final String name, final String firstName, final String lastName, final String email ) {
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( final String firstName ) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName( final String lastName ) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( final String email ) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername( final String username ) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( final String password ) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable( final boolean enable ) {
		this.enable = enable;
	}

}
