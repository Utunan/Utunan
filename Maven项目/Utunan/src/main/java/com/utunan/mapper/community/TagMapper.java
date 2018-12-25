package com.utunan.mapper.community;

import com.utunan.pojo.base.community.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {
	List<Tag> top10Tag();
	List top10TagNumber();
	/*
	 * @author  张正扬
	 * @description 提问区根据问题数量查询前3个标签
	 * @date  9:43 2018/11/26
	 * @param  null
	 * @return  List<Tag>
	 */
	List<Tag> top3Tag();


	/*
	 * @author  张正扬
	 * @description 提问区查询余下标签
	 * @date  10:13 2018/11/26
	 * @param
	 * @return
	 */
	List<Tag> getRemainTag(@Param("tagList3") List<Tag> tagList3);

	//获取用户输入的标签
	List<Long> getTags(@Param("listtag") List<String> listtag);

	//所有标签
	List<Tag> listAllTag();

}
