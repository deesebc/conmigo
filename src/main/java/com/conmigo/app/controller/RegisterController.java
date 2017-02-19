package com.conmigo.app.controller;

import javax.validation.Valid;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	public String handleUserCreateForm( @Valid @ModelAttribute( "form" ) final RegisterForm form, final BindingResult bindingResult ) {
		if( bindingResult.hasErrors() ) {
			return PAGE;
		}
		try {
			UserDto uDto = new UserDto();
			PropertyUtils.copyProperties( uDto, form );
			uService.save( uDto );
		} catch( DataIntegrityViolationException e ) {
			bindingResult.reject( "email.exists", "Email already exists" );
			return PAGE;
		} catch( Exception except ) {
			LOGGER.error( except.getMessage(), except );
		}
		return "redirect:/events";
	}
}
