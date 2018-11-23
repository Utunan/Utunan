package com.utunan.mapper.community;

import com.utunan.pojo.community.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/11/22 17:01
 */
@Mapper
@Repository
public interface CommentMapper {
    void toInsert(Comment comment);
    Comment getComment();
}

