package com.conmigo.app.bbdd.jpa;
// Generated Apr 10, 2018 10:48:03 PM by Hibernate Tools 5.2.8.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Provincias generated by hbm2java
 */
@Entity
@Table(name = "province", catalog = "conmigodb")
public class Province extends GenericEntity<Long> {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String provincia;

    public Province() {
    }

    public Province(final long createdBy, final LocalDateTime createdDate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public Province(final String provincia, final long createdBy, final LocalDateTime createdDate, final Long lastModifiedBy,
            final LocalDateTime lastModifiedDate, final Boolean enable) {
        this.provincia = provincia;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.enable = enable;
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

    @Column(name = "PROVINCIA", length = 50)
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(final String provincia) {
        this.provincia = provincia;
    }

}
