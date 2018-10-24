package com.test.springboottest.dao;

import com.test.springboottest.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    Tag selectByName(String tagName);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    //
    List<Map> getTag();
}