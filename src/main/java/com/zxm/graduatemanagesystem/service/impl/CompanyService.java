package com.zxm.graduatemanagesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.dao.CompanyInfoDao;
import com.zxm.graduatemanagesystem.dao.mapper.CompanyInfoMapper;
import com.zxm.graduatemanagesystem.model.CompanyInfo;
import com.zxm.graduatemanagesystem.model.CompanyInfoCriteria;
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
        CompanyInfoCriteria companyInfoCriteria = new CompanyInfoCriteria();
        companyInfoCriteria.createCriteria().andComUserIdEqualTo(userId);
        List<CompanyInfo> list = companyInfoMapper.selectByExample(companyInfoCriteria);
        if(list.size() > 0){
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public CompanyInfo getCompanyById(Integer id) {
        return companyInfoMapper.selectByPrimaryKey(id);
    }


}
