package com.Jaycekon.zookeeper.apache;

import lombok.Getter;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Jaycekon on 2017/9/12.
 */

@Getter
public class ConnectZk implements Watcher {


    private Logger logger = LoggerFactory.getLogger(ConnectZk.class);
    private static final int TIMEOUT = 5000;

    private ZooKeeper zooKeeper;

    private CountDownLatch countDownLatch = new CountDownLatch(1);


    public ConnectZk(String host) {
        try {
            zooKeeper = new ZooKeeper(host, TIMEOUT, this);
        } catch (IOException e) {
            logger.error("创建失败！{}", e.getMessage(), e);
        }
    }

    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }
    }


    public void close() {
        try {
            zooKeeper.close();
        } catch (Exception e) {
            logger.error("关闭失败！{}", e.getMessage(), e);
        }
    }

}
