package com.utunan.service.community.impl;

import com.utunan.service.community.IdentityPicService;
import com.utunan.util.RandPic;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author 王碧云
 * @description: 验证码图片
 * @date 2018/11/26/026 20:24
 */
@Service("identityPicService")
public class IdentityPicServiceImpl implements IdentityPicService {
    /*
     * @author  王碧云
     * @description 获取验证码图片
     * @date  20:30 2018/11/26/026
     * @param  [req, resp]
     * @return  void
     */
    @Override
    public void getIdentityPic(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        RandPic randPic = new RandPic();
        String code = randPic.getRandomString();  //获取随机验证码
        req.getSession().setAttribute("code", code); //放入Session

        int width = 100;    //图片宽度
        int height = 38;    //图片高度

        Color color =   randPic.getRandomColor();  //随机色，用于背景色
        Color reverse = randPic.getReverseColor(color);  //反色，用于前景色


        /**
         * 生成带字符串的文本图片
         */
        //1.创建图片缓存区     传参为宽高和图片类型
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.获取画笔并绘画
        Graphics g = bi.getGraphics();
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));//设置字体
        g.setColor(color);//设置画笔颜色
        g.fillRect(0, 0, width, height);   //绘制背景
        g.setColor(reverse);   //设置画笔颜色
        g.drawString(code, 18, 20); //绘制字符
        //设置最多100个噪音点
        for(int i=0,n = randPic.random.nextInt(50);i<n;i++){
            g.drawRect(randPic.random.nextInt(width), randPic.random.nextInt(height), 1, 1);
        }

        //3.输出图片
        ImageIO.write(bi, "JPG", resp.getOutputStream());
    }
}
