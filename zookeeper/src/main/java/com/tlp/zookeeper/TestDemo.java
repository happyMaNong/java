package com.tlp.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author：tlp
 * @crateDate：2019/9/9 21:32
 */

public class TestDemo implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zk = null;

    private static Stat stat = new Stat();

    public static void main(String[] args) throws Exception {
        String path = "/username";

        zk = new ZooKeeper("192.168.217.20:2181", 5000, new TestDemo());
        countDownLatch.await();
        System.out.println(new String(zk.getData(path, true, stat)));
        Thread.sleep(Integer.MAX_VALUE);

    }

    @Override
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
        if (event.getType().equals(Event.EventType.NodeDataChanged)) {
            try {
                System.out.println("----------------------------");
                System.out.println("配置已修改，新值为：" + new String(zk.getData(event.getPath(), true, stat)));
            } catch (Exception e) {
            }
        }
    }
}
