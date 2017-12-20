package com.king.service.impl;

import com.king.dao.UserInfoDao;
import com.king.entity.UserInfo;
import com.king.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author King
 * @date 2017/12/11
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo selectByPrimaryKey(Long id) {
        return userInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        userInfoDao.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(UserInfo userInfo) {
        userInfoDao.insertUserInfo(userInfo);
    }

    @Override
    public void updateByPrimaryKey(UserInfo userInfo) {
        userInfoDao.updateByPrimaryKey(userInfo);
    }
}
