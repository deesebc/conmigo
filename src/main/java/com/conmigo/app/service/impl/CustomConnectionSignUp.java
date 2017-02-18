package com.conmigo.app.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;

import com.conmigo.app.bbdd.dao.UserDao;
import com.conmigo.app.bbdd.jpa.User;

public class CustomConnectionSignUp implements ConnectionSignUp {

	private final UserDao usersDao;

	public CustomConnectionSignUp( final UserDao usersDao ) {
		this.usersDao = usersDao;
	}

	@Override
	public String execute( final Connection<?> connection ) {
		String email = "";
		if( true ) {
			Facebook facebook = (Facebook) connection.getApi();
			String[] fields = { "email", "name", "first_name", "last_name" };
			User userProfile = facebook.fetchObject( "me", User.class, fields );
			// seteamos a nulo para poder insertar AI MYSQL
			userProfile.setId( null );
			// generamos password
			userProfile.setPassword( RandomStringUtils.randomAlphanumeric( 17 ) );
			// indicamos como username el correo
			userProfile.setUsername( userProfile.getEmail() );
			userProfile = usersDao.save( userProfile );
			email = userProfile.getEmail();
			System.out.println( "CustomConnectionSignUp: " + email );
		} else {
			UserProfile profile = connection.fetchUserProfile();
			email = profile.getEmail();
		}

		return email;
	}

	/**
	 * @return Valor de la propiedad usersDao
	 */
	public UserDao getUsersDao() {
		return usersDao;
	}

	/*
	 * FacebookClient facebookClient = new DefaultFacebookClient(accessToken); User user = facebookClient.fetchObject("me", User.class, Parameter.with("metadata", 1)); String query =
	 * "SELECT url FROM profile_pic WHERE id="+user.getId(); List users = facebookClient.executeFqlQuery(query, FqlURL.class); if(users != null) { FqlURL fqlURL = users.get(0); return fqlURL
	 * .getUrl(); }
	 */

}