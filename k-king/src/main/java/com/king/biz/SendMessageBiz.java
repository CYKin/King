package com.king.biz;

/**
 * 消息发送的接口（接口和抽象类使用）
 * @author King
 * @date 2017/12/21
 */
public interface SendMessageBiz {

    /**
     * 消息发送
     * @param channel
     * @param message
     */
    void send(String channel, String message);

    /**
     * 查询发送状态
     * @param messageId
     */
    void querySendStatus(String messageId);

}
