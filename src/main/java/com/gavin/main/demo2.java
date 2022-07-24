package com.gavin.main;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 17428 on 2022/5/8.
 */
public class demo2   implements Watcher {

   //多线程中充当一个计时器的功能，维护一个count变量，其操作都是原子性操作----多线程并发编程管理工具
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();


    public static void main(String[] args) throws Exception {
        System.out.println(11);

        System.out.println("hello");
        java.lang.String path = "/root";

        //连接zk的核心类
        zk = new ZooKeeper("192.168.1.7:2181", 5000, new demo2());
        connectedSemaphore.await();//等待zk链接成功---当前线程进入阻塞状态

        //获取path目录节点的配置数据，并注册默认的监听器
        byte[] data  = zk.getData(path, true, stat);

        java.lang.String s = data.toString();//这个就是实时获取zk更新信息的了
        System.out.println("获取到的数据是："+s);



        Thread.sleep(Integer.MAX_VALUE);

    }

    @Override
    public void process(WatchedEvent event) {//观察者模式的实现
      //keeperstatr是记录连接状态的枚举类；eventtype是记录操作类的的枚举类
        if (Event.KeeperState.SyncConnected == event.getState()) {
            if (Event.EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();//是的count减一：这里减一，那么29行的wait阻塞就会解除继续往下执行
            } else if (event.getType() == Event.EventType.NodeDataChanged) {  //zk目录节点数据变化通知事件
                try {
                    System.out.println("配置已修改，新值为：" + new String(zk.getData(event.getPath(), true, stat)));
                } catch (Exception e) {
                }
            }

        }

    }
}
