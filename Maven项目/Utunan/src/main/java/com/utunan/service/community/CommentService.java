package com.utunan.service.community;

import com.utunan.pojo.community.Comment;


public interface CommentService {

    /*
     * @author  张正扬
     * @description  向comment表中插入回答
     * @date  7:56 2018/11/22
     * @param content
     * @return   null
     */

    void saveComment(String content);
    /*
     * @author  张正扬
     * @description 从comment表中取出刚刚插入的回答，每次只取一条
     * @date  8:08 2018/11/22
     * @param  null
     * @return  Comment对象
     */

    Comment getComment();
}
