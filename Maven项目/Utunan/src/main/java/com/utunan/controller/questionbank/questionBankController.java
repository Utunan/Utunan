package com.utunan.controller.questionbank;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/questionbank")
public class questionBankController {

    @RequestMapping("")
    public String questionBank(){
        return  "/questionbank/questionbank";
    }
}
