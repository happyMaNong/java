package com.tlp.thread.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @className: JavaThread
 * @description:
 * @author: tianlingpeng
 * @create: 2019-10-21 14:51
 */
@Slf4j
public class JavaThread {
    public static void main(String[] args){
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            log.info("[{}] {}",threadInfo.getThreadId(),threadInfo.getThreadName());
        }
    }
}
