package com.utunan.util;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/6 17:14
 */
public class WordLimitUtil {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isNull(String str){
        if(str==null||str.trim().equals("")||str.trim().equalsIgnoreCase("null")){
            return false;
        }else{
            return true;
        }
    }



    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为1,英文字符长度为0.5
     * @param  s 需要得到长度的字符串
     * @return int 得到的字符串长度
     */
    public static double getLength(String s) {
        double valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < s.length(); i++) {
            // 获取一个字符
            String temp = s.substring(i, i + 1);
            // 判断是否为中文字符
            if (temp.matches(chinese)) {
                // 中文字符长度为1
                valueLength += 1;
            } else {
                // 其他字符长度为0.5
                valueLength += 0.5;
            }
        }
        //进位取整
        return  Math.ceil(valueLength);
    }



}
