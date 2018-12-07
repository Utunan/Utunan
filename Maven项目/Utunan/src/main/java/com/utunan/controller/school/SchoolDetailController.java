package com.utunan.controller.school;

import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.school.PublishDirection;
import com.utunan.service.questionbank.PublishDirectionCommentService;
import com.utunan.service.school.PublishDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 王碧云
 * @description: 学校详情控制
 * @date 2018/12/7/007 21:19
 */
@Controller
public class SchoolDetailController {

    @Autowired
    private PublishDirectionService publishDirectionService;
    @Autowired
    private PublishDirectionCommentService publishDirectionCommentService;

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

        return "redirect:/displayDirectionDetail?directionId="+directionId;
    }

    /*
     * @author  王碧云
     * @description 将评论插入院校评论（未实现，请不要抱有希望）
     * @date  9:31 2018/12/6/006
     * @param  [directionId, request, session]
     * @return  void
     */
    @RequestMapping("/insertDirectionCommentContent")
    public void insertDirectionCommentContent(@RequestParam(value = "directionId",required = false) Long directionId,
                                              @RequestParam(value = "directionCommentContent",required = false) String directionCommentContent,
                                              HttpServletRequest request,
                                              HttpSession session){
        //获取当前用户
        Object obj = session.getAttribute("User");
        Long userId = null;
        if(obj != null){
            //用户已登录
            User user = (User)obj;
            userId = user.getUserId();
            //插入评论
        }else {
            //用户未登录
            System.out.println("用户没登录！！");
        }

    }

}
