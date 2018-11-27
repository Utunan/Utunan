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

    @RequestMapping("/displaySchool")
    public String displaySchool(HttpServletRequest request){
        List<Direction> directionList = this.directionService.findAllDirection();

        request.setAttribute("directionList", directionList);

        System.out.println(directionList);

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
    public String displaySchoolBySearch(@RequestParam("schoolProvince") String schoolProvince){
        System.out.println(schoolProvince);
        return "/school/schoolsearch";
    }

}

