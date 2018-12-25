package com.utunan.controller.admin;

import com.utunan.service.admin.AdminFileService;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ResourceController {
    @Autowired
    private AdminFileService adminFileService;

    //删除单个资源待审核文件
    @RequestMapping(value = "/delprefile",method = RequestMethod.GET)
    @ResponseBody
    public void delprefile(@Param("n") String n, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        this.adminFileService.delprefile(Long.parseLong(n));
        JSONObject obj=new JSONObject();
        obj.put("res","ok");
        response.getWriter().append(obj.toString());
    }

    //批量删除资源待审核文件
    @RequestMapping(value = "/delallprefile",method = RequestMethod.GET)
    @ResponseBody
    public void delallprefile(@Param("d") String d, HttpServletRequest request){
        String[] data=d.split(",");
        Long[] b=new Long[data.length];
        for (int i = 0; i <data.length ; i++) {
            b[i] = new Long(data[i]);
        }
        this.adminFileService.delallprefile(b);
    }

    //审核文件通过
    @RequestMapping(value = "/editprefile",method = RequestMethod.GET)
    @ResponseBody
    public void editprefile(@Param("n") String n,HttpServletRequest request,HttpServletResponse response) throws IOException {
        this.adminFileService.updateprefile(Long.parseLong(n));
        JSONObject obj=new JSONObject();
        obj.put("res","ok");
        response.getWriter().append(obj.toString());
    }

    //删除单个已审核文件
    @RequestMapping(value = "/delfile",method = RequestMethod.GET)
    @ResponseBody
    public void delfile(@Param("n") String n, HttpServletRequest request){
        this.adminFileService.delfile(Long.parseLong(n));
    }

    //批量删除已审核文件
    @RequestMapping(value = "/delallfile",method = RequestMethod.GET)
    @ResponseBody
    public void delallfile(@Param("d") String d, HttpServletRequest request){
        String[] data=d.split(",");
        Long[] b=new Long[data.length];
        for (int i = 0; i <data.length ; i++) {
            b[i] = new Long(data[i]);
        }
        this.adminFileService.delallfile(b);
    }
}
