package com.conmigo.app.service.custom;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.UserDao;
import com.conmigo.app.bbdd.jpa.Role;
import com.conmigo.app.bbdd.jpa.User;

@Service
public class CustomConnectionSignUp implements ConnectionSignUp {

	@Autowired
	private UserDao uDao;

	@Value( "${role.user.id}" )
	private String roleUserId;

	public CustomConnectionSignUp() {
		super();
	}

	@Override
	public String execute( final Connection<?> connection ) {
		String email = StringUtils.EMPTY;
		if( connection.getApi() instanceof Facebook ) {
			Facebook facebook = (Facebook) connection.getApi();
			String[] fields = { "email", "name", "first_name", "last_name" };
			User userProfile = facebook.fetchObject( "me", User.class, fields );
			// seteamos a nulo para poder insertar AI MYSQL
			userProfile.setId( null );
			userProfile.setEnable( true );
			// generamos password
			userProfile.setPassword( createEncryptPassword() );
			// indicamos como username el correo
			userProfile.setUsername( userProfile.getEmail() );
			// indicamos rol usuario
			Role rolDto = new Role( Long.valueOf( roleUserId ) );
			userProfile.getRoles().add( rolDto );
			userProfile = uDao.save( userProfile );
			email = userProfile.getEmail();
		} else {
			UserProfile profile = connection.fetchUserProfile();
			email = profile.getEmail();
		}
		return email;
	}

	private String createEncryptPassword() {
		return new BCryptPasswordEncoder().encode( RandomStringUtils.randomAlphanumeric( 17 ) );
	}

}