package com.conmigo.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;

import com.conmigo.app.bbdd.jpa.Message;
import com.conmigo.app.dto.MessageDto;

public enum MessageFromDto implements Converter<MessageDto, Message> {
	INSTANCE;

	@Override
	public Message convert( final MessageDto input ) {
		Message output = new Message();
		if( input != null ) {
			ModelMapper model = new ModelMapper();
			model.getConfiguration().setMatchingStrategy( MatchingStrategies.STRICT );
			output = model.map( input, Message.class );
		}
		return output;
	}
}
