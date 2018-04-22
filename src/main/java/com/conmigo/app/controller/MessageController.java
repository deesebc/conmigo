package com.conmigo.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conmigo.app.service.MessageService;
import com.conmigo.app.vo.NewMessageVo;

@Controller
@RequestMapping("/message")
public class MessageController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    MessageService mService;

    @PostMapping(value = "/")
    public ResponseEntity<String> view(@RequestBody final NewMessageVo message, final Model model) {
        ResponseEntity<String> retorno = new ResponseEntity<>(HttpStatus.OK);
        try {
        } catch (Exception except) {
            LOGGER.error(except.getMessage(), except);
            retorno = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return retorno;
    }

}
