package com.utunan.service.share.share;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.admin.AdminDirectionMapper;
import com.utunan.mapper.share.ShareIndexMapper;
import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.base.share.File;
import com.utunan.service.admin.AdminDirectionService;
import com.utunan.service.share.ShareIndexService;
import com.utunan.util.SchoolOther;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service("ShareIndexService")
public class ShareIndexServiceImpl implements ShareIndexService {

    @Autowired
    private ShareIndexMapper shareIndexMapper;

    /**
     * @author  孙程程
     * @description 最新文件
     * @date  18:00 2018/12/10
     * @param  pageNum, pageSize
     * @return  java.util.List<com.utunan.pojo.base.share.File>
     */
	@Override
    public List<File> listFileByTime(int pageNum, int pageSize){
		PageHelper.startPage(pageNum,pageSize);
		//文件列表
        List<File> fileList = this.shareIndexMapper.listFileByTime();
        return fileList;
    }

    /**
     * @author  孙程程
     * @description 热门文件
     * @date  18:00 2018/12/10
     * @return  java.util.List<com.utunan.pojo.base.share.File>
     */
    @Override
	public List<File> listHotFile(){
		return this.shareIndexMapper.listHotFile();
    }

	/**
	 * @author  孙程程
	 * @description 学校省份
	 * @date  11:31 2018/12/11
	 * @return  java.util.List<java.lang.String>
	 */
	@Override
	public List<String> listSchoolProvince(){
		return this.shareIndexMapper.listSchoolProvince();
	}

	/**
	 * @author  孙程程
	 * @description 学校
	 * @date  11:31 2018/12/11
	 * @return  java.util.List<com.utunan.pojo.base.school.School>
	 */
	@Override
	public List<School> listSchool(){
		return this.shareIndexMapper.listSchool();
	}

	/**
	 * @author  孙程程
	 * @description 筛选文件
	 * @date  16:27 2018/12/11
	 * @return  java.util.List<com.utunan.pojo.base.share.File>
	 */
	@Override
	public List<File> selectFile(String[] fileTypes, String fileSchool, List<String> keyWords, int pageNum, int pageSize){
		String keyWord="";
		for(int i=0; i<keyWords.size(); i++){
			keyWord += keyWords.get(i);
			if (i != (keyWords.size()-1)){
				keyWord += "|";
			}
		}
		SchoolOther so = new SchoolOther();
		fileTypes = so.clickAll(fileTypes);
		List<File> fileList;
		PageHelper.startPage(pageNum,pageSize);
		fileList = this.shareIndexMapper.selectFile(fileTypes, fileSchool, keyWord);
		return fileList;
	}
}
