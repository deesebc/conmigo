package com.conmigo.app.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.conmigo.app.util.Constant;
import com.conmigo.app.util.Constant.Role;

public class RegisterForm {

	@NotEmpty
	private String email = "";

	@NotEmpty
	private String password = "";

	@NotEmpty
	private String passwordRepeated = "";

	@NotNull
	private Role role = Constant.Role.USER;

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
	 * @return Valor de la propiedad password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            Valor de la propiedad password a setear
	 */
	public void setPassword( final String password ) {
		this.password = password;
	}

	/**
	 * @return Valor de la propiedad passwordRepeated
	 */
	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	/**
	 * @param passwordRepeated
	 *            Valor de la propiedad passwordRepeated a setear
	 */
	public void setPasswordRepeated( final String passwordRepeated ) {
		this.passwordRepeated = passwordRepeated;
	}

	/**
	 * @return Valor de la propiedad role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            Valor de la propiedad role a setear
	 */
	public void setRole( final Role role ) {
		this.role = role;
	}

}
