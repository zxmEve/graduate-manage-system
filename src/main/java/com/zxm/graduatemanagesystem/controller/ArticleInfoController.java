package com.zxm.graduatemanagesystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.constants.ArticalTypeEnum;
import com.zxm.graduatemanagesystem.model.ArticleInfo;
import com.zxm.graduatemanagesystem.service.impl.ArticleInfoService;

/**
 * @author zhouximin
 * Created on 2019-03-10
 */

@RequestMapping("/article")
@Controller
public class ArticleInfoController {

    @Resource
    private ArticleInfoService articleInfoService;


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public boolean insertArticle(@RequestBody ArticleInfo articleInfo) {
        int ret = articleInfoService.insertArticleInfo(articleInfo);
        return ret > 0;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateArticleInfo(@RequestBody ArticleInfo articleInfo) {
        int ret = articleInfoService.updateArticleInfo(articleInfo);
        return ret > 0;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageInfo articleInfoListByTypeDESC(@RequestParam int pageNum, @RequestParam int pageSize,
                                              @RequestParam("articleType") int type) {
        return articleInfoService.getArticleInfoListByTypeDESC(pageNum, pageSize, type);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public boolean deleteArticleInfo(@RequestParam("articleId") int articleId) {
        int ret = articleInfoService.deleteArticleInfo(articleId);
        return ret > 0;
    }


    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(Model model, @RequestParam Integer id) {
        ArticleInfo articleInfo = articleInfoService.getDetailById(id);
        model.addAttribute("info", articleInfo);
        return "/front/article";
    }

    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public String toListPage(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, @RequestParam int articleType) {
        PageInfo pageInfo = articleInfoService.getArticleInfoListByTypeDESC(pageNum, pageSize, articleType);
        model.addAttribute("pageInfo", pageInfo);
        return "/front/article_list";
    }

    @RequestMapping(value = "/toPublishArticle", method = RequestMethod.GET)
    public String toPublishArticle(Model modle) {
        modle.addAttribute("articleTypes", ArticalTypeEnum.values());
        return "/admin/publish_article";
    }

}
