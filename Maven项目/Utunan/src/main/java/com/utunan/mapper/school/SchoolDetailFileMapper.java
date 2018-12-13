package com.utunan.mapper.school;

import com.utunan.pojo.base.share.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/12/012 10:09
 */
@Mapper
@Repository
public interface SchoolDetailFileMapper {
    /*查找今年的招生简章或招生目录*/
    List<File> findEGThisYear(@Param("fileType") String fileType, @Param("fileSchool") String fileSchool, @Param("year") String year);
   /*相应学校的热门资料（按下载次数排序）*/
    List<File> findTop9SchoolFile(@Param("fileSchool") String fileSchool);
}
