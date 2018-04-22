package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Chatroom;
import com.conmigo.app.dto.ChatroomDto;

public enum ChatroomFromDto implements Function<ChatroomDto, Chatroom> {
    INSTANCE;

    @Override
    public Chatroom apply(final ChatroomDto input) {
        Chatroom output = new Chatroom();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, Chatroom.class);
        }
        return output;
    }
}
