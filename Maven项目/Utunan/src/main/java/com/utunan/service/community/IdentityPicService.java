package com.utunan.service.community;

import com.utunan.pojo.base.community.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/11/26/026 20:22
 */
public interface IdentityPicService {

    /*
     * @author  王碧云
     * @description 获取验证码图片
     * @date  20:24 2018/11/26/026
     * @param  [req, resp]
     * @return  void
     */
    void getIdentityPic(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
