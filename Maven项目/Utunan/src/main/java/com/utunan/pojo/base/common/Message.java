package com.utunan.pojo.base.common;

import com.utunan.pojo.base.user.User;

public class Message {
    private Long messageId;
    private User sendUser;
    private String messageType;
    private User receiveUser;
    private String messageContent;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public User getSendUser() {
        return sendUser;
    }

    public void setSendUser(User sendUser) {
        this.sendUser = sendUser;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public User getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(User receiveUser) {
        this.receiveUser = receiveUser;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", sendUser=" + sendUser +
                ", messageType='" + messageType + '\'' +
                ", receiveUser=" + receiveUser +
                ", messageContent='" + messageContent + '\'' +
                '}';
    }
}
