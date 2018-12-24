package com.utunan.service.common.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.common.SearchMapper;
import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.share.File;
import com.utunan.pojo.base.user.User;
import com.utunan.service.common.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;


@Service("SearchService")
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchMapper searchMapper;

	/**
	 * @author  孙程程
	 * @description 搜索用户
	 * @date  17:11 2018/12/9
	 * @param  keyWords
	 * @return  java.util.List<com.utunan.pojo.base.user.User>
	 */
	@Override
	public List<User> findUser(List<String> keyWords){
		String keyWord="";
		for(int i=0; i<keyWords.size(); i++){
			keyWord += keyWords.get(i);
			if (i != (keyWords.size()-1)){
				keyWord += "|";
			}
		}
		List<User> userList=this.searchMapper.findUser(keyWord);
		replaceUser(userList, keyWords);
		return userList;
	}
	/**
	 * @author  孙程程
	 * @description 搜索提问
	 * @date  16:12 2018/11/27
	 * @param  keyWords, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.community.Answer>
	 */
	@Override
	public List<Quiz> findQuiz(List<String> keyWords, int pageNum, int pageSize){
		String keyWord="";
		for(int i=0; i<keyWords.size(); i++){
			keyWord += keyWords.get(i);
			if (i != (keyWords.size()-1)){
				keyWord += "|";
			}
		}
		PageHelper.startPage(pageNum,pageSize);
		List<Quiz> quizList=searchMapper.findQuiz(keyWord);
		condenseQuiz(quizList);
		replaceQuiz(quizList,keyWords);
		return quizList;
	}
	/**
	 * @author  孙程程
     * @description 搜索回答
     * @date  16:12 2018/11/27
	 * @param  keyWords, pageNum, pageSize
     * @return  java.util.List<com.utunan.pojo.base.community.Answer>
     */
	@Override
	public List<Answer> findAnswer(List<String> keyWords, int pageNum, int pageSize){
		String keyWord="";
		for(int i=0; i<keyWords.size(); i++){
			keyWord += keyWords.get(i);
			if (i != (keyWords.size()-1)){
				keyWord += "|";
			}
		}
		PageHelper.startPage(pageNum,pageSize);
		List<Answer> answerList =searchMapper.findAnswer(keyWord);
		replaceAnswer(answerList,keyWords);
		return answerList;
	}

	/**
	 * @author  孙程程
	 * @description 搜索文件
	 * @date  17:09 2018/12/24
	 * @param  keyWords, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.share.File>
	 */
	@Override
	public List<File> findFile(List<String> keyWords, int pageNum, int pageSize){
		String keyWord="";
		for(int i=0; i<keyWords.size(); i++){
			keyWord += keyWords.get(i);
			if (i != (keyWords.size()-1)){
				keyWord += "|";
			}
		}
		PageHelper.startPage(pageNum,pageSize);
		List<File> fileList=searchMapper.findFile(keyWord);
		replaceFile(fileList,keyWords);
		return fileList;
	}
	/**
	 * @author  孙程程
	 * @description 提问列表限制显示字数
	 * @date  20:21 2018/12/9
	 * @param  quizList
	 * @return  void
	 */
	public void condenseQuiz(List<Quiz> quizList) {
		for(int i=0;i<quizList.size();i++){
			Quiz q=quizList.get(i);
			if(q.getQuizContent().length()>95)
				q.setQuizContent(q.getQuizContent().substring(0,95)+" ...");
			if(q.getQuizTitle().length()>30)
				q.setQuizTitle(q.getQuizTitle().substring(0,30)+" ...");
		}
	}
	/**
	 * @author  孙程程
	 * @description 用户列表高亮显示关键字
	 * @date  20:21 2018/12/9
	 * @param  userList, keyWords
	 * @return  void
	 */
	public void replaceUser(List<User> userList, List<String> keyWords){
		for(int i=0; i<userList.size(); i++){
			User u=userList.get(i);
			for(int j=0; j<keyWords.size(); j++){
				if(keyWords.get(j)!="."){
					u.setUserNickName(u.getUserNickName().replaceAll(keyWords.get(j),"<span style='color:red'>"+keyWords.get(j)+"</span>"));
				}
			}
		}
	}
	/**
	 * @author  孙程程
	 * @description 提问列表高亮显示关键字
	 * @date  20:21 2018/12/9
	 * @param  quizList, keyWords
	 * @return  void
	 */
	public void replaceQuiz(List<Quiz> quizList, List<String> keyWords){
		for(int i=0; i<quizList.size(); i++){
			Quiz q=quizList.get(i);
			for(int j=0; j<keyWords.size(); j++){
				if(keyWords.get(j)!="."){
					q.setQuizTitle(q.getQuizTitle().replaceAll(keyWords.get(j),"<span style='color:red'>"+keyWords.get(j)+"</span>"));
					q.setQuizContent(q.getQuizContent().replaceAll(keyWords.get(j),"<span style='color:red'>"+keyWords.get(j)+"</span>"));
				}
			}
		}
	}
	/**
	 * @author  孙程程
	 * @description 回答列表高亮显示关键字
	 * @date  20:21 2018/12/9
	 * @param  answerList, keyWords
	 * @return  void
	 */
	public void replaceAnswer(List<Answer> answerList, List<String> keyWords){
		for(int i=0; i<answerList.size(); i++){
			Answer q=answerList.get(i);
			for(int j=0; j<keyWords.size(); j++){
				if(keyWords.get(j)!="."){
					q.setAnswerContent(q.getAnswerContent().replaceAll(keyWords.get(j),"<span style='color:red'>"+keyWords.get(j)+"</span>"));
				}
			}
		}
	}
	/**
	 * @author  孙程程
	 * @description 文件列表高亮显示关键字
	 * @date  20:21 2018/12/9
	 * @param  fileList, keyWords
	 * @return  void
	 */
	public void replaceFile(List<File> fileList, List<String> keyWords){
		for(int i=0; i<fileList.size(); i++){
			File q=fileList.get(i);
			for(int j=0; j<keyWords.size(); j++){
				if(keyWords.get(j)!="."){
					q.setFileTitle(q.getFileTitle().replaceAll(keyWords.get(j),"<span style='color:red'>"+keyWords.get(j)+"</span>"));
				}
			}
		}
	}
}
