package com.utunan.pojo.community;

import java.util.Date;

/**
 * Article:文章/帖子
 */
public class Article {
    //文章Id
    private Long articleId;
    //作者/用户Id
    private Long authorId;
    //板块Id;
    private Long plateId;
    //文章主题
    private String articleTitle;
    //文章内容
    private String articleContent;
    //发表时间
    private Date releaseTime;
    //点赞计数
    private Long praiseCount;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getAuthorId() { return authorId; }

    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public Long getPlateId() {
        return plateId;
    }

    public void setPlateId(Long plateId) {
        this.plateId = plateId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }


    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Long getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Long praiseCount) {
        this.praiseCount = praiseCount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", userId=" + authorId +
                ", plateId=" + plateId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", releaseTime=" + releaseTime +
                ", praiseCount=" + praiseCount +
                '}';
    }
}
