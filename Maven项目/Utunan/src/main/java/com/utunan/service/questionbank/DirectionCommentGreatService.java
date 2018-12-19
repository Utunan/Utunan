package com.utunan.service.questionbank;

import com.utunan.pojo.base.questionbank.DirectionCommentGreat;
import org.apache.ibatis.annotations.Param;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/19/019 9:45
 */
public interface DirectionCommentGreatService {

    /*查询某用户是否在某评论点赞*/
    DirectionCommentGreat findDCGreat(Long directionCommentId, Long userId);
    /*添加用户点赞记录*/
    void insertDCGreat(Long directionCommentId, Long userId);
    /*删除用户点赞记录*/
    void deleteDCGreat(Long directionCommentId, Long userId);

}
