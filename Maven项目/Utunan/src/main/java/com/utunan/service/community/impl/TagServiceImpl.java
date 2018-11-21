package com.utunan.service.community.impl;

import com.utunan.mapper.community.TagMapper;
import com.utunan.pojo.community.Tag;
import com.utunan.service.community.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tagService")
public class TagServiceImpl implements TagService {
	@Autowired
	private TagMapper tagMapper;

	@Override
	public List<Tag> getTop10Tag(){
		return this.tagMapper.top10Tag();
	}

	@Override
	public List<Long> getTop10TagNumber(){
		return this.tagMapper.top10TagNumber();
	}
}
