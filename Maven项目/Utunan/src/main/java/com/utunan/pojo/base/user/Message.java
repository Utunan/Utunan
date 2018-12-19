package com.utunan.pojo.base.user;

import java.util.Date;

public class Message {
    private Long messageId;
    private User receiveUser;
    private User sendUser;
    private String messageType;
    private String messageContent;
    private Date messageTime;
    private String isView;
    private Long quizId;

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", receiveUser=" + receiveUser +
                ", sendUser=" + sendUser +
                ", messageType='" + messageType + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageTime=" + messageTime +
                ", isView='" + isView + '\'' +
                ", quizId=" + quizId +
                '}';
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getIsView() {
        return isView;
    }

    public void setIsView(String isView) {
        this.isView = isView;
    }

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

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
}
