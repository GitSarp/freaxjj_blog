package com.test.springboottest.service.impl;

import com.test.springboottest.dao.ArticleMapper;
import com.test.springboottest.model.Article;
import com.test.springboottest.model.ArticleWithBLOBs;
import com.test.springboottest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 4:42 PM 2018/10/18
 * @ Description：
 * @ Modified By：
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ArticleWithBLOBs record) {
        return articleMapper.insert(record);
    }

    @Override
    public int insertSelective(ArticleWithBLOBs record) {
        return articleMapper.insertSelective(record);
    }

    @Override
    public ArticleWithBLOBs selectByPrimaryKey(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ArticleWithBLOBs> selectSelective(Map<String,Object> map) {
        return articleMapper.selectSelective(map);
    }

    @Override
    public int countTop(String gmtCreateStr) {
        return articleMapper.countTop(gmtCreateStr);
    }

    @Override
    public int count(String gmtCreateStr) {
        return articleMapper.count(gmtCreateStr);
    }

    @Override
    public List<ArticleWithBLOBs> page(Map<String, Object> map) {
        return articleMapper.page(map);
    }

    @Override
    public List<Map> getArchive() {
        return articleMapper.getArchive();
    }

    @Override
    public int updateByPrimaryKeySelective(ArticleWithBLOBs record) {
        return articleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record) {
        return articleMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Article record) {
        return articleMapper.updateByPrimaryKey(record);
    }
}
