package com.test.springboottest.dao;

import com.test.springboottest.model.Article;
import com.test.springboottest.model.ArticleWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    ArticleWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);

    //添加的接口
    List<ArticleWithBLOBs> selectSelective(Map<String,Object> map);

    int countTop(String gmtCreateStr);//计算未发布的和置顶的博客数

    int count(String gmtCreateStr);

    List<ArticleWithBLOBs> page(Map<String,Object> map);

    List<Map> getArchive();
}