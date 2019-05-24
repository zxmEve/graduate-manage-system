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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return recruitInfoMapper.updateByPrimaryKeySelective(recruitInfo);
    }

    @Override
    public PageInfo getRecruitInfoListByAuthorIdDESC(int pageNum, int pageSize, Integer authorId) {
        Map map = new HashMap();
        map.put("authorId", authorId);
        PageHelper.startPage(pageNum,pageSize);
        List<RecruitInfo> list = recruitInfoMapper.getRecruitListDESC(map);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public PageInfo getRecruitInfoListDESC(int pageNum, int pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageNum,pageSize);
        List<RecruitInfo> list = recruitInfoMapper.getRecruitListDESC(map);
        System.out.println(list.get(0).getTitle());
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int deleteRecruitInfo(Integer id) {
        return recruitInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public RecruitInfo getDetailById(Integer id) {
        RecruitInfo recruitInfo = recruitInfoMapper.selectByPrimaryKey(id);
        return recruitInfo;
    }
}
