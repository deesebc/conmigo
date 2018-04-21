package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Chat;
import com.conmigo.app.dto.ChatDto;

public enum ChatToDto implements Function<Chat, ChatDto> {
    INSTANCE;

    @Override
    public ChatDto apply(final Chat input) {
        ChatDto output = new ChatDto();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, ChatDto.class);
        }
        return output;
    }
}
