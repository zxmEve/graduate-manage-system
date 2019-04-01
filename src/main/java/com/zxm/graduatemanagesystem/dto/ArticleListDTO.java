package com.zxm.graduatemanagesystem.dto;

import lombok.Data;

import java.util.Date;

/**
 * 2019/3/7
 * Create by zhouximin
 * Description: 后台文章列表页需要返回的数据
 */
@Data
public class ArticleListDTO {
    Integer id;

    String title;

    Date createTime;

    Integer type;
}
