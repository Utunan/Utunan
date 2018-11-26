package com.utunan.service.community;

import com.utunan.pojo.community.Tag;

import java.util.List;

public interface TagService {
	/**
	 * @author  孙程程
	 * @description 获取问题引用数量最高的10个标签
	 * @date  9:53 2018/11/21
	 * @return  java.util.List<com.utunan.pojo.community.Tag>
	 */
	List<Tag> getTop10Tag();

	/**
	 * @author  孙程程
	 * @description 获取10个标签引用数量
	 * @date  9:53 2018/11/21
	 * @return  java.util.List<com.utunan.pojo.community.Tag>
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
	 * @return  java.util.List<com.utunan.pojo.community.Tag>
	 */
	 List<Tag> getRemianTags(List<Tag> tagList3);

}
