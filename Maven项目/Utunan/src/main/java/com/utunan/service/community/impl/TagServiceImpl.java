package com.utunan.service.community.impl;

import com.utunan.mapper.community.TagMapper;
import com.utunan.pojo.community.Tag;
import com.utunan.service.community.TagService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tagService")
public class TagServiceImpl implements TagService {

	@Autowired
	private TagMapper tagMapper;

	/**
	 * @author  孙程程
	 * @description 获取问题引用数量最高的10个标签
	 * @date  9:53 2018/11/21
	 * @return  java.util.List<com.utunan.pojo.community.Tag>
	 */
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

	/**
	 * @author  孙程程
	 * @description 获取10个标签引用数量
	 * @date  9:53 2018/11/21
	 * @return  java.util.List<com.utunan.pojo.community.Tag>
	 */
	@Override
	public List<Long> getTop10TagNumber(){
		return this.tagMapper.top10TagNumber();
	}

	/**
	 * @author  孙程程
	 * @description 根据搜索条件查询标签列表
	 * @date  17:14 2018/11/27
	 * @param  searchValue
	 * @return  java.util.List<com.utunan.pojo.community.Tag>
	 */
	@Override
	public List<Tag> findTagListBySearch(String searchValue){
		return this.tagMapper.findTagListBySearch("%"+searchValue+"%");
	}

	/**
	 * @author  孙程程
	 * @description 根据搜索条件统计标签数量
	 * @date  17:14 2018/11/27
	 * @param  searchValue
	 * @return  java.lang.Long
	 */
	@Override
	public Long countTagBySearch(String searchValue){
		return this.tagMapper.countTagBySearch("%"+searchValue+"%");
	}
}
