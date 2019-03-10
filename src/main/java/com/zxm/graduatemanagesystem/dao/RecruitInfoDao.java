package com.zxm.graduatemanagesystem.dao;

import com.zxm.graduatemanagesystem.model.RecruitInfo;

import java.util.List;

/**
 * 2019/3/9
 * Create by zhouximin
 * Description:
 */
public interface RecruitInfoDao {
    List<RecruitInfo> getRecruitListByAuthorDESC(Integer authorId);
}
