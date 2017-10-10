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

    private static final String HOME_URL = "127.0.0.1";

    private Logger logger = LoggerFactory.getLogger(ListGroup.class);


    @Test
    public void list() {
        ConnectZk zk = new ConnectZk(HOME_URL);
        try {
            List<String> childs = zk.getZooKeeper().getChildren("/zookeeper", false);
            childs.forEach(System.out::print);
        } catch (Exception e) {
            logger.error("处理失败！{}", e.getMessage(), e);
        } finally {
            zk.close();
        }
    }

    @Test
    public void delete() {
        ConnectZk zk = new ConnectZk(HOME_URL);

        try {
            zk.getZooKeeper().delete("/test", -1);
        } catch (Exception e) {
            logger.error("删除节点失败！：{}", e.getMessage(), e);
        }finally {
            zk.close();
        }

    }
}
