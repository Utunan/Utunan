package com.utunan.service.school;

import com.utunan.pojo.base.share.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/12/012 10:14
 */
public interface SchoolDetailFileService {

    /*
     * @author  王碧云
     * @description 查找今年的招生简章或招生目录
     * @date  10:58 2018/12/12/012
     * @param  [fileSchool]
     * @return  com.utunan.pojo.base.share.File
     */
    List<File> findEGThisYear(String fileType,String fileSchool);
    /*
     * @author  王碧云
     * @description 查找往年的招生简章或招生目录
     * @date  15:49 2018/12/12/012
     * @param  [fileType, fileSchool]
     * @return  java.util.List<com.utunan.pojo.base.share.File>
     */
    List<File> findEGFormerYears(String fileType,String fileSchool);
}
