package com.utunan.controller.common;

import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 王碧云
 * @description: 弹窗登录（用户名密码验证）
 * @date 2018/12/28/028 17:11
 */
@Controller
public class PopsUpLoginController {

    @Autowired
    private UserService userService;

    /*
     * @author  王碧云
     * @description 弹窗的登录（判断用户名密码）
     * @date  15:42 2018/12/17/017
     * @param  [request, account, session]
     * @return  java.lang.String
     */
    @RequestMapping(value = "/popsupLogin", method = RequestMethod.POST)
    public void popsupLogin(HttpServletRequest request, User account, HttpSession session, HttpServletResponse response) throws IOException {
        String permit = request.getParameter("permit");
        account.setUserEmail(permit);
        account.setUserTelephone(permit);
        User user = userService.getUser(account);
        if (user != null) {
            request.removeAttribute("reply");
            session.setAttribute("User", user);

            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

}
