package com.utunan.controller.user;


import com.aliyuncs.exceptions.ClientException;
import com.utunan.mapper.user.UserMapper;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import com.utunan.util.ImgUtil;
import com.utunan.util.RandUtil;
import com.utunan.util.SmsDemo;
import com.utunan.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

@Controller
public class UserVerification {

    @Autowired
    private UserService userService;

    @RequestMapping("/code")
    @ResponseBody
    public void code(HttpServletRequest request, HttpServletResponse response){
        String userTelephone=request.getParameter("userTelephone");
        response.setCharacterEncoding("UTF-8");

        //获取验证码
        RandUtil random=new RandUtil();
        String code=random.getRandNum();

        //将验证码保存在session中
        request.getSession().setAttribute("code",code);

        SmsDemo smsDemo=new SmsDemo();
        try {
            smsDemo.sendSms(userTelephone,code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/telecode")
    @ResponseBody
    public void telecode(HttpServletRequest request,HttpServletResponse response){
        String userTelephone=request.getParameter("newTelephone");
        response.setCharacterEncoding("UTF-8");

        //获取验证码
        RandUtil random=new RandUtil();
        String code=random.getRandNum();

        //将验证码保存在session中
        request.getSession().setAttribute("code",code);

        SmsDemo smsDemo=new SmsDemo();
        try {
            smsDemo.sendSms(userTelephone,code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/user/changepassword")
    public String changepassword(HttpSession session,HttpServletRequest request){
        request.removeAttribute("passwordreply");
        String oldpassword=request.getParameter("oldpassword");
        String newpassword=request.getParameter("newpassword");
        String repassword=request.getParameter("repassword");
        System.out.println(oldpassword+newpassword+repassword);
        if(!newpassword.equals(repassword)){
            request.setAttribute("passwordreply","输入的密码不相同,请重新输入~");
            return "/user/settings";
        }
        if(oldpassword.equals(newpassword)){
            request.setAttribute("passwordreply","新密码不能和原密码相同~");
            return "/user/settings";
        }
        if(!StringUtil.checkPasswordFormat(newpassword)){
            request.setAttribute("passwordreply","密码格式错误,请重新填写更改信息~");
            return "/user/settings";
        }
        User user= (User) session.getAttribute("User");
        user.setUserPassword(newpassword);
        User updateUser=userService.changeUserPassword(user);
        session.setAttribute("User",updateUser);
        return "redirect:/user/settings";
    }

    @RequestMapping("/user/uploadHeadImg")
    @ResponseBody
    public String uploadHeadImg(HttpServletRequest request,HttpServletResponse response) throws InterruptedException {
        String s=request.getParameter("image");
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("User");
        long date=new Date().getTime();

        String linux="/usr/local/tomcat/apache-tomcat-9.0.12/webapps/Utunan/images/userheadimg/";
        String windows="C:/Users/ViFullCoder/Desktop/GitHub/Utunan/Maven项目/Utunan/target/Utunan/images/userheadimg/";

        String path1=linux+user.getUserId()+"tempheadimg.png";
        String path2=linux+user.getUserId()+date+"headimg.png";

        ImgUtil.base64StrToImage(s,path1);
        ImgUtil.changeImgSize(path1,path2,100,100);

        String path3="/images/userheadimg/"+user.getUserId()+date+"headimg.png";
        userService.changeUserHeadImg(user,path3);
        File file=new File(linux+user.getUserHeadImg().substring(20));
        file.delete();
//        response.setHeader("Pragma","No-Cache");
//        response.setHeader("Cache-Control","No-Cache");
//        response.setDateHeader("Expires", 0);
        session.setAttribute("User",user);
        return "200";
    }

}
