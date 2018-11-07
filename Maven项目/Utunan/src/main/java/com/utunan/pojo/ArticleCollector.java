package com.utunan.pojo;

/**
 * 帖子收藏列表-ArticleCollector
 */
public class ArticleCollector {
	//帖子收藏列表ID
	private Long postCollectorId;
	//帖子ID
	private Long postId;
	//板块ID
	private Long plateId;
	//作者ID
	private Long authorId;

	public Long getPostCollectorId() {
		return postCollectorId;
	}

	public void setPostCollectorId(Long postCollectorId) {
		this.postCollectorId = postCollectorId;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getPlateId() {
		return plateId;
	}

	public void setPlateId(Long plateId) {
		this.plateId = plateId;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "ArticleCollector{" +
				"postCollectorId=" + postCollectorId +
				", postId=" + postId +
				", plateId=" + plateId +
				", authorId=" + authorId +
				'}';
	}
}
