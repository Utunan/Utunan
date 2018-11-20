package com.utunan.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

    @RequestMapping("/homepage")
    public String homepage() {
        return "homepage";
    }
}
