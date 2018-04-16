package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Combo;
import com.conmigo.app.dto.ComboDto;

public enum ComboFromDto implements Function<ComboDto, Combo> {
    INSTANCE;

    @Override
    public Combo apply(final ComboDto input) {
        Combo output = new Combo();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, Combo.class);
        }
        return output;
    }
}
