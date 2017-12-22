package com.king.test;

import com.king.biz.SendMessageBiz;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author King
 * @date 2017/12/21
 */
public class SendMessageTest{

    ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring/applicationContext.xml");

    @Test
    public void sendMessageTest(){
        SendMessageBiz sendMessageBiz = (SendMessageBiz) applicationContext.getBean("channelA");
        sendMessageBiz.send("AA","123");
    }

}
