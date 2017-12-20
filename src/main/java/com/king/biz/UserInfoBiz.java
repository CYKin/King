package com.king.biz;

import com.king.entity.UserInfo;

/**
 * @author King
 * @date 2017/12/11
 */
public interface UserInfoBiz {

    UserInfo selectByPrimaryKey(Long id);

    void deleteByPrimaryKey(Long id);

    void insert(UserInfo userInfo);

    void updateByPrimaryKey(UserInfo userInfo);
}
