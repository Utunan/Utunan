package com.utunan.mapper.user;

import com.utunan.pojo.base.user.Message;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    //获得最大的messageId
    Long getMaxMid();

    //向message表中存入信息
    void saveMessage(Message message);
}
