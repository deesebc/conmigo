package com.conmigo.app.controller;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conmigo.app.dto.ComboDto;
import com.conmigo.app.dto.UserDto;
import com.conmigo.app.form.ProfileForm;
import com.conmigo.app.service.ComboService;
import com.conmigo.app.service.UserService;
import com.conmigo.app.util.Constant;
import com.conmigo.app.util.SecurityUtil;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

    private final static String PAGE = "site.profile";

    @Autowired
    UserService uService;

    @Autowired
    ComboService cService;

    @ModelAttribute("genderList")
    public List<ComboDto> populateDepartments() {
        return cService.getCombosByType(Constant.Combo.GENDER.name());
    }

    @GetMapping(value = "/")
    public String access(final Model model) {
        try {
            if (SecurityUtil.isFullyAuthenticated()) {
                final Long idUser = SecurityUtil.getIdUser();
                final UserDto user = uService.findById(idUser);
                final ProfileForm form = new ProfileForm();
                PropertyUtils.copyProperties(form, user);
                model.addAttribute("form", form);
            }
        } catch (final Exception except) {
            LOGGER.error(except.getMessage(), except);
        }
        return PAGE;
    }
}
