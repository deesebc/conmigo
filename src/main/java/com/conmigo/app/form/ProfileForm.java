package com.conmigo.app.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ProfileForm {

    @NotEmpty
    private String email;
    @NotEmpty
    private String firstName;
    @NotNull
    private Long id;
    @NotEmpty
    private String lastName;
    private String name;
    @NotEmpty
    private String password;
    @NotEmpty
    private String repeatPassword;
    @NotEmpty
    private String username;

    public String getEmail() {
	return email;
    }

    public String getFirstName() {
	return firstName;
    }

    public Long getId() {
	return id;
    }

    public String getLastName() {
	return lastName;
    }

    public String getName() {
	return name;
    }

    public String getPassword() {
	return password;
    }

    public String getRepeatPassword() {
	return repeatPassword;
    }

    public String getUsername() {
	return username;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setRepeatPassword(String repeatPassword) {
	this.repeatPassword = repeatPassword;
    }

    public void setUsername(String username) {
	this.username = username;
    }

}
