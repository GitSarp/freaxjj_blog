package com.test.springboottest.service;

import com.test.springboottest.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 10:11 AM 2018/10/19
 * @ Description：标签服务
 * @ Modified By：
 */

public interface TagService {

    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    Tag selectByName(String tagName);

    //
    List<Map> getTag();
}
