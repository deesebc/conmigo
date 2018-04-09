package com.conmigo.app.dto;

import java.time.LocalDateTime;

public class ComboDto extends GenericDto<Long> {

    private static final long serialVersionUID = 1L;

    protected Long id;
    protected String name;
    protected String value;
    protected String type;

    public ComboDto() {
        super();
    }

    public ComboDto(final Long id) {
        super();
        this.id = id;
    }

    public ComboDto(final Long id, final String name, final String value, final String type) {
        super();
        this.id = id;
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public ComboDto(final long createdBy, final LocalDateTime createdDate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

}
