package com.zxm.graduatemanagesystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.RecruitMeeting;
import com.zxm.graduatemanagesystem.service.impl.RecruitMeetingService;

/**
 * @author tangmingqiu
 * Created on 2019-03-10
 */


@RequestMapping("/recruit/meeting")
@Controller
public class RecruitMeetinController {

    @Resource
    private RecruitMeetingService recruitMeetingService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public boolean insert(@RequestBody RecruitMeeting recruitMeeting){
        int flag = recruitMeetingService.insertRecruitMeeting(recruitMeeting);
       return flag > 0;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean update(@RequestBody RecruitMeeting recruitMeeting){
        int flag = recruitMeetingService.updateRecruitMeeting(recruitMeeting);
        return flag > 0;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public PageInfo list(@RequestParam int pageNum, @RequestParam int pageSize){
        return recruitMeetingService.getRecruitMeetingListByTypeDESC(pageNum, pageSize);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public boolean delete(@RequestParam int meetingId){
        int ret = recruitMeetingService.deleteRecruitMeeting(meetingId);
        return ret > 0;
    }
}
