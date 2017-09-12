package com.Jaycekon.zookeeper.apache;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Jaycekon on 2017/9/12.
 */
public class listGroup implements Watcher {


    private static final int TIMEOUT = 5000;


    private ZooKeeper zk;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent event) {
        if(event.getState()== Event.KeeperState.SyncConnected){
            countDownLatch.countDown();
        }
    }

    private void  close() throws InterruptedException {
        zk.close();
    }

    private void create(String groupName) throws KeeperException, InterruptedException {
        String path="/"+groupName;
        if(zk.exists(path, false)== null){
            zk.create(path, null/*data*/, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        System.out.println("Created:"+path);
    }


    private void connect(String hosts) throws IOException, InterruptedException {
        zk = new ZooKeeper(hosts,TIMEOUT,this);
        countDownLatch.await();
    }


    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        listGroup group = new listGroup();
        group.connect("127.0.0.1");
        group.create("test");
        group.close();

    }
}
