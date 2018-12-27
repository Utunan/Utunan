package com.utunan.service.community;

import com.utunan.pojo.base.community.AnswerGreat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/8 17:13
 */
public interface AnswerGreatService {

    //查询AnswerGreat表中信息
    AnswerGreat getAnswerGreat(Long answerId, Long userId);

    //插入AnswerGreat表中信息
    void addAnswerGreat(Long answerId, Long userId);

    //删除AnswerGreat表中信息
    void delAnswerGreat(Long answerId, Long userId);

    //获取用户在评论的点赞列表
    List<Long> getAGList(Long userId);
}
