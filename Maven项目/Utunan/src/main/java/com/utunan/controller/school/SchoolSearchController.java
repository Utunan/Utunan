package com.utunan.controller.school;

import com.utunan.pojo.school.School;
import com.utunan.service.school.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/displaySchool")
    public String displaySchool(HttpServletRequest request){
        List<School> schoollist = this.schoolService.findAllSchool();

        request.setAttribute("schoollist", schoollist);

        System.out.println(schoollist);

        return "/school/schoolsearch";
    }

}

