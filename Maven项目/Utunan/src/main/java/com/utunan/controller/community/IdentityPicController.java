package com.utunan.controller.community;

import com.utunan.service.community.IdentityPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/11/26/026 20:21
 */
@Controller
public class IdentityPicController {

    @Autowired
    private IdentityPicService identityPicService;

    /*
     * @author  王碧云
     * @description 跳转到jsp页面(合并的时候应该可以不要)
     * @date  20:52 2018/11/26/026
     * @param  []
     * @return  java.lang.String
     */
    @RequestMapping("/toIdentityPicJpg")
    public String toIdentityPicJpg(){
        return "community/identitypic";
    }

    /*
     * @author  王碧云
     * @description 获取验证码图片
     * @date  20:32 2018/11/26/026
     * @param  []
     * @return  void
     */
    @RequestMapping("/getIdentityPic")
    public void getIdentityPic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.identityPicService.getIdentityPic(request, response);
    }

    /*
     * @author  王碧云
     * @description 判断用户输入的验证码是否正确（正确，随便跳转了一个页面）
     * @date  20:43 2018/11/26/026
     * @param  [request]
     * @return  java.lang.String
     */
    @RequestMapping("/judgePicCode")
    public String judgePicCode(HttpServletRequest request){
        String userinput = request.getParameter("userinput");
        String code = (String) request.getSession().getAttribute("code");
        System.out.println("code:"+code);
        if(userinput.equals(code)){
            System.out.println("验证成功！");
            return "community/quiz";
        }else{
            System.out.println("验证失败！");
            return "community/identitypic";
        }
    }

}
