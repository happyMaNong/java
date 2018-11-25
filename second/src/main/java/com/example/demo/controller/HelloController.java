package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：Administrator
 * @crateDate：2018/11/25 12:32
 */
@RestController
public class HelloController {
    @RequestMapping("index")
    public String index() {
        return "HelloWorld!";
    }

    @RequestMapping("find")
    public String find() {
        return "tlp:田凌鹏";
    }
}
