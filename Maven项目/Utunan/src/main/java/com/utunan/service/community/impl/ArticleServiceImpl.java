package com.utunan.service.community.impl;

import com.utunan.pojo.community.Article;
import com.utunan.service.community.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    public int insert(Article article){
        return  0;
    }
     public List<Article> queryByPlate(String plateId){
        return  null;
     }

}
