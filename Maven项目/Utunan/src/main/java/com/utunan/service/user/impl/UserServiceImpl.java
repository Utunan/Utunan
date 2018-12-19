package com.utunan.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.user.PublishQuizMapper;
import com.utunan.mapper.user.QuestionCollectorMapper;
import com.utunan.mapper.user.UserMapper;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.pojo.base.user.Member;
import com.utunan.pojo.base.user.Message;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import com.utunan.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PublishQuizMapper publishQuizMapper;
    @Autowired
    private QuestionCollectorMapper questionCollectorMapper;

    @Override
    public User getUser(User user) {
        User u = null;
        if (user.getUserEmail() != null) {
            if (StringUtil.isEmail(user.getUserEmail())) {
                u = userMapper.selectByPermit(user);
            }else{
                u = userMapper.selectByP(user);
            }
        }else {
            u = userMapper.selectByP(user);
        }
        return u;
    }

    @Override
    public Member getUserById(String userId) {
        Member member = new Member();
        User user = userMapper.selectByUserId(Long.parseLong(userId));
        if (user == null)
            return null;
        member.setUser(user);
        PageHelper.startPage(1, 5);
        List<User> users = userMapper.selectFollowUser(user);
        PageHelper.startPage(1, 5);
        List<Question> questions = questionCollectorMapper.selectQuestionCollector(user);
        PageHelper.startPage(1, 5);
        List<Quiz> quizzes = publishQuizMapper.selectPublishQuiz(user);
        member.setQuestions(questions);
        member.setQuizzes(quizzes);
        member.setUsers(users);
        return member;
    }

    @Override
    public Integer getUserMessageCount(User user) {
        Integer messageCount=userMapper.selectUserMessage(user);
        return messageCount;
    }

    @Override
    public void saveUser(User user) {
        Date date = new Date();
        int x = (int) (Math.random() * 100);
        String userNickName = "Utunan" + (int) ((Math.random() * 9 + 1) * 100000) + date.getTime() % 10000000;
        user.setUserNickName(userNickName);
        user.setRegisterTime(date);
        userMapper.insert(user);
    }

    @Override
    public boolean isExist(User user) {
        User u = userMapper.selectByPorE(user);
        if (u != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean changeInfo(User user) {
        userMapper.updateUser(user);
        return true;
    }

    @Override
    public User changeUserPassword(User user) {
        userMapper.updateUserPassword(user);
        User updateUser = userMapper.selectByPermit(user);
        return updateUser;
    }

    @Override
    public List<Message> getUserReadInfo(User user,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Message> messages=userMapper.selectUserAllReadInfo(user);
        return  messages;
    }

    @Override
    public List<Message> getUserNoReadInfo(User user,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Message> messages=userMapper.selectUserAllNoReadInfo(user);
        return  messages;
    }

    @Override
    public boolean changeUserHeadImg(User user, String userHeadImg) {

        userMapper.updateUserHeadImg(user.getUserId(), userHeadImg);
        return true;
    }

    @Override
    public boolean changeUserTelephone(User user) {
        userMapper.updateUserTelephone(user);
        return true;
    }

    @Override
    public boolean changeUserEmail(User user) {
        userMapper.updateUserEmail(user);
        return true;
    }

    @Override
    public List<User> getAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAllUser();
        return users;
    }

    @Override
    public List<User> getAllMember(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAllMember();
        return users;
    }

    @Override
    public List<User> getAllAdmin(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> admins = userMapper.selectAllAdmin();
        return admins;
    }
}
