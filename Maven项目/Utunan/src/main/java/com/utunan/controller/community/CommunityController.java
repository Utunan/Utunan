package com.utunan.controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class CommunityController {

    @RequestMapping("")
    public String community(){
        return "/community/community";
    }
}
