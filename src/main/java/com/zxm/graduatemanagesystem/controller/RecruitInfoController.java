package com.zxm.graduatemanagesystem.controller;

import javax.annotation.Resource;

import com.zxm.graduatemanagesystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.RecruitInfo;
import com.zxm.graduatemanagesystem.service.impl.RecruitInfoService;
import org.springframework.web.servlet.ModelAndView;

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
    ModelAndView insert(Model model, RecruitInfo recruitInfo) {
        System.out.println(recruitInfo.getEndDate());
        int flag = recruitInfoService.insertRecruitInfo(recruitInfo);
        if( flag > 0) {
            return new ModelAndView("/admin/publish_success");
        }else{
            return new ModelAndView("/admin/publish_error");
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public @ResponseBody ModelAndView update(RecruitInfo recruitInfo){
        int flag = recruitInfoService.updateRecruitInfo(recruitInfo);
        if( flag > 0) {
            return new ModelAndView("/admin/publish_success");
        }else{
            return new ModelAndView("/admin/publish_error");
        }
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public PageInfo list(@RequestParam int pageNum, @RequestParam int pageSize,
                         @RequestParam(required = false) int authorId){
        return recruitInfoService.getRecruitInfoListByAuthorIdDESC(pageNum, pageSize, authorId);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public boolean  delete(@RequestParam int recruitId){
        int flag = recruitInfoService.deleteRecruitInfo(recruitId);
        if( flag > 0)return true;
        return false;
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
    public String toRecruitInfoTable(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize, @RequestParam Integer authorId){
        PageInfo pageInfo = recruitInfoService.getRecruitInfoListByAuthorIdDESC(pageNum,pageSize,authorId);
        model.addAttribute("pageInfo",pageInfo);
        return "/admin/recruit_info_table";
    }

    @RequestMapping(value = "/toPublishRecruitInfo")
    public String toPublishRecruitInfo(Model model){
        return "/admin/publish_recruit_info";
    }

    @RequestMapping(value = "/toUpdateRecruitInfo")
    public String toUpdateRecruitInfo(Model model,@RequestParam Integer id){
        RecruitInfo recruitInfo = recruitInfoService.getDetailById(id);
        model.addAttribute("recruitInfo",recruitInfo);
        return "/admin/update_recruit_info";
    }

}
