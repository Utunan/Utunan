package com.utunan.controller.school;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.school.PublishSchool;
import com.utunan.pojo.util.Analyzer;
import com.utunan.util.SchoolOther;
import com.utunan.service.school.PublishSchoolService;
import com.utunan.service.user.PublishDirectionCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王碧云
 * @description: 院校库首页控制
 * @date 2018/11/27/027 20:34
 */
@Controller
@RequestMapping("/school")
public class SchoolSearchController {
    @Autowired
    private PublishSchoolService publishSchoolService;
    @Autowired
    private PublishDirectionCollectorService publishDirectionCollectorService;

    /*
     * @author  王碧云
     * @description 显示院校库初始页面
     * @date  15:51 2018/12/16/016
     * @param  [request, pageNum, session]
     * @return  java.lang.String
     */
    @RequestMapping("/displaySchool")
    public String displaySchool(HttpServletRequest request,
                                @RequestParam(value = "pageNum",required = false) String pageNum,
                                HttpSession session){
        User user = (User) session.getAttribute("User");
        Long userId = null;
        if(user != null){
            //用户已登录
            userId = user.getUserId();
        }
        //查找收藏的院校Id
        List<Long> directionIdList = this.publishDirectionCollectorService.findDirectionIdByUser(userId);
        //查询列表并分页
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
        request.setAttribute("user", user);

        return "/school/schoolIndex";
    }

