package com.conmigo.app.dto;
// Generated Apr 10, 2018 10:48:03 PM by Hibernate Tools 5.2.8.Final

import java.time.LocalDateTime;

public class ProvinceDto extends GenericDto<Long> {

    private static final long serialVersionUID = 2957611324448228619L;
    private Long id;
    private String provincia;

    public ProvinceDto() {
    }

    public ProvinceDto(final long createdBy, final LocalDateTime createdDate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public ProvinceDto(final String provincia, final long createdBy, final LocalDateTime createdDate, final Long lastModifiedBy,
            final LocalDateTime lastModifiedDate, final Boolean enable) {
        this.provincia = provincia;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.enable = enable;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(final String provincia) {
        this.provincia = provincia;
    }

}
