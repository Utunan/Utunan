package com.utunan;

import com.utunan.mapper.SchoolMapper;
import com.utunan.mapper.UserMapper;
import com.utunan.pojo.school.School;
import com.utunan.pojo.uerinfo.User;
import com.utunan.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TestMybatis {

    @Test
    public void m1() {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserTelephone("1512228198");
        user.setUserPassword("1998zh2003");
        user.setRegisterTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m2() {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryByTelephone("15226569565");
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m3() {
        SqlSession sqlSession = MybatisUtil.getSession();
        SchoolMapper schoolMapper = sqlSession.getMapper(SchoolMapper.class);
        School school = schoolMapper.queryByName("清华大学");
        System.out.println(school);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void m4() {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        System.out.println(list);
        sqlSession.commit();
        sqlSession.close();
    }
}
