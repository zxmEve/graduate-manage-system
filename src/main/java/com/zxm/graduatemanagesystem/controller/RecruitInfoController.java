package com.zxm.graduatemanagesystem.controller;

import javax.annotation.Resource;

import com.zxm.graduatemanagesystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.RecruitInfo;
import com.zxm.graduatemanagesystem.service.impl.RecruitInfoService;

import java.util.Date;

/**
 * @author zhouximin
 * Created on 2019-03-10
 */


@RequestMapping("/recruit/info")
@Controller
@SessionAttributes("loginUser")
public class RecruitInfoController {

    @Resource
    private RecruitInfoService recruitInfoService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public @ResponseBody
    boolean insert(RecruitInfo recruitInfo ,@ModelAttribute("loginUser")User user) {
        recruitInfo.setCreateDate(new Date());
        recruitInfo.setStatus((byte)1);
        recruitInfo.setAuthorId(user.getId());
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

    @RequestMapping(value = "/toRecruitInfoTable")
    public String toRecruitInfoTable(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize){
        PageInfo pageInfo = recruitInfoService.getRecruitInfoListDESC(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "/admin/recruit_info_table";
    }

    @RequestMapping(value = "/toPublishRecruitInfo")
    public String toPublishRecruitInfo(Model model){
        return "/admin/publish_recruit_info";
    }

}
