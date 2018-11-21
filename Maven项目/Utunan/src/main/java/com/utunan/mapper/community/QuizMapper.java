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
    /*
     * @author  张正扬
     * @description 向quiz表插入Quiz对象
     * @date  14:16 2018/11/21
     * @param  quiz
     * @return null
     */

    void toInsert(Quiz quiz);
    /*
     * @author  张正扬
     * @description 根据userId和title查询相应quiz对象
     * @date  14:18 2018/11/21
     * @param  userId,title
     * @return  Quiz
     */

    Quiz getQuiz(String title,String content);
}
