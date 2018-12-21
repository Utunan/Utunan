package com.utunan.service.admin;

import com.utunan.pojo.base.share.File;

import java.util.List;

public interface AdminFileService {
    //获取未经过审核的资源
    List<File> getPedFiles(int pageNum, int pageSize);

    //删除单个未审核资源
    void delprefile(Long fileId);

    //批量删除未审核资源
    void delallprefile(Long[] b);

    //审核文件通过
    void updateprefile(Long fileId);
}
