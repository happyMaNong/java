package com.tlp.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

public class ThreadApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
    public void test1() {
	    List<String> list = null;
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() {
        //有效内存
        long totalMemory = Runtime.getRuntime().totalMemory();

        //最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu核心数："+i);

        //你本地物理内存的1/16,误差在百分之十之内。
        System.out.println("最小内存"+totalMemory/(1024*1024)+"兆");

        //你本地物理内存的四分之一，误差在百分之十之内。
        System.out.println("最大内存"+maxMemory/(1024*1024)+"兆");

    }

}
