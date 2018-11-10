package com.utunan.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class checkPermitController {
    @RequestMapping("checkPermit")
    public String checkPermit(HttpServletRequest request){
        return "";
    }

}
