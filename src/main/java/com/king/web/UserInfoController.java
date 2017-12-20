package com.king.web;

import com.king.biz.UserInfoBiz;
import com.king.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author King
 * @date 2017/12/11
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoBiz userInfoBiz;

    @ResponseBody
    @RequestMapping(value = "/selectByPrimaryKey",produces="application/json;charset=UTF-8")
    public UserInfo selectByPrimaryKey(Long id){
        return userInfoBiz.selectByPrimaryKey(id);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteByPrimaryKey",produces="application/json;charset=UTF-8")
    public void deleteByPrimaryKey(Long id){
        userInfoBiz.deleteByPrimaryKey(id);
    }

    @ResponseBody
    @RequestMapping(value = "/insert",produces="application/json;charset=UTF-8")
    public void insert(@RequestBody UserInfo userInfo){
        System.out.println("----- 数据插入如成功....");
        //userInfoBiz.insert(userInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/updateByPrimaryKey",produces="application/json;charset=UTF-8")
    public void updateByPrimaryKey(UserInfo userInfo){
        userInfoBiz.updateByPrimaryKey(userInfo);
    }
}
