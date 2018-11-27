package com.utunan.service.community;

import com.utunan.pojo.community.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagService {
	/**
	 * @author  孙程程
	 * @description 获取问题引用数量最高的10个标签
	 * @date  9:53 2018/11/21
	 * @return  java.util.List<com.utunan.pojo.community.Tag>
	 */
	Object getTop10Tag();

	/**
	 * @author  孙程程
	 * @description 获取10个标签引用数量
	 * @date  9:53 2018/11/21
	 * @return  java.util.List<com.utunan.pojo.community.Tag>
	 */
	List getTop10TagNumber();

	/**
	 * @author  孙程程
	 * @description 根据搜索条件查询标签列表
	 * @date  17:14 2018/11/27
	 * @param  searchValue
	 * @return  java.util.List<com.utunan.pojo.community.Tag>
	 */
	List<Tag> findTagListBySearch(String searchValue);

	/**
	 * @author  孙程程
	 * @description 根据搜索条件统计标签数量
	 * @date  17:14 2018/11/27
	 * @param  searchValue
	 * @return  java.lang.Long
	 */
	Long countTagBySearch(String searchValue);
}
