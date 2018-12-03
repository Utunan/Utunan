package com.utunan.mapper.questionbank;

import com.utunan.pojo.base.questionbank.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionSearchMapper {
	List<Question> selectQuestionBySearchValue(@Param("searchValue") String searchValue);
	Long countAllQuestion();
}
