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
import com.conmigo.app.dto.ChatroomDto;
import com.conmigo.app.dto.EventDto;
import com.conmigo.app.dto.UserDto;
import com.conmigo.app.service.ChatService;
import com.conmigo.app.service.ChatroomService;
import com.conmigo.app.util.SecurityUtil;
import com.conmigo.app.vo.ChatRoomVo;

@Controller
@RequestMapping("/chatroom")
public class ChatRoomController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ChatRoomController.class);

    private final static String PAGE = "site.chatroom";

    @Autowired
    private ChatService cService;

    @Autowired
    private ChatroomService crService;

    @PostMapping("/")
    public String view(@ModelAttribute("chatroom") final ChatRoomVo chatroom, final Model model) {
        LOGGER.info("ChatRoom - view");
        Long idUser = SecurityUtil.getIdUser();
        Long chatroomId = getHash(chatroom.getEventId(), chatroom.getReceiverId(), idUser);
        createChatroom(chatroomId, chatroom.getEventId(), chatroom.getReceiverId(), idUser);
        List<ChatDto> list = cService.findAll();
        model.addAttribute("messages", list);
        model.addAttribute("receiverId", chatroom.getReceiverId());
        model.addAttribute("eventId", chatroom.getEventId());
        model.addAttribute("senderId", idUser);
        model.addAttribute("chatroomId", chatroomId);
        return PAGE;
    }

    private void createChatroom(final Long chatroomId, final Long eventId, final Long component1Id, final Long component2Id) {
        ChatroomDto cRoomDto = crService.findById(chatroomId);
        if (cRoomDto == null) {
            cRoomDto = new ChatroomDto();
            cRoomDto.setId(chatroomId);
            UserDto sender = new UserDto(component1Id);
            cRoomDto.setUserByComponent1(sender);
            UserDto receiver = new UserDto(component2Id);
            cRoomDto.setUserByComponent2(receiver);
            EventDto event = new EventDto();
            event.setId(eventId);
            cRoomDto.setEvent(event);
            cRoomDto = crService.save(cRoomDto);
        }
    }

    private Long getHash(final Long eventId, final Long receiverId, final Long userId) {
        String exit = eventId + "#";
        if (receiverId < userId) {
            exit += receiverId + "#" + userId;
        } else {
            exit += userId + "#" + receiverId;
        }
        return (long) exit.hashCode();
    }

}