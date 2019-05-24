package com.zxm.graduatemanagesystem.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.zxm.graduatemanagesystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @RequestMapping(value = "/update_or_insert",method = RequestMethod.POST)
    public boolean updateOrInsert(Model modle, HttpServletRequest request, @RequestBody CompanyInfo companyInfo){
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user != null) {
            CompanyInfo company = companyService.getCompanyByUserId(user.getId());
            if (company == null) {
                // 公司信息表这个用户的信息为空，表示第一次完善信息
                companyInfo.setComUserId(user.getId());
                int ret = companyService.insertCompany(companyInfo);
                return ret > 0;
            }
        }

        int flag = companyService.updateCompany(companyInfo);
        return flag > 0;
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public CompanyInfo queryByUserId(@RequestParam int userId){
        return companyService.getCompanyByUserId(userId);
    }

    @RequestMapping("/toCompanyTable")
    public String toTablePage(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize){
        PageInfo pageInfo = companyService.getCompanyList(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "/admin/company_table";
    }

    @RequestMapping("/toCompanyInfo")
    public String toCompanyInfo(Model model,@RequestParam int companyId){
        CompanyInfo companyInfo = companyService.getCompanyById(companyId);
        model.addAttribute("company",companyInfo);
        return "/admin/company_info";
    }
}
