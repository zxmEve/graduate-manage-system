package com.zxm.graduatemanagesystem.dao.impl;

import com.zxm.graduatemanagesystem.constants.StatusEnum;
import com.zxm.graduatemanagesystem.dao.RecruitInfoDao;
import com.zxm.graduatemanagesystem.dao.mapper.RecruitInfoMapper;
import com.zxm.graduatemanagesystem.model.RecruitInfo;
import com.zxm.graduatemanagesystem.model.RecruitInfoCriteria;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2019/3/9
 * Create by zhouximin
 * Description:
 */
@Component
public class RecruitInfoDaoImpl implements RecruitInfoDao {
    @Resource
    private RecruitInfoMapper recruitInfoMapper;
    @Override
    public List<RecruitInfo> getRecruitListByAuthorDESC(Integer authorId) {
        RecruitInfoCriteria recruitInfoCriteria = new RecruitInfoCriteria();
        recruitInfoCriteria.setOrderByClause("create_date desc");
        recruitInfoCriteria.createCriteria().andAuthorIdEqualTo(authorId).andStatusEqualTo((byte)StatusEnum.NORMAL.getIntValue());
        return recruitInfoMapper.selectByExample(recruitInfoCriteria);
    }

    @Override
    public List<RecruitInfo> getRecruitListDESC() {
        RecruitInfoCriteria recruitInfoCriteria = new RecruitInfoCriteria();
        recruitInfoCriteria.setOrderByClause("create_date desc");
        recruitInfoCriteria.createCriteria().andStatusEqualTo((byte)StatusEnum.NORMAL.getIntValue());
        return recruitInfoMapper.selectByExample(recruitInfoCriteria);
    }
}
