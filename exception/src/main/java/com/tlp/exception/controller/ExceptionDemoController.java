package com.tlp.exception.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: ExceptionDemoController
 * @description:
 * @author: tianlingpeng
 * @create: 2019-11-01 11:16
 */
@RestController
public class ExceptionDemoController {
    @PostMapping(value = "pb/catalog/action/test")
    public String tes1(String marc) {
        int i =0;
        System.out.println(1/i);
        return "";
    }
}
