package com.conmigo.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    private static final String PAGE = "site.error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    public ModelAndView error(final WebRequest request, final HttpServletResponse response) {
        Map<String, Object> mapa = getErrorAttributes(request, true);
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorstatus", response.getStatus());
        mav.addObject("errorCode", mapa.get("error"));
        mav.addObject("errorMessage", mapa.get("message"));
        mav.addObject("errorTrace", mapa.get("trace"));
        mav.setViewName(PAGE);
        return mav;
    }

    private Map<String, Object> getErrorAttributes(final WebRequest request, final boolean includeStackTrace) {
        return errorAttributes.getErrorAttributes(request, includeStackTrace);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
