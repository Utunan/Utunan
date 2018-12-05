package com.utunan.service.school.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.school.PublishSchoolMapper;
import com.utunan.pojo.inherit.school.PublishSchool;
import com.utunan.service.school.PublishSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
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
    public List<PublishSchool> findSchoolByAllParam(String[] schoolProvinceList, String[] schoolType, String[] degreeTypeList, String[] mathList, String[] englishList,String directionName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        schoolProvinceList = judgeParam(schoolProvinceList);
        schoolType = judgeParam(schoolType);
        degreeTypeList = judgeParam(degreeTypeList);
        mathList = judgeParam(mathList);
        englishList = judgeParam(englishList);

        List<PublishSchool> directionlist = this.publishSchoolMapper.findSchoolByAllParam(schoolProvinceList, schoolType,degreeTypeList,mathList,englishList,directionName);
        return directionlist;
    }

    /*
     * @author  王碧云
     * @description 判断返回的参数是否选中全部
     * @date  21:33 2018/11/29/029
     * @param  [list]
     * @return  java.lang.String[]
     */
    public String[] judgeParam(String[] list){
        if(list==null){
            return list;
        }else {
            for(String l:list){
                if(l.equals("全部")){
                    list=null;
                    break;
                }
            }
            return list;
        }
    }
    /*
     * @author  王碧云
     * @description 将字符数组转为字符串
     * @date  8:34 2018/12/5/005
     * @param  [list]
     * @return  java.lang.String
     */
    public String judgeIsNull(String[] list){
        if (list == null){
            return null;
        }else {
            String s =String.join(",",list);
            return s;
        }
    }

}
