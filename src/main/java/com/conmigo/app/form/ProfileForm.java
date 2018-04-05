package com.conmigo.app.form;

import java.util.Date;

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
    private String username;
    @NotNull
    private Date birthdate;
    @NotEmpty
    private String gender;
    @NotEmpty
    private String town;

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

    public String getUsername() {
        return username;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(final Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getTown() {
        return town;
    }

    public void setTown(final String town) {
        this.town = town;
    }

}
