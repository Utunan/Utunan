package com.utunan.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resouces = "mybatis.cfg.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resouces);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream == null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }

}
