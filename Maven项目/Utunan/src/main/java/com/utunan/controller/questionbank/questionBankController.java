package com.utunan.controller.questionbank;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questionbank")
public class questionBankController {

    @RequestMapping("")
    public String questionBank(){
        return  "/questionbank/questionbank";
    }
}
