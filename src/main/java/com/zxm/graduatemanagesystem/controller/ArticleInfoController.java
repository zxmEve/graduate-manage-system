package com.zxm.graduatemanagesystem.controller;

import javax.annotation.Resource;

import com.zxm.graduatemanagesystem.constants.ArticalTypeEnum;
import com.zxm.graduatemanagesystem.constants.StatusEnum;
import com.zxm.graduatemanagesystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.zxm.graduatemanagesystem.constants.ArticalTypeEnum;
import com.zxm.graduatemanagesystem.model.ArticleInfo;
import com.zxm.graduatemanagesystem.service.impl.ArticleInfoService;

import java.util.Date;

/**
 * @author zhouximin
 * Created on 2019-03-10
 */

@RequestMapping("/article")
@Controller
@SessionAttributes("loginUser")
public class ArticleInfoController {

    @Resource
    private ArticleInfoService articleInfoService;


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    String insertArticle(ArticleInfo articleInfo, Model model, @ModelAttribute("loginUser")User user) {
//        ArticleInfo articleInfo = new ArticleInfo();
//        articleInfo.setContent(content);
//        articleInfo.setTitle(title);
//        articleInfo.setType(type.byteValue());
        articleInfo.setCreateTime(new Date());
        articleInfo.setStatus((byte)StatusEnum.NORMAL.getIntValue());
        articleInfo.setAuthorId(user.getId());
        System.out.println(articleInfo.getContent());
        System.out.println(articleInfo.getTitle());
        int ret = articleInfoService.insertArticleInfo(articleInfo);
        if(ret > 0){
            return "redirect:/article/toArticleTable?type="+articleInfo.getType();
        }else{
            return "error" ;
        }
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
        String name = ArticalTypeEnum.getDescById(articleInfo.getType());
        model.addAttribute("type",name);
        model.addAttribute("info", articleInfo);
        return "/front/article";
    }

    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public String toListPage(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize,
                             @RequestParam(required = true) int articleType) {
        PageInfo pageInfo = articleInfoService.getArticleInfoListByTypeDESC(pageNum, pageSize, articleType);
        String name = ArticalTypeEnum.getDescById(articleType);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("type",name);
        return "/front/article_list";
    }

    @RequestMapping(value = "/toPublishArticle", method = RequestMethod.GET)
    public String toPublishArticle(Model modle) {
        modle.addAttribute("articleTypes", ArticalTypeEnum.values());
        return "/admin/publish_article";
    }

    @RequestMapping(value = "/toArticleTable")
    public String toRecruitInfoTable(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize, @RequestParam(defaultValue = "1") int type){
        PageInfo pageInfo = articleInfoService.getArticleInfoListByTypeDESC(pageNum,pageSize,type);
        model.addAttribute("articleTypes", ArticalTypeEnum.values());
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("type",type);
        return "/admin/article_table";
    }

}
