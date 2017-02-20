package com.conmigo.app.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.conmigo.app.service.EventService;
import com.conmigo.app.util.ComboUtil;

@Controller
public class EventController {

	private final static String PAGE = "site.events";

	@Autowired
	EventService eService;

	@GetMapping( value = "/event/create" )
	public String home( final Model model, final Locale locale ) {
		model.addAttribute( "types", ComboUtil.getEventTypes( locale ) );
		return PAGE;
	}

	@PostMapping( value = "/events" )
	public String search( final Model model ) {
		model.addAttribute( "events", eService.findAll() );
		return PAGE;
	}
}
