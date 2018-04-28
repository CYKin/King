package com.king.biz.impl;

import com.king.biz.UserInfoBiz;
import com.king.entity.UserInfo;
import com.king.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author King
 * @date 2017/12/11
 */
@Service
public class UserInfoBizImpl implements UserInfoBiz {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserInfo selectByPrimaryKey(Long id) {
        return userInfoService.selectByPrimaryKey(id);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        userInfoService.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(UserInfo userInfo) {
        userInfoService.insert(userInfo);
    }

    @Override
    public void updateByPrimaryKey(UserInfo userInfo) {
        userInfoService.updateByPrimaryKey(userInfo);
    }
}
