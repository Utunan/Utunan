package com.utunan.util;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.service.community.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 唐溪
 * @description: TODO
 * @date 2019/5/30 11:02
 */
public class PythonCaller {

    @Autowired
    private static QuizService quizService;

    public static List quizRecommend(String data, String pyFile,Long userId){

        List itemList = new ArrayList();
        try {
            String[] args1 = new String[] { "python", pyFile, String.valueOf(data),String.valueOf(userId)};
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String  line = null;
            while ((line =in.readLine()) != null) {
                itemList.add(line);
            }
            in.close();
            proc.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return itemList;
    }
}
