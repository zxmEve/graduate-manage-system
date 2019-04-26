package com.zxm.graduatemanagesystem.service;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.RecruitMeeting;
import com.zxm.graduatemanagesystem.vo.front.RecruitMeetingVO;

import java.util.List;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description:
 */
public interface IRecruitMeetingService {
    List<RecruitMeeting> getRecruitMeetingList();

    int insertRecruitMeeting(RecruitMeetingVO recruitMeeting);

    int updateRecruitMeeting(RecruitMeeting recruitMeeting);

    PageInfo getRecruitMeetingListByTypeDESC(int pageNum, int pageSize);

    int deleteRecruitMeeting(Integer id);

    RecruitMeeting getDetailById(Integer id);
}
