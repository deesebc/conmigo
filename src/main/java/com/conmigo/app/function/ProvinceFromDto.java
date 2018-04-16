package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Province;
import com.conmigo.app.dto.ProvinceDto;

public enum ProvinceFromDto implements Function<ProvinceDto, Province> {
    INSTANCE;

    @Override
    public Province apply(final ProvinceDto input) {
        Province output = new Province();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, Province.class);
        }
        return output;
    }
}
