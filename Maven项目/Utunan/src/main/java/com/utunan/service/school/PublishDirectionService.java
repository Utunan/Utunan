package com.utunan.service.school;

import com.utunan.pojo.base.school.School;
import com.utunan.pojo.inherit.school.PublishDirection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王碧云
 * @description: 研究方向
 * @date 2018/11/29/029 19:21
 */
public interface PublishDirectionService {

    /*
     * @author  王碧云
     * @description 查询研究方向详情
     * @date  19:42 2018/12/1/001
     * @param  [directionName]
     * @return  com.utunan.pojo.inherit.school.PublishDirection
     */
    PublishDirection findDirectionByDirectionName(String directionName);
}
