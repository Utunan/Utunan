package com.utunan.controller.share;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload")
public class ShareSkipController {
    @RequestMapping("/uploaddetail")
    public String uploadDetail(){
        return "share/uploaddetail";
    }

}
