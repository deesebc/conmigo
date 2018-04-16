package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Combo;
import com.conmigo.app.dto.ComboDto;

public enum ComboToDto implements Function<Combo, ComboDto> {
    INSTANCE;

    @Override
    public ComboDto apply(final Combo input) {
        ComboDto output = new ComboDto();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, ComboDto.class);
        }
        return output;
    }
}
