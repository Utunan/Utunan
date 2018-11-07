package com.utunan.controller;

import com.utunan.pojo.uerinfo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Users")
public class UsersController {
    @RequestMapping("/allUsers")
    public String allUsers(Model model) {

        List<User> users = new ArrayList<>();

        User user = new User();
        user.setUserNickName("sssss");
        users.add(user);
        User user1 = new User();
        user1.setUserNickName("44444");
        users.add(user1);
        model.addAttribute("users", users);
        return "user";
    }
}
