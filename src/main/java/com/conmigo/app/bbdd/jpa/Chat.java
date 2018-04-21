package com.conmigo.app.bbdd.jpa;
// Generated Apr 21, 2018 8:15:12 AM by Hibernate Tools 5.2.8.Final

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Chat generated by hbm2java
 */
@Entity
@Table(name = "chat", catalog = "conmigodb")
public class Chat extends GenericEntity<ChatId> {

    private static final long serialVersionUID = 1L;
    private ChatId id;
    private Event event;
    private User userByReceiver;
    private User userBySender;
    private String text;

    public Chat() {
    }

    public Chat(final ChatId id, final Event event, final User userByReceiver, final User userBySender, final long createdBy,
            final LocalDateTime createdDate) {
        this.id = id;
        this.event = event;
        this.userByReceiver = userByReceiver;
        this.userBySender = userBySender;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public Chat(final ChatId id, final Event event, final User userByReceiver, final User userBySender, final String text,
            final long createdBy, final LocalDateTime createdDate, final Long lastModifiedBy,
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
    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "event", column = @Column(name = "EVENT", nullable = false)),
            @AttributeOverride(name = "sender", column = @Column(name = "SENDER", nullable = false)),
            @AttributeOverride(name = "receiver", column = @Column(name = "RECEIVER", nullable = false)),
            @AttributeOverride(name = "date", column = @Column(name = "DATE", nullable = false, length = 19)) })
    public ChatId getId() {
        return id;
    }

    @Override
    public void setId(final ChatId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT", nullable = false, insertable = false, updatable = false)
    public Event getEvent() {
        return event;
    }

    public void setEvent(final Event event) {
        this.event = event;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECEIVER", nullable = false, insertable = false, updatable = false)
    public User getUserByReceiver() {
        return userByReceiver;
    }

    public void setUserByReceiver(final User userByReceiver) {
        this.userByReceiver = userByReceiver;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SENDER", nullable = false, insertable = false, updatable = false)
    public User getUserBySender() {
        return userBySender;
    }

    public void setUserBySender(final User userBySender) {
        this.userBySender = userBySender;
    }

    @Column(name = "TEXT", length = 65535)
    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

}
