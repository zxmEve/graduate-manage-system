package com.zxm.graduatemanagesystem.dao.impl;

import com.zxm.graduatemanagesystem.dao.RecruitInfoDao;
import com.zxm.graduatemanagesystem.dao.mapper.RecruitInfoMapper;
import com.zxm.graduatemanagesystem.model.RecruitInfo;
import com.zxm.graduatemanagesystem.model.RecruitInfoCriteria;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2019/3/9
 * Create by zhouximin
 * Description:
 */
public class RecruitInfoDaoImpl implements RecruitInfoDao {
    @Resource
    private RecruitInfoMapper recruitInfoMapper;
    @Override
    public List<RecruitInfo> getRecruitListByAuthorDESC(Integer authorId) {
        RecruitInfoCriteria recruitInfoCriteria = new RecruitInfoCriteria();
        recruitInfoCriteria.setOrderByClause("create_date desc");
        recruitInfoCriteria.createCriteria().andAuthorIdEqualTo(authorId);
        return recruitInfoMapper.selectByExample(recruitInfoCriteria);
    }
}
