package com.conmigo.app.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ChatroomDto extends GenericDto<Long> {

    private static final long serialVersionUID = 1L;
    private Long id;
    private EventDto event;
    private UserDto userByComponent1;
    private UserDto userByComponent2;
    private Set<MessageDto> messages = new HashSet<>(0);

    public ChatroomDto() {
    }

    public ChatroomDto(final Long id, final EventDto event, final UserDto userByComponent1, final UserDto userByComponent2,
            final long createdBy, final LocalDateTime createdDate) {
        this.id = id;
        this.event = event;
        this.userByComponent1 = userByComponent1;
        this.userByComponent2 = userByComponent2;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public ChatroomDto(final Long id, final EventDto event, final UserDto userByComponent1, final UserDto userByComponent2,
            final long createdBy, final LocalDateTime createdDate, final Long lastModifiedBy,
            final LocalDateTime lastModifiedDate, final Boolean enable, final Set<MessageDto> messages) {
        this.id = id;
        this.event = event;
        this.userByComponent1 = userByComponent1;
        this.userByComponent2 = userByComponent2;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.enable = enable;
        this.messages = messages;
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

    public UserDto getUserByComponent1() {
        return userByComponent1;
    }

    public void setUserByComponent1(final UserDto userByComponent1) {
        this.userByComponent1 = userByComponent1;
    }

    public UserDto getUserByComponent2() {
        return userByComponent2;
    }

    public void setUserByComponent2(final UserDto userByComponent2) {
        this.userByComponent2 = userByComponent2;
    }

    public Set<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(final Set<MessageDto> messages) {
        this.messages = messages;
    }

}
