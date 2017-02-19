package com.conmigo.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;

import com.conmigo.app.bbdd.jpa.Event;
import com.conmigo.app.dto.EventDto;

public enum EventFromDto implements Converter<EventDto, Event> {
	INSTANCE;

	@Override
	public Event convert( final EventDto input ) {
		Event output = new Event();
		if( input != null ) {
			ModelMapper model = new ModelMapper();
			model.getConfiguration().setMatchingStrategy( MatchingStrategies.STRICT );
			output = model.map( input, Event.class );
		}
		return output;
	}
}
