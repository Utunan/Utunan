package com.utunan.controller.school;

import com.utunan.pojo.base.school.School;

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
                                        @RequestParam(value = "schoolType",required = false) String[] schoolTypeList,
                                        @RequestParam(value = "degreeType",required = false) String[] degreeTypeList,
                                        @RequestParam(value = "math",required = false) String[] mathList,
                                        @RequestParam(value = "english",required = false) String[] englishList){
        String aaa = Arrays.toString(schoolTypeList);
        String bbb = Arrays.toString(schoolProvinceList);
        String ccc = Arrays.toString(degreeTypeList);
        String ddd = Arrays.toString(mathList);
        String eee = Arrays.toString(englishList);

        List<School> schoolList = new ArrayList<>();
        //防止复选框为空的情况
     /*  if((schoolProvinceList==null || "".equals(schoolProvinceList))&&(schoolTypeList==null || "".equals(schoolTypeList))){
           System.out.println("都为空");
           schoolList = this.schoolService.findAllSchool();
        }else if ((schoolProvinceList!=null || !"".equals(schoolProvinceList))&&(schoolTypeList==null || "".equals(schoolTypeList))){
           System.out.println("学校类型为空");
           schoolList = this.schoolService.findSchoolBySchoolProvince(schoolProvinceList);
       } else if((schoolProvinceList==null || "".equals(schoolProvinceList))&&(schoolTypeList!=null || !"".equals(schoolTypeList))){
           System.out.println("省份为空");
           schoolList = this.schoolService.findSchoolBySchoolType(schoolTypeList);
       } else {
           schoolList = this.schoolService.findSchoolByAllParam(schoolProvinceList, schoolTypeList);
        }*/

        schoolList = this.schoolService.findSchoolByAllParam(schoolProvinceList, schoolTypeList,degreeTypeList,mathList,englishList);
        request.setAttribute("schoolList", schoolList);

        System.out.println("[schoolProvinceList]"+bbb);
        System.out.println("[schoolTypeList]"+aaa);
        System.out.println("[degreeTypeList]"+ccc);
        System.out.println("[math]"+ddd);
        System.out.println("[english]"+eee);
        System.out.println(schoolList);
        return "/school/schoolsearch";
    }

}

