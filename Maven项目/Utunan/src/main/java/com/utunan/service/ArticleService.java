package com.utunan.service;

import com.utunan.pojo.forum.Article;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ArticleService {

    int insert(Article article);
    List<Article> queryByPlate(String plateId);

}
