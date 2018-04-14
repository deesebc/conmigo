package com.conmigo.app.form;

public class EventSearchForm {
    private Integer page = 0;
    private String name;

    public Integer getPage() {
        return page;
    }

    public void setPage(final Integer page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
