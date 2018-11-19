package com.utunan.mapper.community;

import com.utunan.pojo.community.Quiz;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuizMapper {

    int insert(Quiz quiz);
    List<Quiz> queryByPlate(String plateId);

}
