package com.utunan.service.share.share;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.admin.AdminDirectionMapper;
import com.utunan.mapper.share.ShareIndexMapper;
import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.base.share.File;
import com.utunan.pojo.base.share.UserDownload;
import com.utunan.pojo.base.user.User;
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

	/**
	 * @author  孙程程
	 * @description 根据fileId查文件
	 * @date  9:06 2018/12/13
	 * @param  fileId
	 * @return  com.utunan.pojo.base.share.File
	 */
	@Override
	public File findFileById(Long fileId){
		return this.shareIndexMapper.findFileById(fileId);
	}

	/**
	 * @author  孙程程
	 * @description 以文件标题为搜索条件，搜索相关文件
	 * @date  8:58 2018/12/17
	 * @param  keyWords
	 * @return  java.util.List<com.utunan.pojo.base.share.File>
	 */
	@Override
	public List<File> selectFileByTitle(List<String> keyWords){
		String keyWord="";
		for(int i=0; i<keyWords.size(); i++){
			keyWord += keyWords.get(i);
			if (i != (keyWords.size()-1)){
				keyWord += "|";
			}
		}
		List<File> fileList = this.shareIndexMapper.selectFileByTitle(keyWord);
		for(int i=0; i<fileList.size(); i++){
			File f = fileList.get(i);
			for(int j=0; j<keyWords.size(); j++){
				if(keyWords.get(j)!="."){
					f.setFileTitle(f.getFileTitle().replaceAll(keyWords.get(j),"<span style='color:red'>"+keyWords.get(j)+"</span>"));
				}
			}
		}
		return fileList;
	}

	/**
	 * @author  孙程程
	 * @description 更新用户积分
	 * @date  15:34 2018/12/18
	 * @param  userId, userIntegral
	 * @return  void
	 */
	@Override
	public void updateUserIntegral(Long userId, Long userIntegral){
		this.shareIndexMapper.updateUserIntegral(userId,userIntegral);
	}

	/**
	 * @author  孙程程
	 * @description 向用户下载表插入数据
	 * @date  15:34 2018/12/18
	 * @param  userId, fileId
	 * @return  void
	 */
	@Override
	public void insertUserDownload(Long userId, Long fileId){
		this.shareIndexMapper.insertUserDownload(userId, fileId);
	}

	/**
	 * @author  孙程程
	 * @description 判断用户是否下载过该文件
	 * @date  15:44 2018/12/18
	 * @param  userId, fileId
	 * @return  com.utunan.pojo.base.share.UserDownload
	 */
	@Override
	public UserDownload findUserDownload(Long userId, Long fileId){
		return this.shareIndexMapper.findUserDownload(userId, fileId);
	}

	/**
	 * @author  孙程程
	 * @description 根据用户Id查找用户
	 * @date  16:34 2018/12/18
	 * @param  userId
	 * @return  com.utunan.pojo.base.user.User
	 */
	@Override
	public User findUserById(Long userId){
		return this.shareIndexMapper.findUserById(userId);
	}
}
