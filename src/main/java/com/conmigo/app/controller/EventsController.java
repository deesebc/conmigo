package com.conmigo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.conmigo.app.service.EventService;

@Controller
public class EventsController {

	private final static String PAGE = "site.events";

	@Autowired
	EventService eService;

	@GetMapping( value = "/events" )
	public String home( final Model model ) {
		model.addAttribute( "events", eService.findAll() );
		return PAGE;
	}
}
