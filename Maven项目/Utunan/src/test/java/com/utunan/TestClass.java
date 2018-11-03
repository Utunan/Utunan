package com.utunan;

import com.utunan.mapper.UserMapper;
import com.utunan.pojo.User;
import com.utunan.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TestClass {

    @Test
    public void m1() {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUserTelephone("15122221523");
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
        User user=mapper.quetyByTelephoneIdentity("15122221523","3");
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
