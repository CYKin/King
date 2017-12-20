package com.king.service;

import com.king.entity.UserInfo;

/**
 * @author King
 * @date 2017/12/11
 */
public interface UserInfoService {

    UserInfo selectByPrimaryKey(Long id);

    void deleteByPrimaryKey(Long id);

    void insert(UserInfo userInfo);

    void updateByPrimaryKey(UserInfo userInfo);
}
