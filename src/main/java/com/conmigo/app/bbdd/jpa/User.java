package com.conmigo.app.bbdd.jpa;
// Generated 16-feb-2017 12:22:59 by Hibernate Tools 5.1.0.Beta1

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User generated by hbm2java
 */
@Entity
@NamedEntityGraph(name = "graph.user.role", attributeNodes = { @NamedAttributeNode(value = "roles") })
@Table(name = "user", catalog = "conmigodb")
public class User extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    protected Long id;
    protected Province province;
    @JsonProperty("first_name")
    protected String firstName;
    @JsonProperty("last_name")
    protected String lastName;
    protected String email;
    protected String username;
    protected String password;
    protected LocalDate birthdate;
    protected String town;
    protected String gender;
    private Set<Role> roles = new HashSet<>(0);

    public User() {
    }

    public User(final long createdBy, final LocalDateTime createdDate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public User(final Long id, final String firstName, final String lastName, final String email, final String username,
            final String password, final LocalDate birthdate, final String town, final String gender, final boolean enable,
            final Set<Role> roles) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.town = town;
        this.gender = gender;
        this.enable = enable;
        this.roles = roles;
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME", length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME", length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "EMAIL", unique = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Column(name = "USERNAME", length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    @Column(name = "PASSWORD", length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Column(name = "BIRTHDATE", length = 10)
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Column(name = "TOWN", length = 50)
    public String getTown() {
        return town;
    }

    public void setTown(final String town) {
        this.town = town;
    }

    @Column(name = "GENDER", length = 1)
    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCE")
    public Province getProvince() {
        return province;
    }

    public void setProvince(final Province province) {
        this.province = province;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", catalog = "conmigodb", joinColumns = {
            @JoinColumn(name = "USER", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "ROLE", nullable = false, updatable = false) })
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Set<Role> roles) {
        this.roles = roles;
    }

}
