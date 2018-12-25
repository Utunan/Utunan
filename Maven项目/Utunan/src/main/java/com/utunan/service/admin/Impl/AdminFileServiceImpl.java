package com.utunan.service.admin.Impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.admin.AdminFileMapper;
import com.utunan.pojo.base.share.File;
import com.utunan.service.admin.AdminFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminFileService")
public class AdminFileServiceImpl implements AdminFileService {
    @Autowired
    private AdminFileMapper adminFileMapper;

    //获取未审核的文件
    @Override
    public List <File> getPedFiles(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<File> pedfiles=this.adminFileMapper.getPedFiles();
        return pedfiles;
    }

    //删除单个未审核资源
    @Override
    public void delprefile(Long fileId) {
        this.adminFileMapper.delprefile(fileId);
    }

    //批量删除未审核资源
    @Override
    public void delallprefile(Long[] b) {
        this.adminFileMapper.delallprefile(b);
    }

    //审核文件通过
    @Override
    public void updateprefile(Long fileId) {
        this.adminFileMapper.updateprefile(fileId);
    }

    //获取审核通过的文件
    @Override
    public List <File> getFiles(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<File> files=this.adminFileMapper.getFiles();
        return files;
    }

    //删除单个已审核文件
    @Override
    public void delfile(Long fileId) {
        this.adminFileMapper.delfile(fileId);
    }


    //批量删除已审核文件
    @Override
    public void delallfile(Long[] b) {
        this.adminFileMapper.delallfile(b);
    }

    //获取未审核文件数量
    @Override
    public Long getpedfilenum() {
        return this.adminFileMapper.getpedfilenum();
    }
}
