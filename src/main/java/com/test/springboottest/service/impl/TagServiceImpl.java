package com.test.springboottest.service.impl;

import com.test.springboottest.dao.TagMapper;
import com.test.springboottest.model.Tag;
import com.test.springboottest.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 10:12 AM 2018/10/19
 * @ Description：
 * @ Modified By：
 */
@Service("tagService")
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Tag record) {
        return tagMapper.insert(record);
    }

    @Override
    public int insertSelective(Tag record) {
        return tagMapper.insertSelective(record);
    }

    @Override
    public Tag selectByPrimaryKey(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Tag record) {
        return tagMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Tag record) {
        return tagMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> getTag() {
        return tagMapper.getTag();
    }

    @Override
    public Tag selectByName(String tagName) {
        return tagMapper.selectByName(tagName);
    }
}
