package com.conmigo.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;

import com.conmigo.app.bbdd.jpa.Event;
import com.conmigo.app.dto.EventDto;

public enum EventToDto implements Converter<Event, EventDto> {
	INSTANCE;

	@Override
	public EventDto convert( final Event input ) {
		EventDto output = new EventDto();
		if( input != null ) {
			ModelMapper model = new ModelMapper();
			model.getConfiguration().setMatchingStrategy( MatchingStrategies.STRICT );
			output = model.map( input, EventDto.class );
		}
		return output;
	}
}
