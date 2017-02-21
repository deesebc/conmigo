package com.conmigo.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.conmigo.app.dto.UserDto;
import com.conmigo.app.form.RegisterForm;
import com.conmigo.app.service.UserService;
import com.conmigo.app.util.SecurityUtil;

@Controller
public class RegisterController {

	private final static Logger LOGGER = LoggerFactory.getLogger( RegisterController.class );

	private final static String REDIRECT_INDEX = "redirect:/";
	private final static String PAGE = "site.register";

	@Autowired
	private UserService uService;

	@Autowired
	private AuthenticationManager authenticationManager;

	public RegisterController() {
		super();
	}

	@GetMapping( value = "/register" )
	public String login( final Model model ) {
		String retorno = PAGE;
		if( SecurityUtil.isFullyAuthenticated() ) {
			retorno = REDIRECT_INDEX;
		}
		model.addAttribute( "registerForm", new RegisterForm() );
		return retorno;
	}

	@PostMapping( value = "/register" )
	public String handleUserCreateForm( @Valid @ModelAttribute( "registerForm" ) final RegisterForm form, final BindingResult bindingResult, final HttpServletRequest request ) {
		if( bindingResult.hasErrors() ) {
			return PAGE;
		}
		try {
			UserDto uDto = new UserDto();
			uDto.setEnable( true );
			PropertyUtils.copyProperties( uDto, form );
			uService.save( uDto );
			authenticateUserAndSetSession( uDto, request );
		} catch( DataIntegrityViolationException e ) {
			bindingResult.reject( "email.exists", "Email already exists" );
			return PAGE;
		} catch( Exception except ) {
			LOGGER.error( except.getMessage(), except );
		}
		return "redirect:/events/";
	}

	private void authenticateUserAndSetSession( final UserDto user, final HttpServletRequest request ) {
		String username = user.getEmail();
		String password = user.getPassword();
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken( username, password );

		// generate session if one doesn't exist
		request.getSession();

		token.setDetails( new WebAuthenticationDetails( request ) );
		Authentication authenticatedUser = authenticationManager.authenticate( token );

		SecurityContextHolder.getContext().setAuthentication( authenticatedUser );
	}
}
