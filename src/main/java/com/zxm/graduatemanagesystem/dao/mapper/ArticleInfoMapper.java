package com.zxm.graduatemanagesystem.dao.mapper;

import com.zxm.graduatemanagesystem.model.ArticleInfo;
import com.zxm.graduatemanagesystem.model.ArticleInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    int countByExample(ArticleInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    int deleteByExample(ArticleInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    int insert(ArticleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    int insertSelective(ArticleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    List<ArticleInfo> selectByExampleWithBLOBs(ArticleInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    List<ArticleInfo> selectByExample(ArticleInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    ArticleInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ArticleInfo record, @Param("example") ArticleInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ArticleInfo record, @Param("example") ArticleInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ArticleInfo record, @Param("example") ArticleInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ArticleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(ArticleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ArticleInfo record);

    List<ArticleInfo> getArticleListByTypeDESC(Integer type);
}
