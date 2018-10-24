package com.test.springboottest.dao;

import com.test.springboottest.model.AdminUser;
import com.test.springboottest.model.AdminUserWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminUserWithBLOBs record);

    int insertSelective(AdminUserWithBLOBs record);

    AdminUserWithBLOBs selectByPrimaryKey(Integer id);

    AdminUser selectByUsername(String userName);

    int updateByPrimaryKeySelective(AdminUserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AdminUserWithBLOBs record);

    int updateByPrimaryKey(AdminUser record);
}