package com.utunan.pojo.util;

import java.util.List;

public class Page<T> {
	private List<T> list;
	//当前页
	private int currentPageNum;
	//页面大小
	private int pageSize;
	//上一页
	private int prePageNum;
	//下一页
	private int nextPageNum;
	//总页数
	private int totalPageNum;
	//总个数
	private Long totalCount;

	public Page(){

	}

	//获取当前页和页面大小
	public Page(int pageNum,int pageSize){
		this.currentPageNum=pageNum;
		this.pageSize=pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPrePageNum() {
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public int getNextPageNum() {
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long count) {
		this.totalCount = count;
		this.totalCount = count;
		if(count%pageSize==0){
			totalPageNum=(int) (count/pageSize);
		}
		else {
			totalPageNum = (int) (count / pageSize + 1);
		}
		if(currentPageNum>1) {
			prePageNum = currentPageNum - 1;
		}
		else {
			prePageNum = 1;
		}
		if(currentPageNum<totalPageNum) {
			nextPageNum = currentPageNum + 1;
		}
		else {
			nextPageNum = totalPageNum;
		}
	}

	@Override
	public String toString() {
		return "Page{" +
				"list=" + list +
				", currentPageNum=" + currentPageNum +
				", pageSize=" + pageSize +
				", prePageNum=" + prePageNum +
				", nextPageNum=" + nextPageNum +
				", totalPageNum=" + totalPageNum +
				", totalCount=" + totalCount +
				'}';
	}
}
