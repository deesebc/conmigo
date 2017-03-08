package com.conmigo.app.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.util.StringUtils;

import com.conmigo.app.bbdd.jpa.Role;
import com.conmigo.app.bbdd.jpa.User;

public class CustomUserDetails extends User implements SocialUserDetails {

	/**
	 * Descripcion del campo
	 */
	private static final long serialVersionUID = 4454136926840298913L;

	List<String> userRoles;

	public CustomUserDetails() {
		super();
		userRoles = new ArrayList<>();
	}

	public CustomUserDetails( final User user ) {
		try {
			PropertyUtils.copyProperties( this, user );
		} catch( Exception except ) {
			except.printStackTrace();
		}
		userRoles = getRoles( user.getRoles() );
	}

	private List<String> getRoles( final Set<Role> roles ) {
		List<String> userRoles = new ArrayList<>();
		for( Role rol : roles ) {
			userRoles.add( rol.getName() );
		}
		return userRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = StringUtils.collectionToCommaDelimitedString( userRoles );
		return AuthorityUtils.commaSeparatedStringToAuthorityList( roles );
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return super.isEnable();
	}

	@Override
	public String getUserId() {
		return super.getId().toString();
	}

}
