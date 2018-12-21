package com.utunan.mapper.admin;

import com.utunan.pojo.base.share.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminFileMapper {
    //获取所有未审核的文件
    List<File> getPedFiles();

    //删除单个未审核文件
    void delprefile(@Param("fileId") Long fileId);

    //批量删除未审核资源
    void delallprefile(@Param("b") Long[] b);

    //审核文件通过
    void updateprefile(@Param("fileId") Long fileId);

    //获取审核通过的文件
    List<File> getFiles();

    //删除单个已审核文件
    void delfile(@Param("fileId") Long fileId);

    //批量删除已审核文件
    void delallfile(@Param("b") Long[] b);
}
