package com.conmigo.app.service;

import com.conmigo.app.bbdd.jpa.Message;
import com.conmigo.app.dto.MessageDto;

public interface MessageService extends GenericBS<MessageDto, Message, Long> {

}
