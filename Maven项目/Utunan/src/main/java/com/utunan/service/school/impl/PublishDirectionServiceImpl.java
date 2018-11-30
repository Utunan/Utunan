package com.utunan.service.school.impl;

import com.utunan.mapper.school.PublishDirectionMapper;
import com.utunan.mapper.school.SchoolMapper;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.inherit.school.PublishDirection;
import com.utunan.service.school.PublishDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/11/29/029 19:28
 */
@Service("publishDirectionService")
public class PublishDirectionServiceImpl implements PublishDirectionService {

    @Autowired
    private PublishDirectionMapper publishDirectionMapper;

    /*
     * @author  王碧云
     * @description 查询所有的学校
     * @date  20:12 2018/11/27/027
     * @param  []
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    @Override
    public List<PublishDirection> findAllSchool() {
        return this.publishDirectionMapper.findAllSchool();
    }


    /*
     * @author  王碧云
     * @description 根据所有参数检索所有学校
     * @date  22:51 2018/11/28/028
     * @param  [schoolProvinceList, schoolType]
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    @Override
    public List<PublishDirection> findSchoolByAllParam(String[] schoolProvinceList, String[] schoolType, String[] degreeTypeList, String[] mathList, String[] englishList,String directionName) {
        schoolProvinceList = judgeParam(schoolProvinceList);
        schoolType = judgeParam(schoolType);
        degreeTypeList = judgeParam(degreeTypeList);
        mathList = judgeParam(mathList);
        englishList = judgeParam(englishList);

        List<PublishDirection> directionlist = this.publishDirectionMapper.findSchoolByAllParam(schoolProvinceList, schoolType,degreeTypeList,mathList,englishList,directionName);
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

}
