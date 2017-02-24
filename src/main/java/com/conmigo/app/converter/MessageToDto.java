package com.conmigo.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;

import com.conmigo.app.bbdd.jpa.Message;
import com.conmigo.app.dto.MessageDto;

public enum MessageToDto implements Converter<Message, MessageDto> {
	INSTANCE;

	@Override
	public MessageDto convert( final Message input ) {
		MessageDto output = new MessageDto();
		if( input != null ) {
			ModelMapper model = new ModelMapper();
			model.getConfiguration().setMatchingStrategy( MatchingStrategies.STRICT );
			output = model.map( input, MessageDto.class );
		}
		return output;
	}
}
