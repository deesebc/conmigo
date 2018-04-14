package com.conmigo.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.conmigo.app.dto.EventDto;
import com.conmigo.app.service.EventService;
import com.conmigo.app.service.UserService;
import com.conmigo.app.util.SecurityUtil;

@Controller
@RequestMapping("/events")
public class EventsController {

    private final static String PAGE = "site.events";

    @Autowired
    EventService eService;

    @Autowired
    UserService uService;

    @GetMapping(value = "/")
    public String access(final Model model) {
        return accessPage(0, model);
    }

    @GetMapping(value = "/{page}")
    public String accessPage(@PathVariable final Integer page, final Model model) {
        int iPage = page == null ? 0 : page;
        PageRequest pageRequest = new PageRequest(iPage, 2);
        // Page<EventDto> events = eService.findByDateAfter(pageRequest, LocalDateTime.now());
        Page<EventDto> events = eService.getPage(pageRequest);
        model.addAttribute("events", events);
        obtainUserEvents(model);
        return PAGE;
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam("name") final String name, final Model model) {
        // obtenemos los eventos
        Page<EventDto> events;
        PageRequest pageRequest = new PageRequest(0, 10);
        if (StringUtils.isNotBlank(name)) {
            events = eService.findByNameContainingIgnoreCaseAndDateAfter(pageRequest, name, LocalDateTime.now());
        } else {
            events = eService.findByDateAfter(pageRequest, LocalDateTime.now());
        }
        model.addAttribute("events", events);
        obtainUserEvents(model);
        return PAGE;
    }

    private void obtainUserEvents(final Model model) {
        // obtenemos los eventos del usuario
        if (SecurityUtil.isFullyAuthenticated()) {
            Long idUser = SecurityUtil.getIdUser();
            List<Long> userEvents = uService.getEventIdsByUser(idUser);
            model.addAttribute("userEvents", userEvents);
        }
    }

}
