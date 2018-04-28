package com.king.dao;

import com.king.entity.UserInfo;

/**
 * @author King
 * @date 2017/11/30
 */
public interface UserInfoDao {

    UserInfo selectByPrimaryKey(Long id);

    void deleteByPrimaryKey(Long id);

    void insertUserInfo(UserInfo userInfo);

    void updateByPrimaryKey(UserInfo userInfo);

}
