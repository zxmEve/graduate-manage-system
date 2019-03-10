package com.zxm.graduatemanagesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.constants.StatusEnum;
import com.zxm.graduatemanagesystem.dao.RecruitInfoDao;
import com.zxm.graduatemanagesystem.dao.mapper.RecruitInfoMapper;
import com.zxm.graduatemanagesystem.model.RecruitInfo;
import com.zxm.graduatemanagesystem.model.RecruitInfoCriteria;
import com.zxm.graduatemanagesystem.service.IRecruitInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description:
 */
@Service
public class RecruitInfoService implements IRecruitInfoService {
    @Resource
    RecruitInfoMapper recruitInfoMapper;
    @Resource
    RecruitInfoDao recruitInfoDao;
    @Override
    public List<RecruitInfo> getRecruitInfoList() {
        return null;
    }

    @Override
    public int insertRecruitInfo(RecruitInfo recruitInfo) {
        recruitInfo.setCreateDate(new Date());
        recruitInfo.setStatus((byte)StatusEnum.NORMAL.getIntValue());
        return recruitInfoMapper.insertSelective(recruitInfo);
    }

    @Override
    public int updateRecruitInfo(RecruitInfo recruitInfo) {
        return recruitInfoMapper.updateByPrimaryKeyWithBLOBs(recruitInfo);
    }

    @Override
    public PageInfo getRecruitInfoListDESC(int pageNum, int pageSize, Integer authorId) {
        PageHelper.startPage(pageNum,pageSize);
        List<RecruitInfo> list = recruitInfoDao.getRecruitListByAuthorDESC(authorId);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int deleteRecruitInfo(Integer id) {
        return recruitInfoMapper.deleteByPrimaryKey(id);
    }
}
