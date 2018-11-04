package com.utunan;

import com.utunan.pojo.User;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void s1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User girl=(User) context.getBean("user");
        User user=context.getBean("user",User.class);
        System.out.println(user);
    }
}
