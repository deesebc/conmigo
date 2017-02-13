package com.conmigo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	private final static int HIGHLIGHT_ELEMENTS = 3;

	@GetMapping( value = "/" )
	public String home( final Model model ) {
		return "site.index";
	}
}
