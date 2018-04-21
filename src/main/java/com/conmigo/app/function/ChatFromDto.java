package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Chat;
import com.conmigo.app.dto.ChatDto;

public enum ChatFromDto implements Function<ChatDto, Chat> {
    INSTANCE;

    @Override
    public Chat apply(final ChatDto input) {
        Chat output = new Chat();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, Chat.class);
        }
        return output;
    }
}
