package com.utunan.service.community.impl;

import com.utunan.mapper.community.AnswerGreatMapper;
import com.utunan.pojo.base.community.AnswerGreat;
import com.utunan.service.community.AnswerGreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/8 17:17
 */
@Service("AnswerGreatService")
public class AnswerGreatServiceImpl implements AnswerGreatService {
    @Autowired
    private AnswerGreatMapper answerGreatMapper;
    @Override
    public AnswerGreat getAnswerGreat(Long answerId, Long userId) {
        return answerGreatMapper.getAnswerGreat(answerId,userId);
    }

    @Override
    public void addAnswerGreat(Long answerId, Long userId) {
        answerGreatMapper.addAnswerGreat(answerId,userId);
    }

    @Override
    public void delAnswerGreat(Long answerId, Long userId) {
        answerGreatMapper.delAnswerGreat(answerId,userId);
    }
}
