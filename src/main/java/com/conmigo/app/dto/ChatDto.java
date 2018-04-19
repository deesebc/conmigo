package com.conmigo.app.dto;

import java.time.LocalDateTime;

public class ChatDto extends GenericDto<Long> {
    private static final long serialVersionUID = 1L;
    private Long id;
    private EventDto event;
    private UserDto userBySender;
    private UserDto userByReceiver;
    private String text;
    private LocalDateTime date;

    public ChatDto() {
    }

    public ChatDto(final EventDto event, final UserDto userBySender, final UserDto userByReceiver, final long createdBy,
            final LocalDateTime createdDate) {
        this.event = event;
        this.userBySender = userBySender;
        this.userByReceiver = userByReceiver;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public ChatDto(final EventDto event, final UserDto userBySender, final UserDto userByReceiver, final String text,
            final LocalDateTime date, final long createdBy, final LocalDateTime createdDate, final Long lastModifiedBy,
            final LocalDateTime lastModifiedDate, final Boolean enable) {
        this.event = event;
        this.userBySender = userBySender;
        this.userByReceiver = userByReceiver;
        this.text = text;
        this.date = date;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.enable = enable;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    public EventDto getEvent() {
        return event;
    }

    public void setEvent(final EventDto event) {
        this.event = event;
    }

    public UserDto getUserBySender() {
        return userBySender;
    }

    public void setUserBySender(final UserDto userBySender) {
        this.userBySender = userBySender;
    }

    public UserDto getUserByReceiver() {
        return userByReceiver;
    }

    public void setUserByReceiver(final UserDto userByReceiver) {
        this.userByReceiver = userByReceiver;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(final LocalDateTime date) {
        this.date = date;
    }

}
