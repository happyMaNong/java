package com.tlp.java8.gc;

/**
 * @className: ReferenceCountingGc
 * @description:
 * @author: tianlingpeng
 * @create: 2019-08-09 08:40
 */
public class ReferenceCountingGc {

    private static final int _1MB = 1024 * 1024;

    //堆大小20M 不可扩展 新生代大小 SurvivorRatio Eden和Survivor比例 8:1:1
  //vm参数 -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];

        allocation4 = new byte[4 * _1MB];
        //[PSYoungGen: 6582K->856K(9216K)] 6582K->4960K(19456K)
        // PSYoungGen 表名采用Parallel Scavenge 收集器
        // 方括号内部 6582k ->856k（9216k） 是指Gc前该区域已使用容量 -> GC后该区域已使用容量（该区域总容量）
        // 方括号外部 6582K ->4960（19456k）是指Gc前java堆已使用容量 -> Gc后java堆已使用容量（java堆总容量）
    }
}
