package com.utunan.service.community;

import com.utunan.pojo.community.Article;
import java.util.List;

public interface ArticleService {

    int insert(Article article);
    List<Article> queryByPlate(String plateId);

}
