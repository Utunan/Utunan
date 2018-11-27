package com.utunan.controller.school;

import com.utunan.pojo.school.School;
import com.utunan.service.school.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/school")
public class SchoolController {

    @RequestMapping("")
    public String school(){
        return "/school/school";
    }

}
