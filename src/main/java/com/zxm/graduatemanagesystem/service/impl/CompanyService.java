package com.zxm.graduatemanagesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.dao.CompanyInfoDao;
import com.zxm.graduatemanagesystem.dao.mapper.CompanyInfoMapper;
import com.zxm.graduatemanagesystem.model.CompanyInfo;
import com.zxm.graduatemanagesystem.service.ICompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2019/3/5
 * Create by zhouximin
 * Description:
 */
@Service
public class CompanyService implements ICompanyService {
    @Resource
    private CompanyInfoMapper companyInfoMapper;
    @Resource
    private CompanyInfoDao companyInfoDao;
    @Override
    public List<CompanyInfo> getCompanyList() {
        return companyInfoMapper.selectByExample(null);
    }

    @Override
    public int insertCompany(CompanyInfo companyInfo) {
        return companyInfoMapper.insertSelective(companyInfo);
    }

    @Override
    public int updateCompany(CompanyInfo companyInfo) {
        return companyInfoMapper.updateByPrimaryKeySelective(companyInfo);
    }

    @Override
    public PageInfo getCompanyList(int pageNum, int pageSize) {
        List<CompanyInfo> list = companyInfoMapper.selectByExample(null);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteCompany(Integer id) {
        return companyInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CompanyInfo getCompanyByUserId(Integer userId) {
        return companyInfoDao.getCompanyByUserId(userId);
    }
}
