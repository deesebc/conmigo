package com.conmigo.app.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.conmigo.app.dto.EventDto;
import com.conmigo.app.dto.ProvinceDto;
import com.conmigo.app.dto.UserDto;
import com.conmigo.app.form.EventForm;
import com.conmigo.app.service.EventService;
import com.conmigo.app.service.ProvinceService;
import com.conmigo.app.util.ComboUtil;
import com.conmigo.app.util.SecurityUtil;

@Controller
@RequestMapping("/event")
public class EventController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    private final static String PAGE = "site.event";
    private final static String REDIRECT_EVENT = "redirect:/events/";
    private final static String FORWARD_EVENT = "forward:/events/";

    @Autowired
    EventService eService;

    @Autowired
    ProvinceService pService;

    @ModelAttribute("typeList")
    public Map<String, String> populateTypess(final Locale locale) {
        return ComboUtil.getEventTypes(locale);
    }

    @ModelAttribute("provinceList")
    public List<ProvinceDto> populateProvinces() {
        return pService.findAll();
    }

    @GetMapping("/create")
    public String goToCreate(final Model model, final Locale locale) {
        model.addAttribute("eventForm", new EventForm());
        return PAGE;
    }

    @PostMapping(value = "/create", params = "pass")
    public String createAndPass(@Valid @ModelAttribute("eventForm") final EventForm eventForm, final BindingResult bindingResult,
            final Model model, final Locale locale) {
        return createEvent(eventForm, bindingResult, model, locale, false);
    }

    @PostMapping(value = "/create", params = "join")
    public String createAndJoin(@Valid @ModelAttribute("eventForm") final EventForm eventForm, final BindingResult bindingResult,
            final Model model, final Locale locale) {
        return createEvent(eventForm, bindingResult, model, locale, true);
    }

    private String createEvent(final EventForm eventForm, final BindingResult bindingResult, final Model model,
            final Locale locale, final Boolean join) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("types", ComboUtil.getEventTypes(locale));
            return PAGE;
        }
        try {
            EventDto eDto = new EventDto();
            // PropertyUtils.copyProperties(eDto, eventForm);
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(eventForm, eDto);
            if (join) {
                eDto.getUsers().add(new UserDto(SecurityUtil.getIdUser()));
            }
            eService.save(eDto);
        } catch (Exception except) {
            LOGGER.error(except.getMessage(), except);
        }
        return REDIRECT_EVENT;
    }

    @PostMapping(value = "/")
    public String view(@RequestParam("id") final Long id, final Model model) {
        return viewAndJoin(id, model, false);
    }

    @PostMapping(value = "/join")
    public String join(@RequestParam("id") final Long id, final Model model) {
        return viewAndJoin(id, model, true);
    }

    @PostMapping(value = "/disjoin")
    public String disjoin(@RequestParam("id") final Long id, final Model model) {
        EventDto eDto = eService.findById(id);
        eDto.getUsers().remove(new UserDto(SecurityUtil.getIdUser()));
        eDto = eService.save(eDto);
        return REDIRECT_EVENT;
    }

    private String viewAndJoin(final Long id, final Model model, final Boolean join) {
        EventDto eDto = eService.findById(id);
        if (join) {
            eDto.getUsers().add(new UserDto(SecurityUtil.getIdUser()));
            eDto = eService.save(eDto);
        }
        model.addAttribute("event", eDto);
        return PAGE;
    }
}
