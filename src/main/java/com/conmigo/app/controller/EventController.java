package com.conmigo.app.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conmigo.app.form.EventForm;
import com.conmigo.app.service.EventService;
import com.conmigo.app.util.ComboUtil;

@Controller
@RequestMapping( "/event" )
public class EventController {

	private final static String PAGE = "site.event";

	@Autowired
	EventService eService;

	@GetMapping( "/create" )
	public String goToCreate( final Model model, final Locale locale ) {
		model.addAttribute( "types", ComboUtil.getEventTypes( locale ) );
		model.addAttribute( "eventForm", new EventForm() );
		return PAGE;
	}

	@PostMapping( value = "/create" )
	public String create( final Model model ) {
		model.addAttribute( "events", eService.findAll() );
		return PAGE;
	}
}
