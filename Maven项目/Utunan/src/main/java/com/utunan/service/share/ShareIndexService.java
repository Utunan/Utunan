package com.utunan.service.share;

import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.base.share.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShareIndexService {
    /**
     * @author  孙程程
     * @description 最新文件
     * @date  18:00 2018/12/10
     * @param  pageNum, pageSize
     * @return  java.util.List<com.utunan.pojo.base.share.File>
     */
    List<File> listFileByTime(int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 热门文件
	 * @date  18:00 2018/12/10
	 * @return  java.util.List<com.utunan.pojo.base.share.File>
	 */
    List<File> listHotFile();

    /**
     * @author  孙程程
     * @description 学校省份
     * @date  11:31 2018/12/11
     * @return  java.util.List<java.lang.String>
     */
	List<String> listSchoolProvince();
	/**
	 * @author  孙程程
	 * @description 学校
	 * @date  11:31 2018/12/11
	 * @return  java.util.List<com.utunan.pojo.base.school.School>
	 */
	List<School> listSchool();

	/**
	 * @author  孙程程
	 * @description 筛选文件
	 * @date  16:27 2018/12/11
	 * @return  java.util.List<com.utunan.pojo.base.share.File>
	 */
	List<File> selectFile(String[] fileTypes, String fileSchool, List<String> keyWords, int pageNum, int pageSize);
}
