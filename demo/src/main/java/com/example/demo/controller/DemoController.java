package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：tlp
 * @crateDate：2019/9/24 21:10
 */
@RestController
public class DemoController {
    @GetMapping("/hello")
    public String hello() {
        return "HELLOWORLD!";
    }
}
