package com.conmigo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LegalAdviceController {

    private final static String PAGE = "site.legalAdvice";

    public LegalAdviceController() {
	super();
    }

    @RequestMapping(value = "/legalAdvice", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) final String error) {
	return PAGE;
    }

}
