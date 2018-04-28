package com.king.testA;

import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 同步线程
 * @author wangchangyong
 * @create 2018/01/22 15:25
 */
public class SyncThreadTest implements Runnable {

    private final static Logger logger = LoggerFactory.getLogger(SyncThreadTest.class);

    private static int count = 0;

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }


    public static void main(String[] args) {
        SyncThreadTest syncThread = new SyncThreadTest();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
    }

}
