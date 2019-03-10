package com.zxm.graduatemanagesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.constants.StatusEnum;
import com.zxm.graduatemanagesystem.dao.mapper.RecruitInfoMapper;
import com.zxm.graduatemanagesystem.dao.mapper.RecruitMeetingMapper;
import com.zxm.graduatemanagesystem.model.RecruitMeeting;
import com.zxm.graduatemanagesystem.service.IRecruitMeetingService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description:
 */
public class RecruitMeetingService implements IRecruitMeetingService {
    @Resource
    RecruitMeetingMapper recruitMeetingMapper;
    @Override
    public List<RecruitMeeting> getRecruitMeetingList() {
        return null;
    }

    @Override
    public int insertRecruitMeeting(RecruitMeeting recruitMeeting) {
        recruitMeeting.setCreateTime(new Date());
        recruitMeeting.setStatus((byte) StatusEnum.NORMAL.getIntValue());
        return recruitMeetingMapper.insertSelective(recruitMeeting);
    }

    @Override
    public int updateRecruitMeeting(RecruitMeeting recruitMeeting) {
        return recruitMeetingMapper.updateByPrimaryKeyWithBLOBs(recruitMeeting);
    }

    @Override
    public PageInfo getRecruitMeetingListByTypeDESC(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<RecruitMeeting> list = recruitMeetingMapper.getMeetingOrderByStartTime();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int deleteRecruitMeeting(Integer id) {
        return recruitMeetingMapper.deleteByPrimaryKey(id);
    }
}
