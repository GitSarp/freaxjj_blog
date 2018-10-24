package com.test.springboottest.service;

import com.test.springboottest.model.Article;
import com.test.springboottest.model.ArticleWithBLOBs;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 4:41 PM 2018/10/18
 * @ Description：
 * @ Modified By：
 */

public interface ArticleService {
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
