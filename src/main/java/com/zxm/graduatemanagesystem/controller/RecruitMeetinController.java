package com.zxm.graduatemanagesystem.controller;

import javax.annotation.Resource;

import com.zxm.graduatemanagesystem.model.User;
import com.zxm.graduatemanagesystem.vo.front.RecruitMeetingVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.RecruitMeeting;
import com.zxm.graduatemanagesystem.service.impl.RecruitMeetingService;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author zhouximin
 * Created on 2019-03-10
 */


@RequestMapping("/recruit/meeting")
@Controller
@SessionAttributes("loginUser")
public class RecruitMeetinController {

    @Resource
    private RecruitMeetingService recruitMeetingService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody ModelAndView insert(RecruitMeetingVO recruitMeeting){
        ModelAndView modelAndView = new ModelAndView("/admin/publish_recruit_meeting_success");
        ModelAndView error = new ModelAndView("/admin/publish_error");

        int flag = recruitMeetingService.insertRecruitMeeting(recruitMeeting);
        if(flag > 0)return modelAndView;
        else return error;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView update(RecruitMeetingVO recruitMeeting){
        ModelAndView modelAndView = new ModelAndView("/admin/publish_recruit_meeting_success");
        ModelAndView error = new ModelAndView("/admin/publish_error");
        int flag = recruitMeetingService.updateRecruitMeeting(recruitMeeting);
        if(flag > 0)return modelAndView;
        else return error;

    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public PageInfo list(@RequestParam int pageNum, @RequestParam int pageSize,@RequestParam(required = false)Integer authorId){
        return recruitMeetingService.getRecruitMeetingListByTypeDESC(pageNum, pageSize,authorId);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public boolean delete(@RequestParam int id){
        int ret = recruitMeetingService.deleteRecruitMeeting(id);
        return ret > 0;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detail(Model model, @RequestParam Integer id){
        RecruitMeeting recruitMeeting = recruitMeetingService.getDetailById(id);
        model.addAttribute("info",recruitMeeting);
        return "/front/recruit_meeting";
    }

    @RequestMapping(value = "/toList",method = RequestMethod.GET)
    public String toListPage(Model model, @RequestParam (defaultValue = "1")int pageNum, @RequestParam (defaultValue = "10")int pageSize,@RequestParam(required = false)Integer authorId){
        PageInfo pageInfo = recruitMeetingService.getRecruitMeetingListByTypeDESC(pageNum,pageSize,authorId);
        model.addAttribute("pageInfo", pageInfo);
        return "/front/recruit_meeting_list";
    }

    @RequestMapping(value = "/toMeetingTable")
    public String toMeetingTable(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize,@RequestParam(required = false)Integer authorId){
        PageInfo pageInfo = recruitMeetingService.getRecruitMeetingListByTypeDESC(pageNum,pageSize,authorId);
        model.addAttribute("pageInfo",pageInfo);
        return "/admin/recruit_meeting_table";
    }

    @RequestMapping(value = "/toPublishRecruitMeeting")
    public String toPublishRecruitInfo(Model model){
        return "/admin/publish_recruit_meeting";
    }

    @RequestMapping(value = "/toUpdateRecruitMeeting")
    public String toUpdateRecruitMeeting(Model model,@RequestParam Integer id){
        RecruitMeeting recruitMeeting = recruitMeetingService.getDetailById(id);
        model.addAttribute("recruitMeeting",recruitMeeting);
        return "/admin/update_recruit_meeting";
    }
}
