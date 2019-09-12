package com.tlp.designpattern.creation.simpleFactory;

/**
 * @className: ServiceImp1Factory
 * @description:
 * @author: tianlingpeng
 * @create: 2019-09-12 11:01
 */
public class ServiceImp1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new ServiceImpl1();
    }
}
