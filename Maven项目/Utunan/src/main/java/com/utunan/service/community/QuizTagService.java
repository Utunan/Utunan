package com.utunan.service.community;

import com.utunan.pojo.base.community.QuizTag;

import java.util.List;

public interface QuizTagService {

    /**
     * @author  王碧云
     * @description 根据quizId查找标签
     * @date  18:58 2018/11/24
     * @param  quizId
     * @return  com.utunan.pojo.base.community.QuizTag
     */
    List<QuizTag> findQuizTagByQuizId(Long quizId);


    /*
     * @author  张正扬
     * @description 存入问题标签
     * @date  9:03 2018/12/6
     * @param  Long,List<Long>
     * @return  void
     */
    void saveQuizTag(Long quizId,List<Long> tagss);

}
