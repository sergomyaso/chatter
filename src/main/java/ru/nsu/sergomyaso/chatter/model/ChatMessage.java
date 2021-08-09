package ru.nsu.sergomyaso.chatter.model;

import org.springframework.data.annotation.Id;

public class ChatMessage {
    @Id
    private String id;

    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public String getStringMessageType() {
        if (type.equals(MessageType.CHAT))
            return "CHAT";
        if (type.equals(MessageType.JOIN))
            return "JOIN";
        return "LEAVE";
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return String.format(
                "{id=%s,sender:'%s',content:'%s',type:'%s'}",
                id, sender, content, getStringMessageType());
    }

}
