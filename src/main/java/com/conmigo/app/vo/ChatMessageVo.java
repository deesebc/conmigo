package com.conmigo.app.vo;

public class ChatMessageVo {
    private String message;
    private Long event;
    private Long receiver;

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Long getEvent() {
        return event;
    }

    public void setEvent(final Long event) {
        this.event = event;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(final Long receiver) {
        this.receiver = receiver;
    }

}
