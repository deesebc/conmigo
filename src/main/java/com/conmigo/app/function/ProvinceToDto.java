package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Province;
import com.conmigo.app.dto.ProvinceDto;

public enum ProvinceToDto implements Function<Province, ProvinceDto> {
    INSTANCE;

    @Override
    public ProvinceDto apply(final Province input) {
        ProvinceDto output = new ProvinceDto();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, ProvinceDto.class);
        }
        return output;
    }
}
