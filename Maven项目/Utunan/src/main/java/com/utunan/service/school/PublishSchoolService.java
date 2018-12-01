package com.utunan.service.school;

import com.utunan.pojo.inherit.school.PublishDirection;
import com.utunan.pojo.inherit.school.PublishSchool;

import java.util.List;

/**
 * @author 王碧云
 * @description: 学校Service
 * @date 2018/12/1/001 18:58
 */
public interface PublishSchoolService {
    /*
     * @author  王碧云
     * @description 查询所有的学校
     * @date  20:10 2018/11/27/027
     * @param  []
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    List<PublishSchool> findAllSchool(int pageNum, int pageSize);

    /*
     * @author  王碧云
     * @description 根据所有参数检索学校
     * @date  22:49 2018/11/28/028
     * @param  [schoolProvinceList, schoolType]
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    List<PublishSchool> findSchoolByAllParam(String[] schoolProvinceList,String[] schoolType,String[] degreeTypeList,String[] mathList,String[] englishList,String directionName,int pageNum, int pageSize);


}
