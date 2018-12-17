package com.utunan.controller.share;


import com.utunan.pojo.base.user.User;
import com.utunan.service.share.ShareupFileService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import static java.lang.System.out;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/11 16:24
 */
@Controller

public class ShareController {
    @Autowired
    private ShareupFileService shareupFileService;


//    @RequestMapping(value = "/upload")
//    @ResponseBody
//    public JSONObject uploadfile(@RequestParam("file") MultipartFile file, HttpServletRequest request,HttpSession session) {
//        String rootPath = request.getSession().getServletContext().getRealPath("/");
//        JSONObject resObj = new JSONObject();
//        resObj.put("msg", "ok");
////        try {
////            FileCopyUtils.copy(file.getBytes(), new File(rootPath, file.getOriginalFilename()));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//        String path=rootPath+file.getOriginalFilename();
//        System.out.print(path+"\n");
//        session.setAttribute("realPath",path);
//        return resObj;
//    }

    @ResponseBody
    @RequestMapping(value = "/upload1",method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file",required = false) MultipartFile file,HttpServletRequest request,HttpSession session){
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        String path=rootPath+file.getOriginalFilename();
        System.out.print(path+"\n");
        JSONObject resObj = new JSONObject();
        resObj.put("msg", "ok");
        try {
            FileCopyUtils.copy(file.getBytes(), new File(rootPath, file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取资源类型
        String sourcetype=request.getParameter("sourcetype");
        int a=Integer.parseInt(sourcetype);

        switch(a)
        {
            case 0:
                sourcetype="招生简章";
                break;
            case 1:
               sourcetype="招生专业目录";
                break;
            case 11:
                sourcetype="考研真题";
                break;
            case 12:
                sourcetype="备考习题";
                break;
            case 13:
                sourcetype="课件分享";
                break;
            default:
                sourcetype="参考书目";
                break;
        }
        //获取标题
        String title=request.getParameter("title");
        //获取年份
        String year=request.getParameter("year");
        //获取积分
        String integral=request.getParameter("integral");
        //获取文件类型后缀
        String filetype=request.getParameter("filetype");
        //获取学校
        String school=request.getParameter("school");


        //获取文件路径
        String paths=(String)session.getAttribute("realPath");
        System.out.print(paths+"\n");

        //获取登录用户
        User user=(User)session.getAttribute("User");

        if(sourcetype=="招生简章"||sourcetype=="招生专业目录"){
            title=school+year+sourcetype;
        }

        //查询对应标签ID
        Long suffixId=this.shareupFileService.getSuffix(filetype);

        this.shareupFileService.insertfile(sourcetype,title,school,user.getUserId(),path,suffixId,Long.parseLong(integral));

        return "ok";
    }

}
