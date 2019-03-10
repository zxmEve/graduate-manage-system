package com.zxm.graduatemanagesystem.service;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.RecruitMeeting;

import java.util.List;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description:
 */
public interface IRecruitMeetingService {
    List<RecruitMeeting> getRecruitMeetingList();

    int insertRecruitMeeting(RecruitMeeting recruitMeeting);

    int updateRecruitMeeting(RecruitMeeting recruitMeeting);

    PageInfo getRecruitMeetingListByTypeDESC(int pageNum, int pageSize);

    int deleteRecruitMeeting(Integer id);
}
