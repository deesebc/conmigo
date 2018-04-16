package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Message;
import com.conmigo.app.dto.MessageDto;

public enum MessageFromDto implements Function<MessageDto, Message> {
    INSTANCE;

    @Override
    public Message apply(final MessageDto input) {
        Message output = new Message();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, Message.class);
        }
        return output;
    }
}
