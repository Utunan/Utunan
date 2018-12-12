package com.utunan.controller.share;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/11 16:24
 */
@Controller

public class ShareController {


    @RequestMapping("/upload")
    @ResponseBody
    public JSONObject uploadfile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

            String rootPath = request.getSession().getServletContext().getRealPath("/");
            System.out.print(rootPath);
            JSONObject resObj = new JSONObject();
            resObj.put("msg", "ok");
            try {
                FileCopyUtils.copy(file.getBytes(), new File(rootPath, file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            return resObj;
        }
}
