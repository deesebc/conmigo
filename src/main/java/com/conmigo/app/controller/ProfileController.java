package com.conmigo.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conmigo.app.dto.ComboDto;
import com.conmigo.app.dto.CustomUserDetails;
import com.conmigo.app.dto.ProvinceDto;
import com.conmigo.app.dto.UserDto;
import com.conmigo.app.form.ProfileForm;
import com.conmigo.app.service.ComboService;
import com.conmigo.app.service.ProvinceService;
import com.conmigo.app.service.UserService;
import com.conmigo.app.util.Constant;
import com.conmigo.app.util.SecurityUtil;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

    private final static String PAGE = "site.profile";
    private final static String REDIRECT_INDEX = "redirect:/";

    @Autowired
    UserService uService;

    @Autowired
    ComboService cService;

    @Autowired
    ProvinceService pService;

    @ModelAttribute("genderList")
    public List<ComboDto> populateGenders() {
        return cService.getCombosByType(Constant.Combo.GENDER.name());
    }

    @ModelAttribute("provinceList")
    public List<ProvinceDto> populateProvinces() {
        return pService.findAll();
    }

    @GetMapping(value = "/")
    public String access(final Model model) {
        try {
            if (SecurityUtil.isFullyAuthenticated()) {
                final CustomUserDetails user = SecurityUtil.getUserDetails();
                ModelMapper modelMapper = new ModelMapper();
                ProfileForm form = modelMapper.map(user, ProfileForm.class);
                model.addAttribute("profileForm", form);
            }
        } catch (final Exception except) {
            LOGGER.error(except.getMessage(), except);
        }
        return PAGE;
    }

    @PostMapping(value = "/")
    public String update2(@Valid @ModelAttribute("profileForm") final ProfileForm profileForm, final BindingResult bindingResult,
            final Model model) {
        try {
            if (bindingResult.hasErrors()) {
                return PAGE;
            }
            CustomUserDetails user = SecurityUtil.getUserDetails();
            UserDto uDto = uService.findById(SecurityUtil.getIdUser());
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(profileForm, uDto);
            UserDto userSaved = uService.save(uDto);
            user = modelMapper.map(userSaved, CustomUserDetails.class);
            modelMapper.map(userSaved, user);
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(),
                    user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (final Exception except) {
            LOGGER.error(except.getMessage(), except);
        }
        return REDIRECT_INDEX;
    }

}
