package com.zxm.graduatemanagesystem.dao.impl;

import com.zxm.graduatemanagesystem.dao.CompanyInfoDao;
import com.zxm.graduatemanagesystem.dao.mapper.CompanyInfoMapper;
import com.zxm.graduatemanagesystem.model.CompanyInfo;
import com.zxm.graduatemanagesystem.model.CompanyInfoCriteria;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2019/3/10
 * Create by zhouximin
 * Description:
 */
@Component
public class CompanyInfoDaoImpl implements CompanyInfoDao {
    @Resource
    CompanyInfoMapper companyInfoMapper;
    @Override
    public CompanyInfo getCompanyByUserId(Integer userId) {
        CompanyInfoCriteria companyInfoCriteria = new CompanyInfoCriteria();
        companyInfoCriteria.createCriteria().andComUserIdEqualTo(userId);
        List<CompanyInfo> list = companyInfoMapper.selectByExample(companyInfoCriteria);
        if(list.size() > 0){
            return list.get(0);
        }else {
            return null;
        }
    }
}
