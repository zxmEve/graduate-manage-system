package com.zxm.graduatemanagesystem.model;

import java.util.Date;

public class ArticleInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_info.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_info.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_info.type
     *
     * @mbggenerated
     */
    private Byte type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_info.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_info.pic_path
     *
     * @mbggenerated
     */
    private String picPath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_info.author_id
     *
     * @mbggenerated
     */
    private Integer authorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_info.status
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_info.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_info.id
     *
     * @return the value of article_info.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_info.id
     *
     * @param id the value for article_info.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_info.title
     *
     * @return the value of article_info.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_info.title
     *
     * @param title the value for article_info.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_info.type
     *
     * @return the value of article_info.type
     *
     * @mbggenerated
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_info.type
     *
     * @param type the value for article_info.type
     *
     * @mbggenerated
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_info.create_time
     *
     * @return the value of article_info.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_info.create_time
     *
     * @param createTime the value for article_info.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_info.pic_path
     *
     * @return the value of article_info.pic_path
     *
     * @mbggenerated
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_info.pic_path
     *
     * @param picPath the value for article_info.pic_path
     *
     * @mbggenerated
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_info.author_id
     *
     * @return the value of article_info.author_id
     *
     * @mbggenerated
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_info.author_id
     *
     * @param authorId the value for article_info.author_id
     *
     * @mbggenerated
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_info.status
     *
     * @return the value of article_info.status
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_info.status
     *
     * @param status the value for article_info.status
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_info.content
     *
     * @return the value of article_info.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_info.content
     *
     * @param content the value for article_info.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}