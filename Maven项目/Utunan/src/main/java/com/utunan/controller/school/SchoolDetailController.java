package com.utunan.controller.school;

import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.DirectionCommentGreat;
import com.utunan.pojo.base.share.File;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.school.PublishDirection;
import com.utunan.pojo.inherit.user.PublishDirectionCollector;
import com.utunan.service.school.*;
import com.utunan.service.school.impl.ExcelOperateServiceImpl;
import com.utunan.service.user.PublishDirectionCollectorService;
import com.utunan.util.PythonCaller;
import com.utunan.util.SchoolOther;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.utunan.util.ExcelOperate.getData;

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
    /*@Autowired
    private UserService userService;*/
    @Autowired
    private DirectionCommentGreatService directionCommentGreatService;
    @Autowired
    private PublishDirectionCollectorService publishDirectionCollectorService;
    @Autowired
    private ExcelOperateServiceImpl excelOperateService;

    /*
     * @author  王碧云
     * @description 显示页面详情页
     * @date  17:08 2018/12/28/028
     * @param  [request, directionId, sort, session]
     * @return  java.lang.String
     */
    @RequestMapping("/schooldetail/{directionId}")
    public String displayDirectionDetail(HttpServletRequest request,
                                         @PathVariable String directionId,
                                         @RequestParam(value = "sort",required = false) String sort,
                                         HttpSession session){
        //获取当前用户
        User user = (User) session.getAttribute("User");

        //根据排序方式显示页面详情
        PublishDirection publishDirection = this.publishDirectionService.findDirectionByDirectionId(directionId,sort);
        //查找当前学校
        String schoolName = publishDirection.getSchoolName();
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
        File EGfile = this.schoolDetailFileService.findEGThisYear(fileType1,schoolName);
        File AGfile = this.schoolDetailFileService.findEGThisYear(fileType2,schoolName);
        //查找该学校下载量最多的前九的文件
        List<File> top9file = this.schoolDetailFileService.findTop9SchoolFile(schoolName);

        //问题推荐
        List schoolListRecommand= new ArrayList();

        //获取用户的点赞评论列表
        Long userId = null;
        if(user!=null){
            userId=user.getUserId();
            //产生推荐列表
            String path = request.getSession().getServletContext().getRealPath("/");
            String subPath=path.substring(0,path.indexOf("target\\Utunan"));
            List itemList= PythonCaller.quizRecommend(subPath+"src\\main\\data\\school.txt",subPath+"src\\main\\python\\schoolRecommend.py",userId);

            for(int i=0;i<itemList.size();i++){
                Direction directionRecom = this.directionService.findDirectionByDirectionId(Long.parseLong(itemList.get(i).toString()));
                schoolListRecommand.add(directionRecom);
            }

        }

//        //读取Excel数据
//        String path = request.getSession().getServletContext().getRealPath("/");
//        String subPath=path.substring(0,path.indexOf("target\\Utunan"));
//        java.io.File file = new java.io.File(subPath+"src\\main\\data\\分数线.xlsx");
//        String[][] result;
//        result = excelOperateService.getData(file, 1);
//
//        int rowLength = result.length;
//
//        for(int i=0;i<rowLength;i++) {
//
//            for(int j=0;j<result[i].length;j++) {
//
//                System.out.print(result[i][j]+"\t\t");
//
//            }
//
//            System.out.println();
//
//        }



        List<Long> directionCommentGreatList = this.directionCommentGreatService.findfindDCGreatList(userId);
    
        //返回数据
        request.setAttribute("publishDirection", publishDirection);
        request.setAttribute("directionCommentCount", directionCommentCount);
        request.setAttribute("viewCount",viewCount);
        request.setAttribute("EGfile", EGfile);
        request.setAttribute("AGfile", AGfile);
        request.setAttribute("year", year);
        request.setAttribute("top9file", top9file);
        request.setAttribute("schoolListRecommand",schoolListRecommand);
        request.setAttribute("user", user);
        request.setAttribute("directionCommentGreatList", directionCommentGreatList);

        return "/school/schooldetail";
    }
    /*
     * @author  王碧云
     * @description 插入评论
     * @date  17:08 2018/12/28/028
     * @param  [directionId, directionCommentContent, session]
     * @return  java.lang.String
     */
    @RequestMapping("/insertDirectionComment")
    public String insertDirectionComment(@RequestParam(value = "directionId",required = false) Long directionId,
                                         @RequestParam(value = "content",required = false) String directionCommentContent,
                                         HttpSession session){
        //获取当前用户
        User user = (User) session.getAttribute("User");
        Long userId = null;
        if(user != null){
            //用户已登录
            userId = user.getUserId();
        }
        //将评论插入评论表
        this.publishDirectionCommentService.insertDirectionComment(userId, directionId, directionCommentContent);

        //转去显示页面详情页
        return "redirect:/school/schooldetail/"+directionId;
    }
    /*
     * @author  王碧云
     * @description 删除评论（管理员或用户本人）
     * @date  17:09 2018/12/28/028
     * @param  [request, directionCommentId, directionId]
     * @return  java.lang.String
     */
    @RequestMapping("/deleteDirectionComment")
    public String deleteDirectionComment(HttpServletRequest request,
                                         @RequestParam("directionCommentId") String directionCommentId,
                                         @RequestParam(value = "directionId",required = false) Long directionId){
        //删除评论
        this.publishDirectionCommentService.deleteDirectionComment(Long.parseLong(directionCommentId));

        //转去显示页面详情页
        return "redirect:/school/schooldetail/"+directionId;
    }
    
    /*
     * @author  王碧云
     * @description 修改点赞数
     * @date  21:14 2018/12/19/019
     * @param  [session, request, response]
     * @return  void
     */
    @ResponseBody
    @RequestMapping(value = "/updateDCPraiseCount",method = RequestMethod.POST)
    public void updateDirectionCommentPraiseCount(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String directionCommentId = request.getParameter("directionCommentId");
        User user = (User) session.getAttribute("User");
        //到院校评论点赞表进行查询是否有记录
        DirectionCommentGreat directionCommentGreat = this.directionCommentGreatService.findDCGreat(Long.parseLong(directionCommentId),user.getUserId());
        //创建JSON
        JSONObject obj=new JSONObject();
        //判断是否有记录
        if(directionCommentGreat==null){
            //可以点赞
            directionCommentGreatService.insertDCGreat(Long.parseLong(directionCommentId),user.getUserId());
            this.publishDirectionCommentService.addDCPraiseCount(Long.parseLong(directionCommentId));
            //查找当前点赞数
            Long praiseCount = this.publishDirectionCommentService.findPDC(Long.parseLong(directionCommentId)).getDirectionCommentPraiseCount();
            //加入json
            obj.put("res", "ok");
            obj.put("praiseCount", praiseCount);
            //返回数据
            response.getWriter().append(obj.toString());
        }else {
            //不能点赞
            this.directionCommentGreatService.deleteDCGreat(Long.parseLong(directionCommentId),user.getUserId());
            this.publishDirectionCommentService.delDCPraiseCount(Long.parseLong(directionCommentId));
            //查找当前点赞数
            Long praiseCount = this.publishDirectionCommentService.findPDC(Long.parseLong(directionCommentId)).getDirectionCommentPraiseCount();
            //加入json
            obj.put("res", "no");
            obj.put("praiseCount", praiseCount);
            //返回数据
            response.getWriter().append(obj.toString());
        }
    }
    /*
     * @author  王碧云
     * @description 加入院校收藏夹
     * @date  15:47 2018/12/24/024
     * @param  [directionId, session, response]
     * @return  void
     */
    @RequestMapping("/addDController")
    public void addDController(@RequestParam(value = "directionId") String directionId,
                               HttpSession session, HttpServletResponse response) throws IOException {
        User user = (User) session.getAttribute("User");
        //到院校收藏表里查看是否有记录
        PublishDirectionCollector pdc = this.publishDirectionCollectorService.findDCollector(Long.parseLong(directionId),user.getUserId());
        //创建JSON
        JSONObject obj=new JSONObject();
        //判断是否有记录
        if(pdc==null){
            //没有记录，则添加收藏
            this.publishDirectionCollectorService.insertDirectionCollector(user.getUserId(), Long.parseLong(directionId));
            obj.put("res", "ok");
            response.getWriter().append(obj.toString());
        }else {
            //有记录，返回已收藏
            obj.put("res", "already");
            response.getWriter().append(obj.toString());
        }
    }
}
