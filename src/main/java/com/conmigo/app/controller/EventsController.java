package com.conmigo.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conmigo.app.dto.EventDto;
import com.conmigo.app.service.EventService;

@Controller
@RequestMapping( "/events" )
public class EventsController {

	private final static String PAGE = "site.events";

	@Autowired
	EventService eService;

	@GetMapping( value = "/" )
	public String access( final Model model ) {
		model.addAttribute( "events", eService.findAll() );
		return PAGE;
	}

	@PostMapping( value = "/search" )
	public String search( final HttpServletRequest request, final Model model ) {
		String name = request.getParameter( "name" );
		PageRequest pageRequest = new PageRequest( 0, 10 );
		Page<EventDto> page = eService.findByNameContainingIgnoreCase( pageRequest, name );
		model.addAttribute( "events", page.getContent() );
		return PAGE;
	}

}
