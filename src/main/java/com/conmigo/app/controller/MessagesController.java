package com.conmigo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conmigo.app.dto.ChatroomDto;
import com.conmigo.app.service.ChatroomService;
import com.conmigo.app.util.SecurityUtil;

@Controller
@RequestMapping("/messages")
public class MessagesController {

    private final static String PAGE = "site.messages";

    @Autowired
    ChatroomService cService;

    @GetMapping(value = "/")
    public String access(final Model model) {
        Long idUser = SecurityUtil.getIdUser();
        List<ChatroomDto> list = cService.findByUser(idUser);
        model.addAttribute("messages", list);
        return PAGE;
    }

}
