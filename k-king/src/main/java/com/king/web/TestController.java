package com.king.web;

import com.king.biz.TestBiz;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author King
 * @date 2017/11/28
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Resource
    @Qualifier("testBizImplA")
    private TestBiz testBiz;

    @ResponseBody
    @RequestMapping(value = "/getTest")
    public void getTest(){
        testBiz.getTest();
    }

}
