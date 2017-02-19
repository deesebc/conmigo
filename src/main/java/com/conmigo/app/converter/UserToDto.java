package com.conmigo.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;

import com.conmigo.app.bbdd.jpa.User;
import com.conmigo.app.dto.UserDto;

public enum UserToDto implements Converter<User, UserDto> {
	INSTANCE;

	@Override
	public UserDto convert( final User input ) {
		UserDto output = new UserDto();
		if( input != null ) {
			ModelMapper model = new ModelMapper();
			model.getConfiguration().setMatchingStrategy( MatchingStrategies.STRICT );
			output = model.map( input, UserDto.class );
		}
		return output;
	}
}
