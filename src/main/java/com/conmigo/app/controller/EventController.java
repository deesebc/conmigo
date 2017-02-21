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

import com.conmigo.app.dto.EventDto;
import com.conmigo.app.form.EventForm;
import com.conmigo.app.service.EventService;
import com.conmigo.app.util.ComboUtil;

@Controller
@RequestMapping( "/event" )
public class EventController {

	private final static Logger LOGGER = LoggerFactory.getLogger( RegisterController.class );

	private final static String PAGE = "site.event";
	private final static String REDIRECT_EVENT = "redirect:/events";
	private final static String FORWARD_EVENT = "forward:/events";

	@Autowired
	EventService eService;

	@GetMapping( "/create" )
	public String goToCreate( final Model model, final Locale locale ) {
		model.addAttribute( "types", ComboUtil.getEventTypes( locale ) );
		model.addAttribute( "eventForm", new EventForm() );
		return PAGE;
	}

	@PostMapping( value = "/create" )
	public String create( @Valid @ModelAttribute( "eventForm" ) final EventForm eventForm, final BindingResult bindingResult, final Model model ) {
		if( bindingResult.hasErrors() ) {
			return PAGE;
		}
		try {
			EventDto eDto = new EventDto();
			PropertyUtils.copyProperties( eDto, eventForm );
			eService.save( eDto );
		} catch( Exception except ) {
			LOGGER.error( except.getMessage(), except );
		}
		return REDIRECT_EVENT;
	}
}
