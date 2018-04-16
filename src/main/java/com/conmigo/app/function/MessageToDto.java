package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Message;
import com.conmigo.app.dto.MessageDto;

public enum MessageToDto implements Function<Message, MessageDto> {
    INSTANCE;

    @Override
    public MessageDto apply(final Message input) {
        MessageDto output = new MessageDto();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, MessageDto.class);
        }
        return output;
    }
}
