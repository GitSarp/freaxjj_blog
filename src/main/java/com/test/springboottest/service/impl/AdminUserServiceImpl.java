package com.test.springboottest.service.impl;

import com.test.springboottest.dao.AdminUserMapper;
import com.test.springboottest.model.AdminUser;
import com.test.springboottest.model.AdminUserWithBLOBs;
import com.test.springboottest.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 3:57 PM 2018/10/22
 * @ Description：
 * @ Modified By：
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;

    @Override
    public AdminUser selectByUsername(String userName) {
        return adminUserMapper.selectByUsername(userName);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(AdminUserWithBLOBs record) {
        return adminUserMapper.insert(record);
    }

    @Override
    public int insertSelective(AdminUserWithBLOBs record) {
        return 0;
    }

    @Override
    public AdminUserWithBLOBs selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(AdminUserWithBLOBs record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(AdminUserWithBLOBs record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(AdminUser record) {
        return 0;
    }
}
