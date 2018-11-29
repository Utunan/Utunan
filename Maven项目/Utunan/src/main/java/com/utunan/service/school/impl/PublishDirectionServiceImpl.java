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
     * @description 根据省份检索学校(通过学校找到该校的研究方向)
     * @date  10:07 2018/11/28/028
     * @param  [schoolProvince]
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    @Override
    public List<PublishDirection> findSchoolBySchoolProvince(String[] schoolProvinceList) {

        List<PublishDirection> directionlist = new ArrayList<PublishDirection>();

        for(String schoolProvince:schoolProvinceList){
            if(schoolProvince.equals("null")){
                directionlist = this.publishDirectionMapper.findAllSchool();
                break;
            }else {
                directionlist = this.publishDirectionMapper.findSchoolBySchoolProvince(schoolProvinceList);
            }
        }

        return directionlist;
    }
    /*
     * @author  王碧云
     * @description 根据学校类型检索学校(通过学校找到该校的研究方向)
     * @date  16:17 2018/11/28/028
     * @param  [schoolType]
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    @Override
    public List<PublishDirection> findSchoolBySchoolType(String[] schoolTypeList) {
        List<PublishDirection> directionlist = new ArrayList<>();
        if(schoolTypeList.equals("null")){
            directionlist = this.publishDirectionMapper.findAllSchool();
        }else{
            directionlist = this.publishDirectionMapper.findSchoolBySchoolType(schoolTypeList);
        }
        return directionlist;
    }
    /*
     * @author  王碧云
     * @description 根据所有参数检索所有学校
     * @date  22:51 2018/11/28/028
     * @param  [schoolProvinceList, schoolType]
     * @return  java.util.List<com.utunan.pojo.base.school.School>
     */
    @Override
    public List<PublishDirection> findSchoolByAllParam(String[] schoolProvinceList, String[] schoolType, String[] degreeTypeList, String[] mathList, String[] englishList) {
        List<PublishDirection> directionlist = this.publishDirectionMapper.findSchoolByAllParam(schoolProvinceList, schoolType,degreeTypeList,mathList,englishList);
        return directionlist;
    }

}
