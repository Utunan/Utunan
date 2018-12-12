package com.utunan.service.community.impl;

import com.utunan.mapper.community.TagMapper;
import com.utunan.pojo.base.community.Tag;
import com.utunan.service.community.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tagService")
public class TagServiceImpl implements TagService {
	@Autowired
	private TagMapper tagMapper;

	@Override
	public Object getTop10Tag(){
		//热门标签
		List<Tag> hotTagList=this.tagMapper.top10Tag();
		//热门标签的回答数量
		List<Long> hotTagNumber=this.tagMapper.top10TagNumber();
		//封装热门标签和标签数量
		Object[][] hotTag=new Object[10][2];
		for(int i=0; i<hotTagList.size(); i++){
			hotTag[i][0]=hotTagList.get(i);
			hotTag[i][1]=hotTagNumber.get(i);
		}
		return hotTag;
	}

	@Override
	public List<Long> getTop10TagNumber(){
		return this.tagMapper.top10TagNumber();
	}
	@Override
	public List<Tag> getTop3Tag(){
		return this.tagMapper.top3Tag();
	}
	@Override
	public List<Tag> getRemianTags(List<Tag> tagList3){
		return this.tagMapper.getRemainTag(tagList3);
	}


	@Override
	public List<Long> getTags(List<String> listtag){
		return this.tagMapper.getTags(listtag);
	}
}
