package com.conmigo.app.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.conmigo.app.dto.EventDto;
import com.conmigo.app.dto.UserDto;
import com.conmigo.app.form.EventForm;
import com.conmigo.app.service.EventService;
import com.conmigo.app.util.ComboUtil;
import com.conmigo.app.util.SecurityUtil;

@Controller
@RequestMapping( "/event" )
public class EventController {

	private final static Logger LOGGER = LoggerFactory.getLogger( RegisterController.class );

	private final static String PAGE = "site.event";
	private final static String REDIRECT_EVENT = "redirect:/events/";
	private final static String FORWARD_EVENT = "forward:/events/";

	@Autowired
	EventService eService;

	@GetMapping( "/create" )
	public String goToCreate( final Model model, final Locale locale ) {
		model.addAttribute( "types", ComboUtil.getEventTypes( locale ) );
		model.addAttribute( "eventForm", new EventForm() );
		return PAGE;
	}

	@PostMapping( value = "/create", params = "pass" )
	public String createAndPass( @Valid @ModelAttribute( "eventForm" ) final EventForm eventForm, final BindingResult bindingResult, final Model model ) {
		return createEvent( eventForm, bindingResult, false );
	}

	@PostMapping( value = "/create", params = "join" )
	public String createAndJoin( @Valid @ModelAttribute( "eventForm" ) final EventForm eventForm, final BindingResult bindingResult, final Model model ) {
		return createEvent( eventForm, bindingResult, true );
	}

	private String createEvent( final EventForm eventForm, final BindingResult bindingResult, final Boolean join ) {
		if( bindingResult.hasErrors() ) {
			return PAGE;
		}
		try {
			EventDto eDto = new EventDto();
			PropertyUtils.copyProperties( eDto, eventForm );
			if( join ) {
				eDto.getUsers().add( new UserDto( SecurityUtil.getIdUser() ) );
			}
			eService.save( eDto );
		} catch( Exception except ) {
			LOGGER.error( except.getMessage(), except );
		}
		return REDIRECT_EVENT;
	}

	@PostMapping( value = "/" )
	public String view( @RequestParam( "id" ) final Long id, final Model model ) {
		viewEvent( id, model, false );
		return PAGE;
	}

	@PostMapping( value = "/join" )
	public String join( @RequestParam( "id" ) final Long id, final Model model ) {
		viewEvent( id, model, true );
		return PAGE;
	}

	private void viewEvent( final Long id, final Model model, final Boolean join ) {
		try {
			EventDto eDto = eService.findById( id );
			if( join ) {
				eDto.getUsers().add( new UserDto( SecurityUtil.getIdUser() ) );
				eDto = eService.save( eDto );
			}
			EventForm eventForm = new EventForm();
			PropertyUtils.copyProperties( eventForm, eDto );
			model.addAttribute( "eventForm", eventForm );
		} catch( Exception except ) {
			LOGGER.error( except.getMessage(), except );
		}
	}
}
