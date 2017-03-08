package com.conmigo.app.vo;

public class NewMessageVo {

	private String userIdMessageFrom;
	private String userIdMessageTo;
	private String message;

	/**
	 * @return Valor de la propiedad userIdMessageFrom
	 */
	public String getUserIdMessageFrom() {
		return userIdMessageFrom;
	}

	/**
	 * @param userIdMessageFrom
	 *            Valor de la propiedad userIdMessageFrom a setear
	 */
	public void setUserIdMessageFrom( final String userIdMessageFrom ) {
		this.userIdMessageFrom = userIdMessageFrom;
	}

	/**
	 * @return Valor de la propiedad userIdMessageTo
	 */
	public String getUserIdMessageTo() {
		return userIdMessageTo;
	}

	/**
	 * @param userIdMessageTo
	 *            Valor de la propiedad userIdMessageTo a setear
	 */
	public void setUserIdMessageTo( final String userIdMessageTo ) {
		this.userIdMessageTo = userIdMessageTo;
	}

	/**
	 * @return Valor de la propiedad message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            Valor de la propiedad message a setear
	 */
	public void setMessage( final String message ) {
		this.message = message;
	}

}
