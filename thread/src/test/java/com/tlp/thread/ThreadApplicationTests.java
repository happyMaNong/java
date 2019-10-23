package com.tlp.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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


    @Test
    public void test3() throws Exception {
        File file = new File("F:\\下载文件\\河南理工大学最新馆藏\\河南理工大学最新馆藏\\MARC数据-20191008");
        File[] files = file.listFiles();
        File fileName = new File("F:\\下载文件\\河南理工大学最新馆藏\\完整数据.iso");
        BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream(fileName,true));
        for (File file1 : files) {
            FileInputStream fileInputStream = new FileInputStream(file1);
            BufferedInputStream bis = new BufferedInputStream(fileInputStream);
            byte[] buf = new byte[1024*1024];
            while ((bis.read(buf))!=-1){
                bos.write(buf,0,buf.length);
            }
            bis.close();
        }
        bos.close();
    }

}
