package com.utunan.controller.school;

import com.utunan.pojo.school.Direction;
import com.utunan.pojo.school.School;

import com.utunan.service.school.DirectionService;
import com.utunan.service.school.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王碧云
 * @description: 院校库
 * @date 2018/11/27/027 20:34
 */
@Controller
public class SchoolSearchController {

    @Autowired
    private SchoolService schoolService;
    @Autowired
    private DirectionService directionService;

    /*
     * @author  王碧云
     * @description 显示院校库初始页面
     * @date  23:21 2018/11/27/027
     * @param  [request]
     * @return  java.lang.String
     */
    @RequestMapping("/displaySchool")
    public String displaySchool(HttpServletRequest request){
        List<School> schoolList = this.schoolService.findAllSchool();

        request.setAttribute("schoolList", schoolList);


        return "/school/schoolsearch";
    }

    /*
     * @author  王碧云
     * @description 根据搜索条件返回结果
     * @date  21:36 2018/11/27/027
     * @param  []
     * @return  java.lang.String
     */
    @RequestMapping("/displaySchoolBySearch")
    public String displaySchoolBySearch(@RequestParam(value = "schoolProvince",required = false) String[] schoolProvinceList,
                                        HttpServletRequest request,
                                        @RequestParam(value = "schoolType",required = false) String[] schoolTypeList){
        String aaa = Arrays.toString(schoolTypeList);
        String bbb = Arrays.toString(schoolProvinceList);

        List<School> schoolList = new ArrayList<>();

       if(schoolProvinceList==null || "".equals(schoolProvinceList)){
            schoolList = this.schoolService.findAllSchool();
        }else {
           schoolList = this.schoolService.findSchoolByAllParam(schoolProvinceList, schoolTypeList);
        }

        request.setAttribute("schoolList", schoolList);

        System.out.println(bbb);
        System.out.println(aaa);
        System.out.println(schoolList);
        return "/school/schoolsearch";
    }

}

