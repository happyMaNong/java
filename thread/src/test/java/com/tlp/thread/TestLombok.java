package com.tlp.thread;

import com.tlp.thread.entity.BmUser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author：tlp
 * @crateDate：2019/9/8 10:58
 */
public class TestLombok {

    @Test
    public void testGetAndSet() {
        BmUser bmUser = new BmUser();
        bmUser.setName("测试1");

        System.out.println(bmUser.getName());
    }

    @Test
    //java.util.ConcurrentModificationException
    public void testForeach() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        for (Integer integer : vector) {
            if (integer == 3) {
                vector.remove(integer);
            }
        }
    }

    @Test
    public void testIterator() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)){
                vector.remove(i);
            }
        }
    }



    @Test
    public void testFor() {
     // Vector<Integer> vector = new Vector<>();
        List<Integer> vector = new ArrayList<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i).equals(1)) {
                vector.remove(i);
            }
        }
    }
}
