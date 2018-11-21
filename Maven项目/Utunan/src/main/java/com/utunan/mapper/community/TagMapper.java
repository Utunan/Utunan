package com.utunan.mapper.community;

import com.utunan.pojo.community.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {
	List<Tag> top10Tag();
	List top10TagNumber();

}
