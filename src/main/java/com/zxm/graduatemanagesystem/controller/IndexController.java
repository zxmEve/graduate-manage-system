package com.zxm.graduatemanagesystem.controller;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.constants.ArticalTypeEnum;
import com.zxm.graduatemanagesystem.service.IArticleInfoService;
import com.zxm.graduatemanagesystem.service.IRecruitInfoService;
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

public class IndexController {
    @Resource
    private IRecruitMeetingService recruitMeetingService;
    @Resource
    private IRecruitInfoService recruitInfoService;
    @Resource
    private IArticleInfoService articleInfoService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String toIndex(Model model){
        int pageNum = 1;
        int pageSize = 12;
        Integer authorId = null;
        PageInfo recruitMeetingPageInfo = recruitMeetingService.getRecruitMeetingListByTypeDESC(pageNum, pageSize,authorId);
        PageInfo recruitInfoPageInfo = recruitInfoService.getRecruitInfoListDESC(pageNum, pageSize);
        PageInfo notice = articleInfoService.getArticleInfoListByTypeDESC(pageNum, pageSize, ArticalTypeEnum.NOTICE.getIntValue());
        PageInfo news = articleInfoService.getArticleInfoListByTypeDESC(pageNum,pageSize,ArticalTypeEnum.NEWS.getIntValue());
        model.addAttribute("recruitMeeting", recruitMeetingPageInfo);
        model.addAttribute("recruitInfo", recruitInfoPageInfo);
        model.addAttribute("notice",notice);
        model.addAttribute("news",news);
        return "/front/index";
    }
}
