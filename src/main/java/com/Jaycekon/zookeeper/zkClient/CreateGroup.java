package com.Jaycekon.zookeeper.zkClient;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Jaycekon on 2017/9/6.
 */
public class CreateGroup implements Watcher {

    private ZooKeeper zk;
    //会话延时
    private static final int SESSION_TIMEOUT = 1000;

    private CountDownLatch countDownLatch = new CountDownLatch(1);
    public void process(WatchedEvent event) {
        if(event.getState() == Event.KeeperState.SyncConnected){
            countDownLatch.countDown();//计数器减一
        }
    }


    public void connect(String hosts) throws IOException, InterruptedException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        countDownLatch.await();//阻塞程序继续执行
    }

    public void create(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        String createPath = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE/*允许任何客户端对该znode进行读写*/, CreateMode.PERSISTENT/*持久化的znode*/);
        System.out.println("Created " + createPath);
    }



    public void close() throws InterruptedException {
        if(zk != null){
            try {
                zk.close();
            } catch (InterruptedException e) {
                throw e;
            }finally{
                zk = null;
                System.gc();
            }
        }
    }
}
