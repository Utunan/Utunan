package com.utunan.service.share.share;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.admin.AdminDirectionMapper;
import com.utunan.mapper.share.ShareIndexMapper;
import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.share.File;
import com.utunan.service.admin.AdminDirectionService;
import com.utunan.service.share.ShareIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
