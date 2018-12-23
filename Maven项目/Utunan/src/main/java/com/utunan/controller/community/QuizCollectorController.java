package com.utunan.controller.community;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.QuizCollector;
import com.utunan.pojo.base.user.User;
import com.utunan.service.community.QuizCollectService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/5 20:26
 */
@Controller
public class QuizCollectorController {

    @Autowired
    private QuizCollectService quizCollectService;

    @ResponseBody
    @RequestMapping(value = "/quizCollector")
    public void quizCollector(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
        String quizId = request.getParameter("quizId");
        Quiz quiz = (Quiz) session.getAttribute("quiz");

        User user1 = (User) session.getAttribute("User");
        Long qcid = quizCollectService.getMaxQCid();
        qcid += 1;
        //判断用户是否点赞
        QuizCollector quizCollector = this.quizCollectService.getQuizCollector(Long.parseLong(quizId), user1.getUserId());
        //创建JSON
        JSONObject obj = new JSONObject();
        if (quizCollector == null) {
            //没有记录添加收藏
            this.quizCollectService.insertQuizCollector(qcid, user1, quiz);
            obj.put("res", "ok");
            response.getWriter().append(obj.toString());
        } else {
            //有记录取消收藏
            this.quizCollectService.delQuizCollector(Long.parseLong(quizId), user1.getUserId());
            obj.put("res", "no");
            response.getWriter().append(obj.toString());
        }
    }
}
