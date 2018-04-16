package com.conmigo.app.function;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.conmigo.app.bbdd.jpa.Event;
import com.conmigo.app.dto.EventDto;

public enum EventFromDto implements Function<EventDto, Event> {
    INSTANCE;

    @Override
    public Event apply(final EventDto input) {
        Event output = new Event();
        if (input != null) {
            ModelMapper model = new ModelMapper();
            model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            output = model.map(input, Event.class);
        }
        return output;
    }
}
