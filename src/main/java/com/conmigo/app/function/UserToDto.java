package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.User;
import com.conmigo.app.dto.UserDto;

public enum UserToDto implements Function<User, UserDto> {
    INSTANCE;

    @Override
    public UserDto apply(final User input) {
        UserDto output = new UserDto();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, UserDto.class);
        }
        return output;
    }
}
