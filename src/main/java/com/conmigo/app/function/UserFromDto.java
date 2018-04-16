package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.User;
import com.conmigo.app.dto.UserDto;

public enum UserFromDto implements Function<UserDto, User> {
    INSTANCE;

    @Override
    public User apply(final UserDto input) {
        User output = new User();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, User.class);
        }
        return output;
    }
}
