package com.conmigo.app.service;

import java.util.List;

import com.conmigo.app.bbdd.jpa.Combo;
import com.conmigo.app.dto.ComboDto;

public interface ComboService extends GenericBS<ComboDto, Combo, Long> {

    List<ComboDto> getCombosByType(final String type);
}
