package com.utunan.service.user.impl;

import com.utunan.mapper.user.MessageMapper;
import com.utunan.pojo.base.user.Message;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("MessageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    //获得最大messageId
    @Override
    public Long getMaxMid() {
        return messageMapper.getMaxMid();
    }


    @Override
    public void saveMessage(Long mid, User receiveUser, User sendUser,Long quizId, String messageType, String messageContent, String isView) {
        Message message=new Message();
        message.setMessageId(mid);
        message.setReceiveUser(receiveUser);
        message.setSendUser(sendUser);
        message.setMessageType(messageType);
        message.setIsView(isView);
        message.setMessageContent(messageContent);
        message.setMessageTime(new Date());
        message.setQuizId(quizId);
        message.setMessageTitle("咚咚，您有新的消息！");
        messageMapper.saveMessage(message);
    }
}
