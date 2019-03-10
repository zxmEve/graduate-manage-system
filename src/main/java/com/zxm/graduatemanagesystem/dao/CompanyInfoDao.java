package com.zxm.graduatemanagesystem.dao;

import com.zxm.graduatemanagesystem.model.CompanyInfo;

/**
 * 2019/3/10
 * Create by zhouximin
 * Description:
 */
public interface CompanyInfoDao {
    CompanyInfo getCompanyByUserId(Integer userId);
}