    /*
     * @author  王碧云
     * @description 根据搜索返回结果页面
     * @date  15:52 2018/12/16/016
     * @param  [request, schoolProvinceList, schoolTypeList, degreeTypeList, mathList, englishList, directionName, pageNum, session]
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
        //对搜索框内容进行分词
        Analyzer analyzer = new Analyzer();
        directionName = analyzer.filter(directionName);
        List<String> directionNameList = new ArrayList<>();
        if(directionName.equals("") || directionName==null){
            directionNameList.add(".");
        }else{
            //对搜索条件进行分词
            try {
                directionNameList = analyzer.Analyzer(directionName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        SchoolOther so = new SchoolOther();
        //判断搜索条件是否为空
        schoolProvinceList=so.ifListIsNull(schoolProvinceList);
        schoolTypeList=so.ifListIsNull(schoolTypeList);
        degreeTypeList=so.ifListIsNull(degreeTypeList);
        mathList=so.ifListIsNull(mathList);
        englishList=so.ifListIsNull(englishList);

        //获取用户
        User user = (User) session.getAttribute("User");
        Long userId = null;
        if(user != null){
            //用户已登录
            userId = user.getUserId();
        }
        //查找收藏的院校Id
        List<Long> directionIdList = this.publishDirectionCollectorService.findDirectionIdByUser(userId);
        //搜索学校列表并分页
        List<PublishSchool> schoolList =null;
        if(pageNum == null ||pageNum == ""|| Integer.parseInt(pageNum) <= 0){
            schoolList = this.publishSchoolService.findSchoolByAllParam(schoolProvinceList, schoolTypeList,degreeTypeList,mathList,englishList,directionNameList,1,15);
        }else{
            schoolList = this.publishSchoolService.findSchoolByAllParam(schoolProvinceList, schoolTypeList,degreeTypeList,mathList,englishList,directionNameList,Integer.parseInt(pageNum),15);
        }
        //将String[]转为String
        String schoolProvince=so.listToString(schoolProvinceList);
        String schoolType=so.listToString(schoolTypeList);
        String degreeType=so.listToString(degreeTypeList);
        String math=so.listToString(mathList);
        String english = so.listToString(englishList);

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
        request.setAttribute("user", user);

        return "/school/schoolIndex";
    }

    /*
     * @author  王碧云
     * @description 将院校加入收藏夹
     * @date  16:01 2018/12/16/016
     * @param  [directionId, schoolProvinceList, schoolTypeList, degreeTypeList, mathList, englishList, directionName, pageNum, session, attr]
     * @return  java.lang.String
     */
    @RequestMapping("/addDirectionCollector")
    public String addDirectionCollector(@RequestParam(value = "directionId") String directionId,
                                        @RequestParam(value = "schoolProvince",required = false) String[] schoolProvinceList,
                                        @RequestParam(value = "schoolType",required = false) String[] schoolTypeList,
                                        @RequestParam(value = "degreeType",required = false) String[] degreeTypeList,
                                        @RequestParam(value = "math",required = false) String[] mathList,
                                        @RequestParam(value = "english",required = false) String[] englishList,
                                        @RequestParam(value = "directionName",required = false) String directionName,
                                        @RequestParam(value = "pageNum",required = false) String pageNum,
                                        HttpSession session,
                                        RedirectAttributes attr){
        //获取当前用户
        User user = (User) session.getAttribute("User");
        if (user != null) {
            //用户已登录,则加入收藏夹
            this.publishDirectionCollectorService.insertDirectionCollector(user.getUserId(), Long.parseLong(directionId));
        }
        //将String[]转为String
        SchoolOther so = new SchoolOther();
        String schoolProvince = so.listToString(schoolProvinceList);
        String schoolType = so.listToString(schoolTypeList);
        String degreeType = so.listToString(degreeTypeList);
        String math = so.listToString(mathList);
        String english = so.listToString(englishList);
        //添加地址栏参数
        attr.addAttribute("schoolProvince", schoolProvince);
        attr.addAttribute("schoolType", schoolType);
        attr.addAttribute("degreeType", degreeType);
        attr.addAttribute("math", math);
        attr.addAttribute("english", english);
        attr.addAttribute("directionName", directionName);
        attr.addAttribute("pageNum", pageNum);


        return "redirect:/school/displaySchoolBySearch";
    }
    /*
     * @author  王碧云
     * @description 取消院校收藏
     * @date  16:09 2018/12/16/016
     * @param  [directionId, schoolProvinceList, schoolTypeList, degreeTypeList, mathList, englishList, directionName, pageNum, session, attr]
     * @return  java.lang.String
     */
    @RequestMapping("/deleteDirectionCollector")
    public String deleteDirectionCollector(@RequestParam(value = "directionId") String directionId,
                                           @RequestParam(value = "schoolProvince",required = false) String[] schoolProvinceList,
                                           @RequestParam(value = "schoolType",required = false) String[] schoolTypeList,
                                           @RequestParam(value = "degreeType",required = false) String[] degreeTypeList,
                                           @RequestParam(value = "math",required = false) String[] mathList,
                                           @RequestParam(value = "english",required = false) String[] englishList,
                                           @RequestParam(value = "directionName",required = false) String directionName,
                                           @RequestParam(value = "pageNum",required = false) String pageNum,
                                           HttpSession session,
                                           RedirectAttributes attr){
        //获取当前用户
        User user =(User)session.getAttribute("User");
        //获取当前用户的Id
        Long userId = user.getUserId();
        //根据用户Id和院校Id删除院校收藏
        this.publishDirectionCollectorService.deleteDirectionCollector(userId, Long.parseLong(directionId));
        //将String[]转为String
        SchoolOther so = new SchoolOther();
        String schoolProvince = so.listToString(schoolProvinceList);
        String schoolType = so.listToString(schoolTypeList);
        String degreeType = so.listToString(degreeTypeList);
        String math = so.listToString(mathList);
        String english = so.listToString(englishList);
        //添加地址栏参数
        attr.addAttribute("schoolProvince", schoolProvince);
        attr.addAttribute("schoolType", schoolType);
        attr.addAttribute("degreeType", degreeType);
        attr.addAttribute("math", math);
        attr.addAttribute("english", english);
        attr.addAttribute("directionName", directionName);
        attr.addAttribute("pageNum", pageNum);

        //返回数据
        return "redirect:/school/displaySchoolBySearch";
    }

}

