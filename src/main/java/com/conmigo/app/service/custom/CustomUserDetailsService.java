package com.conmigo.app.service.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.UserDao;
import com.conmigo.app.bbdd.jpa.User;
import com.conmigo.app.dto.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername( final String username ) throws UsernameNotFoundException {
		User user = userDao.findByUsernameOrEmail( username, username );
		if( user == null ) {
			throw new UsernameNotFoundException( "No user present with username/email: " + username );
		} else {
			return new CustomUserDetails( user );
		}
	}

}
