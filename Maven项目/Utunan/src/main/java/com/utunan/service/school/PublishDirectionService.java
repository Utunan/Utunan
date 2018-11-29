package com.utunan.service.school;

import com.utunan.pojo.base.school.School;
import com.utunan.pojo.inherit.school.PublishDirection;

import java.util.List;

/**
 * @author 王碧云
 * @description: 研究方向
 * @date 2018/11/29/029 19:21
 */
public interface PublishDirectionService {

    /*
     * @author  王碧云
     * @description 查询所有的学校
     * @date  20:10 2018/11/27/027
     * @param  []
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    List<PublishDirection> findAllSchool();

    /*
     * @author  王碧云
     * @description 根据所有参数检索学校
     * @date  22:49 2018/11/28/028
     * @param  [schoolProvinceList, schoolType]
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    List<PublishDirection> findSchoolByAllParam(String[] schoolProvinceList,String[] schoolType,String[] degreeTypeList,String[] mathList,String[] englishList);

}
