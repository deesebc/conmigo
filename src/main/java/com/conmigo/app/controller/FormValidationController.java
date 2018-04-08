package com.conmigo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.conmigo.app.service.UserService;

@Controller
@RequestMapping("/form/validate")
public class FormValidationController {

    @Autowired
    UserService uService;

    @PostMapping(value = "/email/exists")
    public @ResponseBody boolean checkEmailExists(@RequestParam("userId") final Long actualId,
            @RequestParam("email") final String email, final Model model) {
        return !uService.existEmail(actualId, email);
    }

    @PostMapping(value = "/username/exists")
    public @ResponseBody boolean checkUsernameExists(@RequestParam("userId") final Long actualId,
            @RequestParam("username") final String username, final Model model) {
        return !uService.existUsername(actualId, username);
    }
}
