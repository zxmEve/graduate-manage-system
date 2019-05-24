package com.zxm.graduatemanagesystem.service;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.CompanyInfo;

import java.util.List;

/**
 * 2019/3/5
 * Create by zhouximin
 * Description:
 */
public interface ICompanyService {

    List<CompanyInfo> getCompanyList();

    int insertCompany(CompanyInfo companyInfo);

    int updateCompany(CompanyInfo companyInfo);

    PageInfo getCompanyList(int pageNum, int pageSize);

    int deleteCompany(Integer id);

    CompanyInfo getCompanyByUserId(Integer userId);

    CompanyInfo getCompanyById(Integer id);

}
