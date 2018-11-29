package com.utunan.service.school;

import com.utunan.pojo.base.school.School;

import java.util.List;

public interface SchoolService {

    /*
     * @author  王碧云
     * @description 查询所有的学校
     * @date  20:10 2018/11/27/027
     * @param  []
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    List<School> findAllSchool();

    /*
     * @author  王碧云
     * @description 根据省份检索学校(通过学校找到该校的研究方向)
     * @date  10:08 2018/11/28/028
     * @param  [schoolProvince]
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    List<School> findSchoolBySchoolProvince(String[] schoolProvinceList);

    /*
     * @author  王碧云
     * @description 根据学校类型检索学校(通过学校找到该校的研究方向)
     * @date  16:16 2018/11/28/028
     * @param  [schoolType]
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    List<School> findSchoolBySchoolType(String[] schoolType);

    /*
     * @author  王碧云
     * @description 根据所有参数检索学校
     * @date  22:49 2018/11/28/028
     * @param  [schoolProvinceList, schoolType]
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    List<School> findSchoolByAllParam(String[] schoolProvinceList,String[] schoolType,String[] degreeTypeList,String[] mathList,String[] englishList);
}
