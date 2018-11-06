package com.utunan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("forward")
    public String forward(Model model) {
        System.out.println("转发");
        model.addAttribute("skill", "forward");
        return "forward";
    }
    @RequestMapping("redirect")
    public String redirect(Model model){
        System.out.println("重定向");
        model.addAttribute("skill","redirect");
        return  "redirect";
    }

}
