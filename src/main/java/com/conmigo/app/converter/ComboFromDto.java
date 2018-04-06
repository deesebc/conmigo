package com.conmigo.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;

import com.conmigo.app.bbdd.jpa.Combo;
import com.conmigo.app.dto.ComboDto;

public enum ComboFromDto implements Converter<ComboDto, Combo> {
    INSTANCE;

    @Override
    public Combo convert(final ComboDto input) {
        Combo output = new Combo();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, Combo.class);
        }
        return output;
    }
}
