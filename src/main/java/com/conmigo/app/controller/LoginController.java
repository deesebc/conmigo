package com.conmigo.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private final static Logger LOGGER = LoggerFactory.getLogger( LoginController.class );

	private final static String REDIRECT_INDEX = "redirect:/";
	private final static String RDT_INTERES = "redirect:/interes";
	private final static String RDT_INTERES_WTO_DISCOURSE = "redirect:/interes?error_discourse=1";

	public LoginController() {
		super();
	}

	@RequestMapping( value = "/login", method = RequestMethod.GET )
	public String login( @RequestParam( value = "error", required = false ) final String error ) {
		String retorno = "site.login";
		// if( SecurityUtil.isFullyAuthenticated() ) {
		// retorno = REDIRECT_INDEX;
		// }

		return retorno;
	}

	@RequestMapping( value = "/logout", method = RequestMethod.GET )
	public String logout( final HttpServletRequest request, final HttpServletResponse response ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( auth != null ) {
			new SecurityContextLogoutHandler().logout( request, response, auth );
		}
		return REDIRECT_INDEX;
	}

}
