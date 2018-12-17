package com.utunan.mapper.share;

import com.utunan.pojo.base.share.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShareuploadMapper {

    void insertfile(File file);

    Long getSuffix(@Param("suffixName") String suffixName);

    //获取最大fileId
    Long getMaxfileId();
}
