package com.conmigo.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;

import com.conmigo.app.bbdd.jpa.Province;
import com.conmigo.app.dto.ProvinceDto;

public enum ProvinceToDto implements Converter<Province, ProvinceDto> {
    INSTANCE;

    @Override
    public ProvinceDto convert(final Province input) {
        ProvinceDto output = new ProvinceDto();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, ProvinceDto.class);
        }
        return output;
    }
}
