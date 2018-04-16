package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Event;
import com.conmigo.app.dto.EventDto;

public enum EventToDto implements Function<Event, EventDto> {
    INSTANCE;

    @Override
    public EventDto apply(final Event input) {
        EventDto output = new EventDto();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, EventDto.class);
        }
        return output;
    }
}
