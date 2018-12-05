package com.utunan.controller.school;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.School;

import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.school.PublishDirection;
import com.utunan.pojo.inherit.school.PublishSchool;
import com.utunan.pojo.inherit.user.PublishDirectionCollector;
import com.utunan.service.school.DirectionService;
import com.utunan.service.school.PublishDirectionService;
import com.utunan.service.school.PublishSchoolService;
import com.utunan.service.school.SchoolService;
import com.utunan.service.user.PublishDirectionCollectorService;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author 王碧云
 * @description: 院校库首页
 * @date 2018/11/27/027 20:34
 */
@Controller
public class SchoolSearchController {

    @Autowired
    private PublishSchoolService publishSchoolService;
    @Autowired
    private PublishDirectionService publishDirectionService;
    @Autowired
    private PublishDirectionCollectorService publishDirectionCollectorService;

    /*
     * @author  王碧云
     * @description 显示院校库初始页面
     * @date  23:21 2018/11/27/027
     * @param  [request]
     * @return  java.lang.String
     */
    @RequestMapping("/displaySchool")
    public String displaySchool(HttpServletRequest request,
                                @RequestParam(value = "pageNum",required = false) String pageNum,
                                HttpSession session){
        Object obj = session.getAttribute("User");
        Long userId = null;
        if(obj != null){
            //用户已登录
            User user = (User)obj;
            userId = user.getUserId();
            System.out.println("[uuuuser]"+user);
        }
        //查找收藏的院校Id
        List<Long> directionIdList = this.publishDirectionCollectorService.findDirectionIdByUser(userId);
        System.out.println("[yayaya]"+directionIdList);

        List<PublishSchool> schoolList =null;
        if(pageNum == null ||pageNum == ""|| Integer.parseInt(pageNum) <= 0){
            schoolList = this.publishSchoolService.findAllSchool(1,15);
        }else{
            schoolList = this.publishSchoolService.findAllSchool(Integer.parseInt(pageNum),15);
        }

        request.setAttribute("url", "displaySchool");
        request.setAttribute("schoolList", schoolList);
        request.setAttribute("PageInfo",new PageInfo(schoolList,8));
        request.setAttribute("directionIds",directionIdList);

        return "/school/schoolIndex";
    }

    /*
     * @author  王碧云
     * @description 根据搜索条件返回结果
     * @date  21:36 2018/11/27/027
     * @param  []
     * @return  java.lang.String
     */
    @RequestMapping("/displaySchoolBySearch")
    public String displaySchoolBySearch(HttpServletRequest request,
                                        @RequestParam(value = "schoolProvince",required = false) String[] schoolProvinceList,
                                        @RequestParam(value = "schoolType",required = false) String[] schoolTypeList,
                                        @RequestParam(value = "degreeType",required = false) String[] degreeTypeList,
                                        @RequestParam(value = "math",required = false) String[] mathList,
                                        @RequestParam(value = "english",required = false) String[] englishList,
                                        @RequestParam(value = "directionName",required = false) String directionName,
                                        @RequestParam(value = "pageNum",required = false) String pageNum,
                                        HttpSession session){
        String aaa = Arrays.toString(schoolProvinceList);
        System.out.println("[aaa]"+aaa);

        Object obj = session.getAttribute("User");
        Long userId = null;
        if(obj != null){
            //用户已登录
            User user = (User)obj;
            userId = user.getUserId();
        }

        //查找收藏的院校Id
        List<Long> directionIdList = this.publishDirectionCollectorService.findDirectionIdByUser(userId);
        System.out.println("[yayaya]"+directionIdList);

        /*String directionName=null;*/
        /*if(searchName!=null || !"".equals(searchName))
            directionName=searchName;*/
        System.out.println("[schoolTypeList]"+schoolTypeList);
       System.out.println("[direction]"+directionName);

        List<PublishSchool> schoolList =null;
        if(pageNum == null ||pageNum == ""|| Integer.parseInt(pageNum) <= 0){
            schoolList = this.publishSchoolService.findSchoolByAllParam(schoolProvinceList, schoolTypeList,degreeTypeList,mathList,englishList,directionName,1,15);
        }else{
            schoolList = this.publishSchoolService.findSchoolByAllParam(schoolProvinceList, schoolTypeList,degreeTypeList,mathList,englishList,directionName,Integer.parseInt(pageNum),15);
        }
        String schoolProvince=this.publishSchoolService.judgeIsNull(schoolProvinceList);
        String schoolType=this.publishSchoolService.judgeIsNull(schoolTypeList);
        String degreeType=this.publishSchoolService.judgeIsNull(degreeTypeList);
        String math=this.publishSchoolService.judgeIsNull(mathList);
        String english = this.publishSchoolService.judgeIsNull(englishList);

        /*String schoolProvince = String.join(",",schoolProvinceList);
        String schoolType = String.join(",",schoolTypeList);
        String degreeType = String.join(",",degreeTypeList);
        String math = String.join(",",mathList);
        String english = String.join(",",englishList);*/

        request.setAttribute("schoolList", schoolList);
        request.setAttribute("url", "displaySchoolBySearch");
        request.setAttribute("schoolProvince", schoolProvince);
        request.setAttribute("schoolType", schoolType);
        request.setAttribute("degreeType", degreeType);
        request.setAttribute("math", math);
        request.setAttribute("english", english);
        request.setAttribute("directionName", directionName);
        request.setAttribute("PageInfo",new PageInfo(schoolList,8));
        request.setAttribute("directionIds",directionIdList);

        System.out.println(schoolList);
        return "/school/schoolIndex";
    }

    @RequestMapping("/displayDirectionDetail")
    public String displayDirectionDetail(HttpServletRequest request,
                                        @RequestParam(value = "directionId") String directionId,
                                        @RequestParam(value = "sort",required = false) String sort){
        PublishDirection publishDirection = this.publishDirectionService.findDirectionByDirectionId(directionId,sort);
        request.setAttribute("publishDirection", publishDirection);
        System.out.println("[lalala]"+publishDirection);
        return "/school/schooldetail";
    }


    /*加入收藏夹*/
    @RequestMapping("/addDirectionCollector")
    public void addDirectionCollector(@RequestParam(value = "directionId") String directionId,
                                      HttpSession session,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws ServletException, IOException {
        Object obj = session.getAttribute("User");
        Long userId = null;
        if(obj != null){
            //用户已登录
            User user = (User)obj;
            userId = user.getUserId();
            //加入收藏夹
            this.publishDirectionCollectorService.insertDirectionCollector(userId, Long.parseLong(directionId));
        }else {
            //用户未登录
            System.out.println("用户没登录！！");
        }
        request.getRequestDispatcher("/displaySchoolBySearch").forward(request,response );
    }
}

