package com.utunan.service.school.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.school.PublishSchoolMapper;
import com.utunan.pojo.inherit.school.PublishSchool;
import com.utunan.util.SchoolOther;
import com.utunan.service.school.PublishSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王碧云
 * @description: 学校
 * @date 2018/12/1/001 19:00
 */
@Service("publishSchoolService")
public class PublishSchoolServiceImpl implements PublishSchoolService {
    @Autowired
    private PublishSchoolMapper publishSchoolMapper;

    /*
     * @author  王碧云
     * @description 查询所有的学校
     * @date  20:12 2018/11/27/027
     * @param  []
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    @Override
    public List<PublishSchool> findAllSchool(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.publishSchoolMapper.findAllSchool();
    }
    /*
     * @author  王碧云
     * @description 根据所有参数检索所有学校
     * @date  22:51 2018/11/28/028
     * @param  [schoolProvinceList, schoolType]
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    @Override
    public List<PublishSchool> findSchoolByAllParam(String[] schoolProvinceList, String[] schoolType, String[] degreeTypeList, String[] mathList, String[] englishList,List<String> directionNameList, int pageNum, int pageSize) {
        SchoolOther so = new SchoolOther();
        schoolProvinceList = so.clickAll(schoolProvinceList);
        schoolType = so.clickAll(schoolType);
        degreeTypeList = so.clickAll(degreeTypeList);
        mathList = so.clickAll(mathList);
        englishList = so.clickAll(englishList);

        //将List的词变为匹配项
        String directionName = "";
        for(int i=0; i<directionNameList.size(); i++){
            directionName += directionNameList.get(i);
            if (i != (directionNameList.size()-1)){
                directionName += "|";
            }
        }
        //分页
        PageHelper.startPage(pageNum, pageSize);
        //搜索，返回列表
        List<PublishSchool> directionlist = this.publishSchoolMapper.findSchoolByAllParam(schoolProvinceList, schoolType,degreeTypeList,mathList,englishList,directionName);
        return directionlist;
    }

}
