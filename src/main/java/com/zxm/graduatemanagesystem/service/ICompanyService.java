package com.zxm.graduatemanagesystem.service;

import com.zxm.graduatemanagesystem.model.CompanyInfo;

import java.util.List;

/**
 * 2019/3/5
 * Create by zhouximin
 * Description:
 */
public interface ICompanyService {

    List<CompanyInfo> getCompanyList();

    CompanyInfo insertCompany(CompanyInfo companyInfo);

    int updateCompany(CompanyInfo companyInfo);


}
