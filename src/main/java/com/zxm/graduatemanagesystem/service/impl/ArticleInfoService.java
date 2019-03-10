package com.zxm.graduatemanagesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.dao.mapper.ArticleInfoMapper;
import com.zxm.graduatemanagesystem.model.ArticleInfo;
import com.zxm.graduatemanagesystem.service.IArticleInfoService;
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
public class ArticleInfoService implements IArticleInfoService {

    @Resource
    ArticleInfoMapper articleInfoMapper;

    @Override
    public List<ArticleInfo> getArticleInfoList() {
        return null;
    }

    @Override
    public int insertArticleInfo(ArticleInfo articleInfo) {
        articleInfo.setCreateTime(new Date());
        return articleInfoMapper.insertSelective(articleInfo);
    }

    @Override
    public int updateArticleInfo(ArticleInfo articleInfo) {
        return articleInfoMapper.updateByPrimaryKeySelective(articleInfo);
    }

    @Override
    public PageInfo getArticleInfoListByTypeDESC(int pageNum, int pageSize, Integer type) {
        List<ArticleInfo> list = articleInfoMapper.getArticleListByTypeDESC(type);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteArticleInfo(Integer id) {
        return 0;
    }
}
