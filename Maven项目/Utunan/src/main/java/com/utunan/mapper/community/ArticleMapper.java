package com.utunan.mapper.community;

import com.utunan.pojo.community.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArticleMapper {

    int insert(Article article);
    List<Article> queryByPlate(String plateId);

}
