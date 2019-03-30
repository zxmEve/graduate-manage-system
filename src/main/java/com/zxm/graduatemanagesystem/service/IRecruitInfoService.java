package com.zxm.graduatemanagesystem.service;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.RecruitInfo;

import java.util.List;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description:
 */
public interface IRecruitInfoService {
    List<RecruitInfo> getRecruitInfoList();

    int insertRecruitInfo(RecruitInfo recruitInfo);

    int updateRecruitInfo(RecruitInfo recruitInfo);

    PageInfo getRecruitInfoListByAuthorIdDESC(int pageNum, int pageSize, Integer authorId);
    PageInfo getRecruitInfoListDESC(int pageNum, int pageSize);

    int deleteRecruitInfo(Integer id);

    RecruitInfo getDetailById(Integer id);
}
