package com.zxm.graduatemanagesystem.service;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.model.ArticleInfo;

import java.util.List;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description:
 */
public interface IArticleInfoService {
    List<ArticleInfo> getArticleInfoList();

    int insertArticleInfo(ArticleInfo articleInfo);

    int updateArticleInfo(ArticleInfo articleInfo);

    PageInfo getArticleInfoListByTypeDESC(int pageNum, int pageSize, Integer type);

    int deleteArticleInfo(Integer id);


}
