package com.conmigo.app.bbdd.jpa;
// Generated 22-feb-2017 8:12:26 by Hibernate Tools 5.1.0.Beta1

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "conmigodb")
public class Role extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String description;

    public Role() {
        super();
    }

    public Role(final Long id) {
        this.id = id;
    }

    public Role(final String name, final String description, final Long createdBy, final LocalDateTime createdDate,
            final Long lastModifiedBy, final LocalDateTime lastModifiedDate) {
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    @Id
    @GeneratedValue(strategy = IDENTITY)
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

    @Column(name = "DESCRIPTION", length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
