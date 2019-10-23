package com.tlp.java8.weekreference;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author：tlp
 * @crateDate：2019/10/22 22:14
 */
@Slf4j
public class TestWeekReference {
    private static WeakHashMap<WeakReference<String>,String> map = null;
    public static void main(String[] args){
        clMap();
        log.info("map的size {}",map.size());
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("map的size {}",map.size());

    }

    public static void clMap() {
        map = new WeakHashMap<>();
        WeakReference<String> key = new  WeakReference<String>("name");
        String value = new String("tlp");
        map.put(key,value);
        key=null;
        value =null;
    }
}
