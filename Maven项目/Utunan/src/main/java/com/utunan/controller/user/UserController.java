package com.utunan.controller.user;

import com.utunan.pojo.base.user.Message;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import com.utunan.util.ImgUtil;
import com.utunan.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping("/usermessage")
    @ResponseBody
    public String usermessage(HttpSession session) {
        User user = (User) session.getAttribute("User");
        Integer messageCount = userService.getUserMessageCount(user);
        session.setAttribute("messagecount", messageCount.toString());
        if (messageCount != null)
            return messageCount.toString();
        return "0";
    }

    @RequestMapping("/message/systeminfo/{messageId}")
    public String readSystemMessage(HttpSession session, HttpServletRequest request, @PathVariable Integer messageId) {
        Message message = userService.getMessage(messageId.toString());
        System.out.println(message);
        if (message != null) {
            if (!message.getMessageType().equals("1")) {
                return "redirect:/quiz/" + message.getQuizId();
            } else {
                request.setAttribute("Message", message);
                return "/user/systeminfo";
            }

        } else {
            return "redirect:/user/message";
        }
    }

    @RequestMapping("/changeInfo")
    public String changeInfo(User user) {
        userService.changeInfo(user);
        return "redirect:/user";
    }

    @RequestMapping("/changeemail")
    public String changeemail(HttpServletRequest request, HttpSession session) {
        String newemail = request.getParameter("newemail");
        User user = (User) session.getAttribute("User");
        String emailcode = request.getParameter("emailcode");
        if (user.getUserPassword().equals(newemail)) {
            request.setAttribute("emailreply", "新老邮箱不能相同");
            return "/user/settings";
        }
        if (!StringUtil.isEmail(newemail)) {
            request.setAttribute("emailreply", "邮箱格式错误");
        }
        user.setUserEmail(newemail);
        String checkemailcode = (String) session.getAttribute("emailcode");
        if (checkemailcode.equals(emailcode)) {
            userService.changeUserEmail(user);
            User newUser = userService.getUser(user);
            session.setAttribute("User", newUser);
            return "redirect:/user/settings#changeemail";
        } else {
            request.setAttribute("emailreply", "验证码错误");
            return "/user/settings";
        }
    }

    @RequestMapping("/changetelephone")
    public String changeUserTelephone(HttpServletRequest request) {
        String newtelephone = request.getParameter("newtelephone");
        String checkNewTelephone = (String) request.getSession().getAttribute("checknewtelephone");
        String telecode = request.getParameter("telecode");
        String checkcode = (String) request.getSession().getAttribute("telecode");
        if (!telecode.equals(checkcode)) {
            request.setAttribute("telephonereply", "验证码错误");
            request.getSession().setAttribute("newtelephone", newtelephone);
            return "/user/settings";
        } else {
            if (newtelephone.equals(checkNewTelephone)) {
                User user = (User) request.getSession().getAttribute("User");
                user.setUserTelephone(newtelephone);
                userService.changeUserTelephone(user);
                User newUser = userService.getUser(user);
                request.getSession().setAttribute("User", newUser);
                return "redirect:/user/settings#userfunction";
            } else {
                request.setAttribute("telephonereply", "手机号已更改,请重试");
                return "/user/settings";
            }
        }
    }

    @RequestMapping("/changepassword")
    public String changepassword(HttpSession session, HttpServletRequest request) {
        request.removeAttribute("passwordreply");
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        String repassword = request.getParameter("repassword");
        User user = (User) session.getAttribute("User");
        if(!user.getUserPassword().equals(oldpassword)){
            request.setAttribute("passwordreply", "原密码错误,请重新输入");
            return "/user/settings";
        }
        if (!newpassword.equals(repassword)) {
            request.setAttribute("passwordreply", "输入的密码不相同,请重新输入~");
            return "/user/settings";
        }
        if (oldpassword.equals(newpassword)) {
            request.setAttribute("passwordreply", "新密码不能和原密码相同~");
            return "/user/settings";
        }
        if (!StringUtil.isPassword(newpassword)) {
            request.setAttribute("passwordreply", "密码格式错误,请重新填写更改信息~");
            return "/user/settings";
        }
        user.setUserPassword(newpassword);
        User updateUser = userService.changeUserPassword(user);
        session.setAttribute("User", updateUser);
        return "redirect:/user/settings#changepassword";
    }

    @RequestMapping("/uploadHeadImg")
    @ResponseBody
    public String uploadHeadImg(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        String s = request.getParameter("image");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        long date = new Date().getTime();

        String linux = "/usr/local/tomcat/apache-tomcat-9.0.12/webapps/Utunan/images/userheadimg/";
        String windows = "C:/Users/ViFullCoder/Desktop/GitHub/Utunan/Maven项目/Utunan/target/Utunan/images/userheadimg/";

        String path1 = linux + user.getUserId() + "tempheadimg.png";
        String path2 = linux + user.getUserId() + date + "headimg.png";

        ImgUtil.base64StrToImage(s, path1);
        ImgUtil.changeImgSize(path1, path2, 100, 100);

        String path3 = "/images/userheadimg/" + user.getUserId() + date + "headimg.png";
        userService.changeUserHeadImg(user, path3);
        File file = new File(linux + user.getUserHeadImg().substring(20));
        file.delete();
//        response.setHeader("Pragma","No-Cache");
//        response.setHeader("Cache-Control","No-Cache");
//        response.setDateHeader("Expires", 0);
        session.setAttribute("User", user);
        return "200";
    }

}
