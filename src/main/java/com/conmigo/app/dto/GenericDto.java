package com.conmigo.app.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class GenericDto<K extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Boolean active = true;
    protected Long createdBy;
    protected LocalDateTime createdDate;
    protected Long lastModifiedBy;
    protected LocalDateTime lastModifiedDate;

    public abstract K getId();

    public abstract void setId(K id);

    /**
     * @return Valor de la propiedad createdBy
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     *            Valor de la propiedad createdBy a setear
     */
    public void setCreatedBy(final Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return Valor de la propiedad createdDate
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     *            Valor de la propiedad createdDate a setear
     */
    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return Valor de la propiedad lastModifiedBy
     */
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @param lastModifiedBy
     *            Valor de la propiedad lastModifiedBy a setear
     */
    public void setLastModifiedBy(final Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * @return Valor de la propiedad lastModifiedDate
     */
    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @param lastModifiedDate
     *            Valor de la propiedad lastModifiedDate a setear
     */
    public void setLastModifiedDate(final LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

}
