package com.utunan.mapper.community;

import com.utunan.pojo.community.Quiz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author  孙程程
 * @description 问答
 * @date  16:19 2018/11/19
 */
@Mapper
@Repository
public interface QuizMapper {
    List<Quiz> listByTime(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    List<Quiz> listByPraise(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    Long countAllQuiz();
    List<Long> countComment(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    /*
     * @author  王碧云
     */
    Quiz findQuizById(@Param("quizId") int quizId);
}
