package com.utunan.service.common;

import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.community.Tag;
import com.utunan.pojo.base.share.File;
import com.utunan.pojo.base.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchService {
	/**
	 * @author  孙程程
	 * @description 搜索用户
	 * @date  17:11 2018/12/9
	 * @param  keyWords
	 * @return  java.util.List<com.utunan.pojo.base.user.User>
	 */
	List<User> findUser(List<String> keyWords);
	/**
	 * @author  孙程程
	 * @description 搜索提问
	 * @date  16:12 2018/11/27
	 * @param  keyWords, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.community.Answer>
	 */
	List<Quiz> findQuiz(List<String> keyWords, int pageNum, int pageSize);
	/**
	 * @author  孙程程
	 * @description 搜索回答
	 * @date  16:12 2018/11/27
	 * @param  keyWords, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.community.Answer>
	 */
	List<Answer> findAnswer(List<String> keyWords, int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 搜索文件
	 * @date  17:09 2018/12/24
	 * @param  keyWords, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.share.File>
	 */
	List<File> findFile(List<String> keyWords, int pageNum, int pageSize);
}
