package com.conmigo.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;

import com.conmigo.app.bbdd.jpa.Combo;
import com.conmigo.app.dto.ComboDto;

public enum ComboToDto implements Converter<Combo, ComboDto> {
    INSTANCE;

    @Override
    public ComboDto convert(final Combo input) {
        ComboDto output = new ComboDto();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, ComboDto.class);
        }
        return output;
    }
}
