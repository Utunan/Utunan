package com.utunan.service.user;

import com.utunan.pojo.base.user.User;

public interface MessageService {
    //获得最大的messgaeId
    Long getMaxMid();

    //向message表插入内容
    void saveMessage(Long mid, User receiveUser, User sendUser,Long quizId, String messageType, String messageContent, String isView);
}
