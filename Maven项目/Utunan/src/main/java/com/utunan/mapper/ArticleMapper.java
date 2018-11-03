package com.utunan.mapper;

import com.utunan.pojo.Article;

import java.util.List;

public interface ArticleMapper {

    int insert(Article article);

    List<Article> queryByPlate(String plateId);

}
