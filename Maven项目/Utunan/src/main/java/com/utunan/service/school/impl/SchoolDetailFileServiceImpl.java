package com.utunan.service.school.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.school.SchoolDetailFileMapper;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.base.share.File;
import com.utunan.service.school.SchoolDetailFileService;
import com.utunan.util.SchoolOther;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/12/012 10:17
 */
@Service("schoolDetailFileService")
public class SchoolDetailFileServiceImpl implements SchoolDetailFileService {
    @Autowired
    private SchoolDetailFileMapper schoolDetailFileMapper;

    @Override
    public List<File> findEGThisYear(String fileType,String fileSchool) {
        //确定文件年份
        SchoolOther so = new SchoolOther();
        String year = so.theYear();
        //查找文件
        List<File> EGfile = this.schoolDetailFileMapper.findEGThisYear(fileType, fileSchool, year);
        return EGfile;
    }

    @Override
    public List<File> findEGFormerYears(String fileType,String fileSchool) {
        return this.schoolDetailFileMapper.findEGFormerYears(fileType, fileSchool);
    }

    @Override
    public List<File> findTop9SchoolFile(String fileSchool) {
        return this.schoolDetailFileMapper.findTop9SchoolFile(fileSchool);
    }
}
