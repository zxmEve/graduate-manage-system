package com.zxm.graduatemanagesystem.model;

import java.util.Date;

public class RecruitMeeting {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recruit_meeting.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recruit_meeting.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recruit_meeting.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recruit_meeting.start_time
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recruit_meeting.end_time
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recruit_meeting.author_id
     *
     * @mbggenerated
     */
    private Integer authorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recruit_meeting.status
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recruit_meeting.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recruit_meeting.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recruit_meeting.id
     *
     * @return the value of recruit_meeting.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recruit_meeting.id
     *
     * @param id the value for recruit_meeting.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recruit_meeting.title
     *
     * @return the value of recruit_meeting.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recruit_meeting.title
     *
     * @param title the value for recruit_meeting.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recruit_meeting.address
     *
     * @return the value of recruit_meeting.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recruit_meeting.address
     *
     * @param address the value for recruit_meeting.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recruit_meeting.start_time
     *
     * @return the value of recruit_meeting.start_time
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recruit_meeting.start_time
     *
     * @param startTime the value for recruit_meeting.start_time
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recruit_meeting.end_time
     *
     * @return the value of recruit_meeting.end_time
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recruit_meeting.end_time
     *
     * @param endTime the value for recruit_meeting.end_time
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recruit_meeting.author_id
     *
     * @return the value of recruit_meeting.author_id
     *
     * @mbggenerated
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recruit_meeting.author_id
     *
     * @param authorId the value for recruit_meeting.author_id
     *
     * @mbggenerated
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recruit_meeting.status
     *
     * @return the value of recruit_meeting.status
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recruit_meeting.status
     *
     * @param status the value for recruit_meeting.status
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recruit_meeting.create_time
     *
     * @return the value of recruit_meeting.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recruit_meeting.create_time
     *
     * @param createTime the value for recruit_meeting.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recruit_meeting.content
     *
     * @return the value of recruit_meeting.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recruit_meeting.content
     *
     * @param content the value for recruit_meeting.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}