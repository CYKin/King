package com.king.quartz;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务
 * @author wangchangyong
 * @create 2018/02/27 14:55
 */
@Service
public class Task implements InitializingBean {

    //JDK的一个定时调度任务的实现，可以实现定时循环调度
    private ScheduledThreadPoolExecutor ste = new ScheduledThreadPoolExecutor(1);

    int i = 0;

    @Override
    public void afterPropertiesSet() throws Exception {
        //固定延迟循环调度（当结束前一个任务后延迟一段时间执行任务）
        ste.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                count();
            }
        }, 5, 1, TimeUnit.SECONDS);//延时5s开启,间隔1s执行一次
    }

    public void count(){
        System.out.println("开始计数："+ i);
        i++;
    }
}
