package com.utunan.controller.school;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.share.File;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.school.PublishDirection;
import com.utunan.service.questionbank.PublishDirectionCommentService;
import com.utunan.service.school.DirectionService;
import com.utunan.service.school.PublishDirectionService;
import com.utunan.service.school.SchoolDetailFileService;
import com.utunan.util.SchoolOther;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 王碧云
 * @description: 学校详情控制
 * @date 2018/12/7/007 21:19
 */
@Controller
@RequestMapping("/school")
public class SchoolDetailController {

    @Autowired
    private PublishDirectionService publishDirectionService;
    @Autowired
    private PublishDirectionCommentService publishDirectionCommentService;
    @Autowired
    private DirectionService directionService;
    @Autowired
    private SchoolDetailFileService schoolDetailFileService;

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
                                         @RequestParam(value = "sort",required = false) String sort,
                                         @RequestParam("schoolName") String schoolName){
        //根据分页方式显示页面详情
        PublishDirection publishDirection = this.publishDirectionService.findDirectionByDirectionId(directionId,sort);
        //获取评论的长度
        int directionCommentCount =publishDirection.getDirectionComments().size();
        //获取页面浏览次数
        this.directionService.updateviewCount(Long.parseLong(directionId));
        Long viewCount = this.directionService.findDirectionByDirectionId(Long.parseLong(directionId)).getViewCount();
        //设置招生简章年份
        SchoolOther so = new SchoolOther();
        String year = so.theYear();
        //搜索招生简章文件和招生专业目录
        String fileType1 = "招生简章";
        String fileType2 = "招生专业目录";
        List<File> EGfile = this.schoolDetailFileService.findEGThisYear(fileType1,schoolName);
        List<File> AGfile = this.schoolDetailFileService.findEGThisYear(fileType2,schoolName);
        //查找该学校下载量最多的前九的文件
        List<File> top9file = this.schoolDetailFileService.findTop9SchoolFile(schoolName);

        //返回数据
        request.setAttribute("publishDirection", publishDirection);
        request.setAttribute("directionCommentCount", directionCommentCount);
        request.setAttribute("viewCount",viewCount);
        request.setAttribute("EGfile", EGfile);
        request.setAttribute("AGfile", AGfile);
        request.setAttribute("year", year);
        request.setAttribute("top9file", top9file);
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
    public String updateDirectionCommentPraiseCount(@RequestParam(value = "directionCommentId") String directionCommentId,
                                                    @RequestParam(value = "directionId",required = false) Long directionId){
        //修改点赞数量
        Long praiseCount = this.publishDirectionCommentService.updateDirectionCommentPraiseCount(Long.parseLong(directionCommentId));

        return "redirect:/school/displayDirectionDetail?directionId="+directionId;
    }

    /*
     * @author  王碧云
     * @description 查看今年的招生简章
     * @date  9:00 2018/12/12/012
     * @param  []
     * @return  java.lang.String
     */
    @RequestMapping("displayEG")
    public String displayEG(@RequestParam("schoolName") String schoolName,
                            @RequestParam("fileType") String fileType,
                            HttpServletRequest request){
        //搜索招生简章文件
        List<File> fileList = this.schoolDetailFileService.findEGThisYear(fileType,schoolName);

        //返回数据
        request.setAttribute("fileList", fileList);
        request.setAttribute("url", "searchfile");
        return "share/share";
    }
    /*
     * @author  王碧云
     * @description 查看往年的招生简章
     * @date  15:29 2018/12/12/012
     * @param  []
     * @return  java.lang.String
     */
    @RequestMapping("displayEGFormerYears")
    public String displayEGFormerYears(@RequestParam("schoolName") String schoolName,
                                       @RequestParam("fileType") String fileType,
                                       HttpServletRequest request){
        //搜索往年的招生简章
        List<File> fileList = this.schoolDetailFileService.findEGFormerYears(fileType,schoolName);
        //返回数据
        request.setAttribute("fileList", fileList);
        request.setAttribute("url", "searchfile");
        return "share/share";
    }

    /*
     * @author  王碧云
     * @description 将评论插入院校评论（正在实现）
     * @date  9:31 2018/12/6/006
     * @param  [directionId, request, session]
     * @return  void
     */
    @RequestMapping("/insertDirectionComment")
    public String insertDirectionComment(@RequestParam(value = "directionId",required = false) Long directionId,
                                              @RequestParam(value = "content",required = false) String directionCommentContent,
                                              @RequestParam("schoolName") String schoolName,
                                              HttpSession session,
                                              RedirectAttributes attr){
        //获取当前用户
        User user = (User) session.getAttribute("User");
        Long userId = null;
        if(user != null){
            //用户已登录
            userId = user.getUserId();
            //插入评论
        }else {
            //用户未登录
            System.out.println("用户没登录！！");
        }
        //将评论插入评论表
        this.publishDirectionCommentService.insertDirectionComment(userId, directionId, directionCommentContent);

        //添加地址栏参数
        attr.addAttribute("directionId", directionId);
        attr.addAttribute("schoolName", schoolName);

        //转去显示页面详情页
        return "redirect:/school/displayDirectionDetail";
    }



}
