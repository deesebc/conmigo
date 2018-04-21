package com.conmigo.app.dto;

import java.time.LocalDateTime;

import com.conmigo.app.bbdd.jpa.ChatId;

public class ChatDto extends GenericDto<ChatId> {

    private static final long serialVersionUID = 1L;
    private ChatId id;
    private EventDto event;
    private UserDto userByReceiver;
    private UserDto userBySender;
    private String text;

    public ChatDto() {
    }

    public ChatDto(final ChatId id, final EventDto event, final UserDto userByReceiver, final UserDto userBySender,
            final long createdBy, final LocalDateTime createdDate) {
        this.id = id;
        this.event = event;
        this.userByReceiver = userByReceiver;
        this.userBySender = userBySender;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public ChatDto(final ChatId id, final EventDto event, final UserDto userByReceiver, final UserDto userBySender,
            final String text, final long createdBy, final LocalDateTime createdDate, final Long lastModifiedBy,
            final LocalDateTime lastModifiedDate, final Boolean enable) {
        this.id = id;
        this.event = event;
        this.userByReceiver = userByReceiver;
        this.userBySender = userBySender;
        this.text = text;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.enable = enable;
    }

    @Override
    public ChatId getId() {
        return id;
    }

    @Override
    public void setId(final ChatId id) {
        this.id = id;
    }

    public EventDto getEvent() {
        return event;
    }

    public void setEvent(final EventDto event) {
        this.event = event;
    }

    public UserDto getUserByReceiver() {
        return userByReceiver;
    }

    public void setUserByReceiver(final UserDto userByReceiver) {
        this.userByReceiver = userByReceiver;
    }

    public UserDto getUserBySender() {
        return userBySender;
    }

    public void setUserBySender(final UserDto userBySender) {
        this.userBySender = userBySender;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

}
