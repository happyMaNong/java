package com.tlp.designpattern.creation.simpleFactory;

/**
 * @className: TestSimpleFactory
 * @description:
 * @author: tianlingpeng
 * @create: 2019-09-12 11:02
 */
public class TestSimpleFactory {
    public static void consumcerService(ServiceFactory serviceFactory) {
        Service service = serviceFactory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args){
        //使用实现1
       // consumcerService(new ServiceImp1Factory());

        //使用实现2
        consumcerService(new ServiceImp2Factory());
    }
}
