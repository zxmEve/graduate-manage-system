package com.zxm.graduatemanagesystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.RecruitInfo;
import com.zxm.graduatemanagesystem.service.impl.RecruitInfoService;

/**
 * @author zhouximin
 * Created on 2019-03-10
 */


@RequestMapping("/recruit/info")
@Controller
public class RecruitInfoController {

    @Resource
    private RecruitInfoService recruitInfoService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public boolean insert(@RequestBody RecruitInfo recruitInfo) {
        int flag = recruitInfoService.insertRecruitInfo(recruitInfo);
        return flag > 0;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public boolean update(@RequestBody RecruitInfo recruitInfo){
        int flag = recruitInfoService.updateRecruitInfo(recruitInfo);
        return flag > 0;
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public PageInfo list(@RequestParam int pageNum, @RequestParam int pageSize,
                         @RequestParam int authorId){
        return recruitInfoService.getRecruitInfoListByAuthorIdDESC(pageNum, pageSize, authorId);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public boolean delete(@RequestParam int recruitId){
        int flag = recruitInfoService.deleteRecruitInfo(recruitId);
        return flag > 0;
    }


    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detail(Model model, @RequestParam Integer id){
        RecruitInfo recruitInfo = recruitInfoService.getDetailById(id);
        model.addAttribute("info",recruitInfo);
        return "/front/recruit_info";
    }

    @RequestMapping(value = "/toList",method = RequestMethod.GET)
    public String toListPage(Model model, @RequestParam (defaultValue = "1")int pageNum, @RequestParam (defaultValue = "10")int pageSize){
        PageInfo pageInfo = recruitInfoService.getRecruitInfoListDESC(pageNum,pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "/front/recruit_info_list";
    }

}
