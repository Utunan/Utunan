package com.utunan.mapper.community;

import com.utunan.pojo.community.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {
	//引用数量最高的10个标签
	List<Tag> top10Tag();
	//引用数量最高的10个标签的引用数量
	List top10TagNumber();
	//根据搜索条件查询标签列表
	List<Tag> findTagListBySearch(@Param("searchValue") String searchValue);
	//根据搜索条件统计标签数量
	Long countTagBySearch(@Param("searchValue") String searchValue);


}
