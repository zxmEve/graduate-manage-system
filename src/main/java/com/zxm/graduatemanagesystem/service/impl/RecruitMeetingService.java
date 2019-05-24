package com.zxm.graduatemanagesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.constants.StatusEnum;
import com.zxm.graduatemanagesystem.dao.mapper.RecruitMeetingMapper;
import com.zxm.graduatemanagesystem.model.RecruitMeeting;
import com.zxm.graduatemanagesystem.service.IRecruitMeetingService;
import com.zxm.graduatemanagesystem.util.DateUtil;
import com.zxm.graduatemanagesystem.vo.front.RecruitMeetingVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
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
        System.out.println(recruitMeetingVO.getStartTime());
        try {
            recruitMeeting.setStartTime(DateUtil.sdf2.parse(recruitMeetingVO.getStartTime()));
            recruitMeeting.setEndTime(DateUtil.sdf2.parse(recruitMeetingVO.getEndTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(recruitMeeting.getStartTime());
        recruitMeeting.setTitle(recruitMeetingVO.getTitle());
        recruitMeeting.setAddress(recruitMeetingVO.getAddress());
        recruitMeeting.setContent(recruitMeetingVO.getContent());
        recruitMeeting.setCreateTime(new Date());
        recruitMeeting.setStatus((byte) StatusEnum.NORMAL.getIntValue());
        return recruitMeetingMapper.insertSelective(recruitMeeting);
    }

    @Override
    public int updateRecruitMeeting(RecruitMeetingVO recruitMeetingVO) {
        RecruitMeeting recruitMeeting = new RecruitMeeting();
        System.out.println(recruitMeetingVO.getStartTime());
        recruitMeeting.setId(recruitMeetingVO.getId());
        try {
            recruitMeeting.setStartTime(DateUtil.sdf2.parse(recruitMeetingVO.getStartTime()));
            recruitMeeting.setEndTime(DateUtil.sdf2.parse(recruitMeetingVO.getEndTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        recruitMeeting.setTitle(recruitMeetingVO.getTitle());
        recruitMeeting.setAddress(recruitMeetingVO.getAddress());
        recruitMeeting.setContent(recruitMeetingVO.getContent());
        return recruitMeetingMapper.updateByPrimaryKeySelective(recruitMeeting);
    }

    @Override
    public PageInfo getRecruitMeetingListByTypeDESC(int pageNum, int pageSize,Integer authorId) {
        PageHelper.startPage(pageNum,pageSize);
        List<RecruitMeetingVO> list = recruitMeetingMapper.getMeetingOrderByStartTime(authorId);
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
