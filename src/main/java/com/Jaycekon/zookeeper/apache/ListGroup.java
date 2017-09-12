package com.Jaycekon.zookeeper.apache;

import org.apache.zookeeper.KeeperException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Jaycekon on 2017/9/12.
 */
public class ListGroup {

    private Logger logger = LoggerFactory.getLogger(ListGroup.class);


    @Test
    public void list() {
        ConnectZk zk = new ConnectZk("127.0.0.1");
        try {
            List<String> childs = zk.getZooKeeper().getChildren("/zookeeper", false);
            childs.forEach(System.out::print);
        } catch (Exception e) {
            logger.error("处理失败！{}", e.getMessage(), e);
        } finally {
            zk.close();
        }
    }
}
