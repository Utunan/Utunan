package com.utunan.controller.school;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.questionbank.PublishDirectionComment;
import com.utunan.pojo.inherit.school.PublishDirection;
import com.utunan.pojo.inherit.school.PublishSchool;
import com.utunan.service.questionbank.PublishDirectionCommentService;
import com.utunan.service.school.PublishDirectionService;
import com.utunan.service.school.PublishSchoolService;
import com.utunan.service.user.PublishDirectionCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
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
    @Autowired
    private PublishDirectionCommentService publishDirectionCommentService;
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

    /*
     * @author  王碧云
     * @description 将院校加入收藏夹
     * @date  14:03 2018/12/5/005
     * @param  [directionId, session, request, response]
     * @return  void
     */
    @RequestMapping("/addDirectionCollector")
    public void addDirectionCollector(@RequestParam(value = "directionId") String directionId,
                                      HttpSession session,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws ServletException, IOException {
        //获取当前用户
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
    /*
     * @author  王碧云
     * @description 将院校在收藏夹中删除
     * @date  14:06 2018/12/5/005
     * @param  []
     * @return  void
     */
    @RequestMapping("/deleteDirectionCollector")
    public void deleteDirectionCollector(@RequestParam(value = "directionId") String directionId,
                                         HttpSession session,
                                         HttpServletRequest request,
                                         HttpServletResponse response) throws ServletException, IOException {
        //获取当前用户
        User user =(User)session.getAttribute("User");
        //获取当前用户的Id
        Long userId = user.getUserId();
        //根据用户Id和院校Id删除院校收藏
        this.publishDirectionCollectorService.deleteDirectionCollector(userId, Long.parseLong(directionId));
        //返回数据
        request.getRequestDispatcher("/displaySchoolBySearch").forward(request,response );
    }
    /*
     * @author  王碧云
     * @description 显示页面详情页
     * @date  11:16 2018/12/5/005
     * @param  [request, directionId, sort]
     * @return  java.lang.String
     */
    @RequestMapping("/displayDirectionDetail")
    public String displayDirectionDetail(HttpServletRequest request,
                                         @RequestParam(value = "directionId") String directionId,
                                         @RequestParam(value = "sort",required = false) String sort){
        //根据分页方式显示页面详情
        PublishDirection publishDirection = this.publishDirectionService.findDirectionByDirectionId(directionId,sort);
        //获取评论的长度
        int directionCommentCount =publishDirection.getDirectionComments().size();

        //返回数据
        request.setAttribute("publishDirection", publishDirection);
        request.setAttribute("directionCommentCount", directionCommentCount);
        System.out.println("[lalala]"+publishDirection);
        return "/school/schooldetail";
    }

    /*
     * @author  王碧云
     * @description 修改点赞数
     * @date  9:11 2018/12/6/006
     * @param  [directionCommentId, directionId, request, response]
     * @return  void
     */
    @RequestMapping("/updateDirectionCommentPraiseCount")
    public void updateDirectionCommentPraiseCount(@RequestParam(value = "directionCommentId") String directionCommentId,
                                                    @RequestParam(value = "directionId",required = false) Long directionId,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) throws ServletException, IOException {
        //修改点赞数量
        Long praiseCount = this.publishDirectionCommentService.updateDirectionCommentPraiseCount(Long.parseLong(directionCommentId));

        request.getRequestDispatcher("/displayDirectionDetail?directionId="+directionId).forward(request,response );
    }
}

