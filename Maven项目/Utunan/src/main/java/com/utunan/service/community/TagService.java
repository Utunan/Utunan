package com.utunan.service.community;

import com.utunan.pojo.base.community.Tag;

import java.util.List;

public interface TagService {
	/**
	 * @author  孙程程
	 * @description 获取问题引用数量最高的10个标签
	 * @date  9:53 2018/11/21
	 * @return  java.util.List<com.utunan.pojo.base.community.Tag>
	 */
	Object getTop10Tag();

	/**
	 * @author  孙程程
	 * @description 获取10个标签引用数量
	 * @date  9:53 2018/11/21
	 * @return  java.util.List<com.utunan.pojo.base.community.Tag>
	 */
	List getTop10TagNumber();
	/*
	 * @author  张正扬
	 * @description 提问区获取问题引用数量最高的3个标签
	 * @date  9:25 2018/11/26
	 * @param  null
	 * @return  List<Tag>
	 */
	List<Tag> getTop3Tag();


	/*
	 * @author  张正扬
	 * @description  提问区查询余下标签
	 * @date  10:16 2018/11/26
	 * @param  [tagList3]
	 * @return  java.util.List<com.utunan.pojo.base.community.Tag>
	 */
	List<Tag> getRemianTags(List<Tag> tagList3);


	List<Long> getTags(List<String> listtag);

	/**
	 * @author  孙程程
	 * @description 获取所有标签
	 * @date  16:22 2018/12/25
	 * @return  java.util.List<com.utunan.pojo.base.community.Tag>
	 */
	List<Tag> listAllTag();
}
