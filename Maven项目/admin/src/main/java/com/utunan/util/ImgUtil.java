package com.utunan.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImgUtil {

    /**
     * 图片指定大小进行缩放
     *
     * @throws IOException
     */
    public static void  changeImgSize(String path1,String path2,int height,int width) {

        File f=new File(path1);

        try {
            Thumbnails.of(f.toString()).size(height, width).toFile(path2);
            f.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //base64字符串转化成图片
    public static boolean base64StrToImage(String imgStr, String path)
    {    if (imgStr == null)
        return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] decoderBytes = Base64.decodeBase64(imgStr.replace("data:image/png;base64,",""));
            imgStr = imgStr.replace("base64,","");
            // 处理数据
            for (int i = 0; i < decoderBytes.length; ++i) {
                if (decoderBytes[i] < 0) {
                    decoderBytes[i] += 256;
                }
            }
            //文件夹不存在则自动创建
            File tempFile = new File(path);
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(tempFile);
            out.write(decoderBytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
