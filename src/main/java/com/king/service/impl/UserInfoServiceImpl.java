package com.king.service.impl;

import com.king.entity.UserInfo;
import com.king.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author King
 * @date 2017/12/11
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Override
    public UserInfo selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public void deleteByPrimaryKey(Long id) {}

    @Override
    public void insert(UserInfo userInfo) {}

    @Override
    public void updateByPrimaryKey(UserInfo userInfo) {}
}
