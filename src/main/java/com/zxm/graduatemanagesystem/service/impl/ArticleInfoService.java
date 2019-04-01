package com.zxm.graduatemanagesystem.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.dao.mapper.ArticleInfoMapper;
import com.zxm.graduatemanagesystem.model.ArticleInfo;
import com.zxm.graduatemanagesystem.service.IArticleInfoService;

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
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleInfo> list = articleInfoMapper.getArticleListByTypeDESC(type);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteArticleInfo(Integer id) {
        return articleInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ArticleInfo getDetailById(Integer id) {
        return articleInfoMapper.selectByPrimaryKey(id);
    }
}
