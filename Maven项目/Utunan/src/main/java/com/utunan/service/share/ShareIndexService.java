package com.utunan.service.share;

import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.share.File;

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
}
