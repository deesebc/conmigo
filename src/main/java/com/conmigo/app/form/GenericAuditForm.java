package com.conmigo.app.form;

import java.time.LocalDateTime;

public class GenericAuditForm {
    protected Boolean enable;
    protected Long createdBy;
    protected LocalDateTime createdDate;

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

}
