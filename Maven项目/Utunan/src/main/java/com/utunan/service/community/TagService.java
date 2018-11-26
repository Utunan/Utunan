package com.utunan.service.community;

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

}
