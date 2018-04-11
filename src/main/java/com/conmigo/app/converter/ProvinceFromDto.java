package com.conmigo.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;

import com.conmigo.app.bbdd.jpa.Province;
import com.conmigo.app.dto.ProvinceDto;

public enum ProvinceFromDto implements Converter<ProvinceDto, Province> {
    INSTANCE;

    @Override
    public Province convert(final ProvinceDto input) {
        Province output = new Province();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, Province.class);
        }
        return output;
    }
}
