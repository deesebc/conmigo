package com.conmigo.app.form;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class ProfileForm {

    @NotEmpty
    @Size(max = 50)
    @Email
    private String email;
    @Size(max = 50)
    private String firstName;
    @NotNull
    private Long id;
    @Size(max = 50)
    private String lastName;
    @NotEmpty
    @Size(max = 50)
    private String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    private String gender;
    @Size(max = 50)
    private String town;
    private Long provinceId;
    private Boolean enable = true;
    private Long createdBy;
    private LocalDateTime createdDate;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(final Boolean enable) {
        this.enable = enable;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

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

    public void setUsername(final String username) {
        this.username = username;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(final LocalDate birthdate) {
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

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(final Long provinceId) {
        this.provinceId = provinceId;
    }

}
