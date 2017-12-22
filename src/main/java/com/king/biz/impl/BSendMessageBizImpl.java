package com.king.biz.impl;

import com.king.biz.AbstractSendMessageBizImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 继承抽象类的子类需要实现抽象类中的抽象方法
 * 需要实现抽象类中没有实现接口中的方法
 * @author King
 * @date 2017/12/21
 */
@Service("channelB")
public class BSendMessageBizImpl extends AbstractSendMessageBizImpl {

    private static final Logger logger = LoggerFactory.getLogger(BSendMessageBizImpl.class);

    /**
     * 抽象方法实现
     * @param channel
     * @param message
     */
    @Override
    protected void doSend(String channel, String message) {
        System.out.println("channelB: "+channel+" send "+message+" has been sent!");
        System.out.println("channelB: "+channel+" send message success!");
    }

    /**
     * 接口方法实现
     * @param messageId
     */
    @Override
    public void querySendStatus(String messageId) {
        System.out.println(messageId+" send success!");
    }
}
