package com.conmigo.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import com.conmigo.app.service.custom.CustomConnectionSignUp;

/**
 * Created by Mohamed on 5/29/2014
 */
@Configuration
@EnableSocial
public class SocialConfig implements SocialConfigurer {

	@Autowired
	private DataSource dataSource;

	@Override
	public void addConnectionFactories( final ConnectionFactoryConfigurer connectionFactoryConfigurer, final Environment environment ) {
	}

	@Override
	public UserIdSource getUserIdSource() {
		return new AuthenticationNameUserIdSource();
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository( final ConnectionFactoryLocator connectionFactoryLocator ) {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository( dataSource, connectionFactoryLocator, Encryptors.noOpText() );
		repository.setConnectionSignUp( new CustomConnectionSignUp() );
		return repository;
	}
}
