package com.utunan.service.community;

import com.utunan.pojo.community.QuizTag;
import com.utunan.pojo.community.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuizTagService {

    /*
     * @author  王碧云
     * @description 根据quizId查找标签
     * @date  18:58 2018/11/24
     * @param  [quizId]
     * @return  com.utunan.pojo.community.QuizTag
     */
    List<QuizTag> findQuizTagByQuizId(Long quizId);

}
