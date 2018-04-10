package com.conmigo.app.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class EventForm {

    @NotEmpty
    private String name;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String place;
    private String type;

    /**
     * @return Valor de la propiedad name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            Valor de la propiedad name a setear
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return Valor de la propiedad date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     *            Valor de la propiedad date a setear
     */
    public void setDate(final Date date) {
        this.date = date;
    }

    /**
     * @return Valor de la propiedad place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place
     *            Valor de la propiedad place a setear
     */
    public void setPlace(final String place) {
        this.place = place;
    }

    /**
     * @return Valor de la propiedad type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            Valor de la propiedad type a setear
     */
    public void setType(final String type) {
        this.type = type;
    }

}
