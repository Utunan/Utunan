package com.utunan.mapper.community;

import com.utunan.pojo.community.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {

    int insert(Article article);
    List<Article> queryByPlate(String plateId);

}
