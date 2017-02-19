package com.conmigo.app.dto;

import java.io.Serializable;

public abstract class GenericDto<K extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract K getId();

	public abstract void setId( K id );

}
