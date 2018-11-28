package com.utunan.util;

import java.awt.*;
import java.util.Random;

/**
 * @author 王碧云
 * @description: 图片验证码
 * @date 2018/11/26/026 20:16
 */
public class RandPic {

    //  设置字符
    public static final char[] chars="1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();

    //  设置随机数
    public static Random random = new Random();

    //  获取4位随机数
    public static String getRandomString(){
        StringBuffer buffer = new StringBuffer();
        int index;   //获取随机chars下标
        for(int i=0;i<4;i++){
            index = random.nextInt(chars.length);  //获取随机chars下标
            buffer.append(chars[index]);
        }
        return buffer.toString();
    }

    //  获取随机颜色
    public static Color getRandomColor(){
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    //  返回某颜色的反色
    public static Color getReverseColor(Color c){
        //防止反色和原色相近
        if(c.getRed()<130&&c.getRed()>125 && c.getBlue()<130&& c.getBlue()>125 &&
                c.getGreen()<130&&c.getGreen()>125){
            return new Color(255,255,255);
        }else{
            return new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue());
        }
    }
}
