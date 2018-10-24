package com.test.springboottest.service;

import com.test.springboottest.model.AdminUser;
import com.test.springboottest.model.AdminUserWithBLOBs;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 3:57 PM 2018/10/22
 * @ Description：
 * @ Modified By：
 */
public interface AdminUserService {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminUserWithBLOBs record);

    int insertSelective(AdminUserWithBLOBs record);

    AdminUserWithBLOBs selectByPrimaryKey(Integer id);

    AdminUser selectByUsername(String userName);

    int updateByPrimaryKeySelective(AdminUserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AdminUserWithBLOBs record);

    int updateByPrimaryKey(AdminUser record);
}
