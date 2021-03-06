package com.conmigo.app.bbdd.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class GenericEntity<K extends Serializable> implements Serializable {

    private static final long serialVersionUID = 4037578824025696367L;

    protected Boolean enable = true;
    protected Long createdBy;
    protected LocalDateTime createdDate;
    protected Long lastModifiedBy;
    protected LocalDateTime lastModifiedDate;

    @Column(name = "ENABLE")
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(final boolean enable) {
        this.enable = enable;
    }

    @Column(name = "CREATED_BY", nullable = false)
    @CreatedBy
    public Long getCreatedBy() {
        return createdBy;
    }

    @Column(name = "CREATED_DATE", nullable = false, length = 19)
    @CreatedDate
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public abstract K getId();

    @Column(name = "LAST_MODIFIED_BY")
    @LastModifiedBy
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Column(name = "LAST_MODIFIED_DATE", length = 19)
    @LastModifiedDate
    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setCreatedBy(final Long createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public abstract void setId(K id);

    public void setLastModifiedBy(final Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(final LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
