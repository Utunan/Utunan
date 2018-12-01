package com.utunan.controller.school;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.School;

import com.utunan.pojo.inherit.school.PublishDirection;
import com.utunan.pojo.inherit.school.PublishSchool;
import com.utunan.service.school.DirectionService;
import com.utunan.service.school.PublishDirectionService;
import com.utunan.service.school.PublishSchoolService;
import com.utunan.service.school.SchoolService;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王碧云
 * @description: 院校库首页
 * @date 2018/11/27/027 20:34
 */
@Controller
public class SchoolSearchController {

    @Autowired
    private PublishSchoolService publishSchoolService;
    @Autowired
    private PublishDirectionService publishDirectionService;

    /*
     * @author  王碧云
     * @description 显示院校库初始页面
     * @date  23:21 2018/11/27/027
     * @param  [request]
     * @return  java.lang.String
     */
    @RequestMapping("/displaySchool")
    public String displaySchool(HttpServletRequest request,
                                @RequestParam(value = "pageNum",required = false) String pageNum){
        List<PublishSchool> schoolList =null;
        if(pageNum == null ||pageNum == ""|| Integer.parseInt(pageNum) <= 0){
            schoolList = this.publishSchoolService.findAllSchool(1,15);
        }else{
            schoolList = this.publishSchoolService.findAllSchool(Integer.parseInt(pageNum),15);
        }

        request.setAttribute("url", "displaySchool");
        request.setAttribute("schoolList", schoolList);
        request.setAttribute("PageInfo",new PageInfo(schoolList,8));
        return "/school/schoolIndex";
    }

    /*
     * @author  王碧云
     * @description 根据搜索条件返回结果
     * @date  21:36 2018/11/27/027
     * @param  []
     * @return  java.lang.String
     */
    @RequestMapping("/displaySchoolBySearch")
    public String displaySchoolBySearch(HttpServletRequest request,
                                        @RequestParam(value = "schoolProvince",required = false) String[] schoolProvinceList,
                                        @RequestParam(value = "schoolType",required = false) String[] schoolTypeList,
                                        @RequestParam(value = "degreeType",required = false) String[] degreeTypeList,
                                        @RequestParam(value = "math",required = false) String[] mathList,
                                        @RequestParam(value = "english",required = false) String[] englishList,
                                        @RequestParam(value = "directionName",required = false) String directionName,
                                        @RequestParam(value = "pageNum",required = false) String pageNum){
        String aaa = Arrays.toString(schoolProvinceList);
        System.out.println("[aaa]"+aaa);

        List<PublishSchool> schoolList =null;
        if(pageNum == null ||pageNum == ""|| Integer.parseInt(pageNum) <= 0){
            schoolList = this.publishSchoolService.findSchoolByAllParam(schoolProvinceList, schoolTypeList,degreeTypeList,mathList,englishList,directionName,1,15);
        }else{
            schoolList = this.publishSchoolService.findSchoolByAllParam(schoolProvinceList, schoolTypeList,degreeTypeList,mathList,englishList,directionName,Integer.parseInt(pageNum),15);
        }

        String schoolProvince = String.join(",",schoolProvinceList);
        String schoolType = String.join(",",schoolTypeList);
        String degreeType = String.join(",",degreeTypeList);
        String math = String.join(",",mathList);
        String english = String.join(",",englishList);

        request.setAttribute("schoolList", schoolList);
        request.setAttribute("url", "displaySchoolBySearch");
        request.setAttribute("schoolProvince", schoolProvince);
        request.setAttribute("schoolType", schoolType);
        request.setAttribute("degreeType", degreeType);
        request.setAttribute("math", math);
        request.setAttribute("english", english);
        request.setAttribute("directionName", directionName);
        request.setAttribute("PageInfo",new PageInfo(schoolList,8));

        System.out.println(schoolList);
        return "/school/schoolIndex";
    }

    @RequestMapping("/displayDirectionDetail")
    public String displayDirectionDetail(HttpServletRequest request,
                                        @RequestParam(value = "directionName") String directionName){
        PublishDirection publishDirection = this.publishDirectionService.findDirectionByDirectionName(directionName);
        request.setAttribute("publishDirection", publishDirection);
        System.out.println("[lalala]"+publishDirection);
        return "/school/schooldetail";
    }
}

