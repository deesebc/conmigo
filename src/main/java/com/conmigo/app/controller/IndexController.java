package com.conmigo.app.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.conmigo.app.bbdd.jpa.Province;
import com.conmigo.app.dto.EventDto;
import com.conmigo.app.service.EventService;
import com.conmigo.app.util.SecurityUtil;

@Controller
public class IndexController {

    @Autowired
    EventService eService;

    @GetMapping(value = "/")
    public String home(final Model model) {
        if (SecurityUtil.isFullyAuthenticated()) {
            PageRequest pageRequest = new PageRequest(0, 10);
            Province province = SecurityUtil.getUserDetails().getProvince();
            Page<EventDto> events = null;
            if (province != null && province.getId() != null) {
                events = eService.findByDateAfterAndProvinceOrderByDateAsc(pageRequest, LocalDateTime.now(), province.getId());
            } else {
                events = eService.findByDateAfterOrderByDateAsc(pageRequest, LocalDateTime.now());
            }
            model.addAttribute("events", events);
        }
        return "site.index";
    }
}
