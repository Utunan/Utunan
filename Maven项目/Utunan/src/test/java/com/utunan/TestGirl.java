package com.utunan;

import com.utunan.mapper.GirlMapper;
import com.utunan.pojo.Girl;
import com.utunan.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class TestGirl {
    @Test
    public void ml(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlMapper mapper=sqlSession.getMapper(GirlMapper.class);
        Girl girl=new Girl();
        girl.setName("666");
        girl.setFlower("康乃馨");
        girl.setBirthday(new Date());
        mapper.insert(girl);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m2(){

        SqlSession sqlSession= MybatisUtil.getSession();
        GirlMapper mapper=sqlSession.getMapper(GirlMapper.class);
        Girl girl=mapper.queryById(1L);
        System.out.println(girl.getName());
        sqlSession.close();

    }
    @Test
    public void m3(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlMapper mapper=sqlSession.getMapper(GirlMapper.class);
        Girl girl=mapper.queryByName("666");
        System.out.println(girl.getName());
        sqlSession.close();
    }

}
