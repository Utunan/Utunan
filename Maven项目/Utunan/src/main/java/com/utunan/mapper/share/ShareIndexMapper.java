package com.utunan.mapper.share;

import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.base.share.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShareIndexMapper {
    List<File> listFileByTime();
    List<File> listHotFile();
    List<String> listSchoolProvince();
    List<School> listSchool();
    List<File> selectFile(@Param("fileType") String fileType, @Param("fileSchool") String fileSchool, @Param("keyWord") String keyWord);
}
