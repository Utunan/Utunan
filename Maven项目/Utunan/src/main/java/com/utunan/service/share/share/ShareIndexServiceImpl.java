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

	@Override
    public List<File> listFileByTime(){
        List<File> fileList = this.shareIndexMapper.listFileByTime();
        return fileList;
    }
}
