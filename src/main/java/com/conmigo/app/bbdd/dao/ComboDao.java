package com.conmigo.app.bbdd.dao;

import java.util.List;

import com.conmigo.app.bbdd.jpa.Combo;

public interface ComboDao extends GenericDao<Combo, Long> {

    List<Combo> findByType(final String type);

}
