package com.conmigo.app.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.conmigo.app.util.Constant;
import com.conmigo.app.util.Constant.Role;

public class RegisterForm {

	@NotBlank
	private String name = "";
	@NotBlank
	private String lastName = "";

	@NotBlank
	@Email
	private String email = "";

	@NotBlank
	private String password = "";

	@NotBlank
	private String repeatPassword = "";

	@NotNull
	private Role role = Constant.Role.USER;

	/**
	 * @return Valor de la propiedad email
	 */
	public String getEmail() {
		return email;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return name;
	}

	/**
	 * @return Valor de la propiedad password
	 */
	public String getPassword() {
		return password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	/**
	 * @return Valor de la propiedad role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param email
	 *            Valor de la propiedad email a setear
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @param password
	 *            Valor de la propiedad password a setear
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	public void setRepeatPassword(final String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	/**
	 * @param role
	 *            Valor de la propiedad role a setear
	 */
	public void setRole(final Role role) {
		this.role = role;
	}

}
