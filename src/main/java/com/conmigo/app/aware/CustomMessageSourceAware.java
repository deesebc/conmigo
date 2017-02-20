package com.conmigo.app.aware;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public final class CustomMessageSourceAware implements MessageSourceAware {

	private static MessageSource messageSource;

	@Override
	public void setMessageSource( final MessageSource messageSource ) {
		CustomMessageSourceAware.messageSource = messageSource;
	}

	public static String getMessage( final String message, final Object[] args, final Locale locale ) {
		return messageSource.getMessage( message, args, locale );
	}

}
