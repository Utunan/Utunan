package com.utunan.service.community.impl;

import com.utunan.mapper.community.QuizTagMapper;
import com.utunan.pojo.base.community.QuizTag;
import com.utunan.service.community.QuizTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("quizTagService")
public class QuizTagServiceImpl implements QuizTagService {
    @Autowired
    private QuizTagMapper quizTagMapper;

    /**
     * @author  王碧云
     * @description 根据quizId返回标签
     * @date  19:05 2018/11/24
     * @param  quizId
     * @return  java.util.List<com.utunan.pojo.base.community.QuizTag>
     */
    @Override
    public List<QuizTag> findQuizTagByQuizId(Long quizId) {
        return this.quizTagMapper.findQuizTagByQuizId(quizId);
    }
}
