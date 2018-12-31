package com.utunan.controller.share;


import com.utunan.pojo.base.user.User;
import com.utunan.service.share.ShareupFileService;
import com.utunan.util.WordLimitUtil;
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


    @RequestMapping(value = "/upload1", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpSession session) {
        if (file.isEmpty()) {
            return "share/failed";
        } else {
            String rootPath = "/usr/local/tomcat/repertory";
            String path = rootPath + "/" + file.getOriginalFilename();
           /*String rootPath=request.getSession().getServletContext().getRealPath("/");
           String path=rootPath+file.getOriginalFilename();*/

            JSONObject resObj = new JSONObject();
            resObj.put("msg", "ok");
            try {
                FileCopyUtils.copy(file.getBytes(), new File(rootPath, file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //获取资源类型
            String sourcetype = request.getParameter("sourcetype");


            int a = new Integer(sourcetype).intValue();
            switch (a) {
                case 0:
                    sourcetype = "招生简章";
                    break;
                case 1:
                    sourcetype = "招生专业目录";
                    break;
                case 11:
                    sourcetype = "考研真题";
                    break;
                case 12:
                    sourcetype = "备考习题";
                    break;
                case 13:
                    sourcetype = "课件分享";
                    break;
                default:
                    sourcetype = "参考书目";
                    break;

            }
            //获取标题
            String title = request.getParameter("title");
            //获取年份
            String year = request.getParameter("year");
            //获取积分
            String integral = request.getParameter("integral");
            //获取文件类型后缀
            String filetype = request.getParameter("filetype");
            //获取学校
            String school = request.getParameter("school");
            if ("0".equals(school)) {
                school = null;
            }
            //获取资源简介
            String desc = request.getParameter("desc");

            //获取登录用户
            User user = (User) session.getAttribute("User");
            //查询对应标签ID
            Long suffixId = this.shareupFileService.getSuffix(filetype);

            //获取最大的fileId
            Long fileId = this.shareupFileService.getMaxfileId();
            fileId += 1;

            if (sourcetype.equals("招生简章") || sourcetype.equals("招生专业目录")) {
                title = school + year + sourcetype;
                if (Long.parseLong(integral) >= 0 && desc!=null) {

                    this.shareupFileService.insertfile(fileId, sourcetype, title, school, user.getUserId(), path, suffixId, Long.parseLong(integral), Long.parseLong("0"), desc);
                    return "share/success";

                } else {
                    return "share/failed";
                }
            } else {
                if (Long.parseLong(integral) >= 0 && WordLimitUtil.isNull(title) && WordLimitUtil.getLength(title) >= 3 && WordLimitUtil.getLength(title) <= 25 && desc!=null) {

                    this.shareupFileService.insertfile(fileId, sourcetype, title, school, user.getUserId(), path, suffixId, Long.parseLong(integral), Long.parseLong("1"), desc);
                    return "share/success";

                } else {
                    return "share/failed";
                }
            }
        }
    }

}
