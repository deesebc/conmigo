package com.conmigo.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conmigo.app.dto.ChatDto;
import com.conmigo.app.service.ChatService;
import com.conmigo.app.util.SecurityUtil;
import com.conmigo.app.vo.ChatRoomVo;

@Controller
@RequestMapping("/chatroom")
public class ChatRoomController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ChatRoomController.class);

    private final static String PAGE = "site.chatroom";

    @Autowired
    private ChatService cService;

    @PostMapping("/")
    public String view(@ModelAttribute("chatroom") final ChatRoomVo chatroom, final Model model) {
        LOGGER.info("ChatRoom - view");
        // Long idUser = SecurityUtil.getIdUser();
        List<ChatDto> list = cService.findAll();
        model.addAttribute("messages", list);
        model.addAttribute("receiverId", chatroom.getReceiverId());
        model.addAttribute("eventId", chatroom.getEventId());
        model.addAttribute("senderId", SecurityUtil.getIdUser());
        return PAGE;
    }

}