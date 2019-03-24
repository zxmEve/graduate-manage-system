package com.zxm.graduatemanagesystem.controller;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.service.IRecruitMeetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * 2019/3/23
 * Create by zhouximin
 * Description:
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Resource
    private IRecruitMeetingService recruitMeetingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toIndex(Model model){
        PageInfo recruitMeetingPageInfo = recruitMeetingService.getRecruitMeetingListByTypeDESC(1,8);
        model.addAttribute("recruitMeeting", recruitMeetingPageInfo);
        return "/front/index";
    }
}
