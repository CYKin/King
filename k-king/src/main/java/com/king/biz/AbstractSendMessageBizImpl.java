package com.king.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 抽象的消息发送类
 * 抽象类可以不用实现接口的全部方法，继承它的子类去实现它们
 * @author King
 * @date 2017/12/21
 */
@Service
public abstract class AbstractSendMessageBizImpl implements SendMessageBiz{

    private static final Logger logger = LoggerFactory.getLogger(AbstractSendMessageBizImpl.class);

    /**
     * 实现接口中的方法
     * @param channel 通道
     * @param message 消息
     */
    @Override
    public void send(String channel, String message) {
        System.out.println("----- 请求参数校验.....");
        System.out.println("----- 保存发送日志.....");
        doSend(channel,message);
        System.out.println("----- 发送日志状态更新.....");
    }

    /**
     * 继承抽象类的方法具体实现消息的发送
     */
    protected abstract void doSend(String channel,String message);

}
