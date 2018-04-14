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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conmigo.app.dto.EventDto;
import com.conmigo.app.form.EventSearchForm;
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
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<EventDto> events = eService.findByDateAfter(pageRequest, LocalDateTime.now());
        model.addAttribute("events", events);
        model.addAttribute("eventSearchForm", new EventSearchForm());
        obtainUserEvents(model);
        return PAGE;
    }

    @PostMapping(value = "/search")
    public String search(@ModelAttribute("eventSearchForm") final EventSearchForm eventSearchForm, final Model model) {
        Page<EventDto> events;
        PageRequest pageRequest = new PageRequest(eventSearchForm.getPage(), 2);
        if (StringUtils.isNotBlank(eventSearchForm.getName())) {
            events = eService.findByNameContainingIgnoreCaseAndDateAfter(pageRequest, eventSearchForm.getName(),
                    LocalDateTime.now());
        } else {
            events = eService.findByDateAfter(pageRequest, LocalDateTime.now());
        }
        model.addAttribute("events", events);
        model.addAttribute("eventSearchForm", eventSearchForm);
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
