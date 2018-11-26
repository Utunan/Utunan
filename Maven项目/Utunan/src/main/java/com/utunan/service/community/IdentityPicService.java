package com.utunan.service.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    void getIdentityPic(HttpServletRequest req, HttpServletResponse resp) throws IOException;

}
