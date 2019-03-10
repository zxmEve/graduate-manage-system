package com.zxm.graduatemanagesystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.CompanyInfo;
import com.zxm.graduatemanagesystem.service.impl.CompanyService;

/**
 * 2019/3/6
 * Create by zhouximin
 * Description:
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Resource
    private CompanyService companyService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public PageInfo list(@RequestParam int pageNum, @RequestParam int pageSize){
        return companyService.getCompanyList(pageNum, pageSize);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean update(@RequestBody CompanyInfo companyInfo) {
        int ret = companyService.updateCompany(companyInfo);
        return ret > 0;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public boolean insert(@RequestBody CompanyInfo companyInfo) {
        int ret = companyService.insertCompany(companyInfo);
        return ret > 0;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public boolean delete(@RequestParam int companyId) {
        int ret = companyService.deleteCompany(companyId);
        return ret > 0;
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public CompanyInfo queryByUserId(@RequestParam int userId){
        return companyService.getCompanyByUserId(userId);
    }

}
