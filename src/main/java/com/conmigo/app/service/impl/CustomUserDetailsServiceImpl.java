package com.conmigo.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.conmigo.app.bbdd.dao.UserDao;
import com.conmigo.app.bbdd.jpa.User;
import com.conmigo.app.dto.CustomUserDetails;

@Service
@Transactional
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername( final String username ) throws UsernameNotFoundException {
		User user = userDao.findByName( username );
		if( user == null ) {
			throw new UsernameNotFoundException( "No user present with username: " + username );
		} else {
			// List<String> userRoles = userTypeDao.findRoleByUserName( username );
			// UserDto userDto = UserToDto.INSTANCE.convert( user );
			List<String> userRoles = new ArrayList<>();
			userRoles.add( "USER" );
			return new CustomUserDetails( user, userRoles );
		}
	}

}
