package com.utunan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//不要继承任何的类或者实现任何的接口,没有强迫我
@Controller
public class ByeController {

    //ModelAndView Model+View
    @RequestMapping("/bye")
    public String bye(Model model) {
        model.addAttribute("model", "modeller");
        //这里return的就是我们的那个viewName
        //此时去的是,/jsp/bye.jsp

        return "bye";
    }
}
