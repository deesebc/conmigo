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
    private String repeatPassword = "";

    @NotNull
    private Role role = Constant.Role.USER;

    /**
     * @return Valor de la propiedad email
     */
    public String getEmail() {
	return email;
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

    /**
     * @param password
     *            Valor de la propiedad password a setear
     */
    public void setPassword(final String password) {
	this.password = password;
    }

    public void setRepeatPassword(String repeatPassword) {
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
