package com.zxm.graduatemanagesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.constants.StatusEnum;
import com.zxm.graduatemanagesystem.dao.mapper.RecruitMeetingMapper;
import com.zxm.graduatemanagesystem.model.RecruitMeeting;
import com.zxm.graduatemanagesystem.service.IRecruitMeetingService;
import com.zxm.graduatemanagesystem.vo.front.RecruitMeetingVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description:
 */
@Service
public class RecruitMeetingService implements IRecruitMeetingService {
    @Resource
    RecruitMeetingMapper recruitMeetingMapper;
    @Override
    public List<RecruitMeeting> getRecruitMeetingList() {
        return null;
    }

    @Override
    public int insertRecruitMeeting(RecruitMeetingVO recruitMeetingVO) {
        RecruitMeeting recruitMeeting = new RecruitMeeting();
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
        List<RecruitMeetingVO> list = recruitMeetingMapper.getMeetingOrderByStartTime();
//        list.forEach(recruitMeetingVO -> {
//
//        });
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }



    @Override
    public int deleteRecruitMeeting(Integer id) {
        return recruitMeetingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public RecruitMeeting getDetailById(Integer id) {
        RecruitMeeting recruitMeeting = recruitMeetingMapper.selectByPrimaryKey(id);
        return recruitMeeting;
    }

}
