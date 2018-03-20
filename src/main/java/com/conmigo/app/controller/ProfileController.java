package com.conmigo.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conmigo.app.dto.UserDto;
import com.conmigo.app.service.UserService;
import com.conmigo.app.util.SecurityUtil;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

    private final static String PAGE = "site.profile";

    @Autowired
    UserService uService;

    @GetMapping(value = "/")
    public String access(final Model model) {
	if (SecurityUtil.isFullyAuthenticated()) {
	    final Long idUser = SecurityUtil.getIdUser();
	    final UserDto user = uService.findById(idUser);
	    model.addAttribute("user", user);
	}
	return PAGE;
    }
}
