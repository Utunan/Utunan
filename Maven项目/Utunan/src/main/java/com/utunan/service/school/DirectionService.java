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
    /*
     * @author  王碧云
     * @description 根据Id查找研究方向
     * @date  17:59 2018/12/10/010
     * @param  [directionId]
     * @return  com.utunan.pojo.base.school.Direction
     */
    Direction findDirectionByDirectionId(Long directionId);
    /*
     * @author  王碧云
     * @description 修改网页浏览数
     * @date  14:57 2018/12/10/010
     * @param  []
     * @return  java.lang.Long
     */
    void updateviewCount(Long directionId);
}
