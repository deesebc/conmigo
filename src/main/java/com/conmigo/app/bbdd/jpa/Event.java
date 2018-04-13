package com.conmigo.app.bbdd.jpa;

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
import javax.persistence.Table;

@Entity
@Table(name = "event", catalog = "conmigodb")
public class Event extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;
    protected Province province;
    private String name;
    private LocalDateTime date;
    private String place;
    private String type;
    private Set<User> users = new HashSet<>(0);

    public Event() {
        super();
    }

    public Event(final Province province, final String name, final LocalDateTime date, final String place, final String type,
            final Long createdBy, final LocalDateTime createdDate, final Long lastModifiedBy,
            final LocalDateTime lastModifiedDate, final Set<User> users) {
        this.province = province;
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

    @Column(name = "NAME", length = 50)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Column(name = "DATE", nullable = false, length = 19)
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(final LocalDateTime date) {
        this.date = date;
    }

    @Column(name = "PLACE", length = 50)
    public String getPlace() {
        return place;
    }

    public void setPlace(final String place) {
        this.place = place;
    }

    @Column(name = "TYPE", length = 50)
    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
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
    @JoinTable(name = "user_event", catalog = "conmigodb", joinColumns = {
            @JoinColumn(name = "EVENT", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "USER", nullable = false, updatable = false) })
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(final Set<User> users) {
        this.users = users;
    }

}
