package com.utunan.mapper.share;

import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.base.share.File;
import com.utunan.pojo.base.share.FileGreat;
import com.utunan.pojo.base.share.UserDownload;
import com.utunan.pojo.base.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShareIndexMapper {
    List<File> listFileByTime();
    List<File> listHotFile();
    List<String> listSchoolProvince();
    List<School> listSchool();
    List<File> selectFile(@Param("fileType") String[] fileType, @Param("fileSchool") String fileSchool, @Param("keyWord") String keyWord);
    File findFileById(@Param("fileId") Long fileId);
    List<File> selectFileByTitle(@Param("fileTitle") String fileTitle);
    void updateUserIntegral(@Param("userId") Long userId, @Param("userIntegral") Long userIntegral);
    void insertUserDownload(@Param("userId") Long userId, @Param("fileId") Long fileId);
    UserDownload findUserDownload(@Param("userId") Long userId, @Param("fileId") Long fileId);
    User findUserById(@Param("userId") Long userId);
    void updateFileDownloadNumber(@Param("fileId") Long fileId, @Param("downloadNumber") Long downloadNumber);
    FileGreat findFileGreat(@Param("userId") Long userId, @Param("fileId") Long fileId, @Param("operate") Long operate);
    void insertFileGreat(@Param("userId") Long userId, @Param("fileId") Long fileId, @Param("operate") Long operate);
    void deleteFileGreat(@Param("userId") Long userId, @Param("fileId") Long fileId, @Param("operate") Long operate);
    void updateFileUpNumber(@Param("fileId") Long fileId, @Param("upNumber") Long upNumber);
	void updateFileDownNumber(@Param("fileId") Long fileId, @Param("downNumber") Long downNumber);
	String findProvinceBySchool(@Param("school") String school);
}
