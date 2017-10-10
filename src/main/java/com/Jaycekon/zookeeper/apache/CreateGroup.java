package com.Jaycekon.zookeeper.apache;


import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Jaycekon on 2017/9/12.
 */
public class CreateGroup {

    private static Logger logger = LoggerFactory.getLogger(CreateGroup.class);

    @Test
    public void create() {
        ConnectZk zk = new ConnectZk("127.0.0.1");
        try {
            zk.getZooKeeper().create("/Jayce", "Jaycekon".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (Exception e) {
            logger.error("处理失败!{}", e.getMessage(), e);
        } finally {
            zk.close();
        }
    }
}
