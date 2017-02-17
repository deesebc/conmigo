package com.conmigo.app.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.conmigo.app.bbdd.jpa.User;

public class CustomUserDetails implements UserDetails {

	/**
	 * Descripcion del campo
	 */
	private static final long serialVersionUID = 4454136926840298913L;

	private Integer id;
	private String name;
	private String surname;
	private String lastname;
	private String email;
	private List<String> userRoles;

	public CustomUserDetails() {
		super();
	}

	public CustomUserDetails( final User user, final List<String> userRoles ) {
		id = user.getId();
		name = user.getName();
		surname = user.getSurname();
		lastname = user.getLastname();
		email = user.getEmail();
		this.userRoles = userRoles;
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
		return true;
	}

	@Override
	public String getUsername() {
		return getName();
	}

	/**
	 * @return Valor de la propiedad id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            Valor de la propiedad id a setear
	 */
	public void setId( final Integer id ) {
		this.id = id;
	}

	/**
	 * @return Valor de la propiedad name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Valor de la propiedad name a setear
	 */
	public void setName( final String name ) {
		this.name = name;
	}

	/**
	 * @return Valor de la propiedad surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            Valor de la propiedad surname a setear
	 */
	public void setSurname( final String surname ) {
		this.surname = surname;
	}

	/**
	 * @return Valor de la propiedad lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            Valor de la propiedad lastname a setear
	 */
	public void setLastname( final String lastname ) {
		this.lastname = lastname;
	}

	/**
	 * @return Valor de la propiedad email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            Valor de la propiedad email a setear
	 */
	public void setEmail( final String email ) {
		this.email = email;
	}

	/**
	 * @return Valor de la propiedad userRoles
	 */
	public List<String> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles
	 *            Valor de la propiedad userRoles a setear
	 */
	public void setUserRoles( final List<String> userRoles ) {
		this.userRoles = userRoles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
