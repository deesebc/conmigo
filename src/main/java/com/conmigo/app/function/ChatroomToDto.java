package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Chatroom;
import com.conmigo.app.dto.ChatroomDto;

public enum ChatroomToDto implements Function<Chatroom, ChatroomDto> {
    INSTANCE;

    @Override
    public ChatroomDto apply(final Chatroom input) {
        ChatroomDto output = null;
        try {
            if (input != null && input.getId() != null) {
                ModelMapper model = new ModelMapper();
                model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
                output = model.map(input, ChatroomDto.class);
            }
        } catch (Exception except) {
            except.printStackTrace();
        }
        return output;
    }
}
