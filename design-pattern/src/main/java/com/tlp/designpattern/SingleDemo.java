package com.tlp.designpattern;

import com.tlp.designpattern.entity.BmUser;

/**
 * @className: SingleDemo
 * @description:
 * @author: tianlingpeng
 * @create: 2019-09-30 14:21
 */
public class SingleDemo {
    private static volatile BmUser bmUser;

    public static BmUser getInstance(){
        if (bmUser==null){
            synchronized (SingleDemo.class){
                if (bmUser==null){
                    bmUser =new BmUser();
                }
            }
        }
        return bmUser;
    }
}
