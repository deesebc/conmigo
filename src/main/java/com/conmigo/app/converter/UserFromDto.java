package com.conmigo.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;

import com.conmigo.app.bbdd.jpa.User;
import com.conmigo.app.dto.UserDto;

public enum UserFromDto implements Converter<UserDto, User> {
	INSTANCE;

	@Override
	public User convert( final UserDto input ) {
		User output = new User();
		if( input != null ) {
			ModelMapper model = new ModelMapper();
			model.getConfiguration().setMatchingStrategy( MatchingStrategies.STRICT );
			output = model.map( input, User.class );
		}
		return output;
	}
}
