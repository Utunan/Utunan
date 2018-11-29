package com.utunan.service.school;

import com.utunan.pojo.base.school.Direction;

import java.util.List;

/**
 * @author 王碧云
 * @description: 研究方向
 * @date 2018/11/27/027 21:50
 */
public interface DirectionService {

    /*
     * @author  王碧云
     * @description 查询所有的研究方向
     * @date  21:53 2018/11/27/027
     * @param  []
     * @return  java.util.List<com.utunan.pojo.base.school.Direction>
     */
    List<Direction> findAllDirection();

}
