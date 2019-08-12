package cn.tlp.ws.controller;

import cn.tlp.ws.service.RefreshGtMarcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: SendSchedule
 * @description:
 * @author: tianlingpeng
 * @create: 2019-04-30 16:37
 */
@RestController
public class SendSchedule {
    @Autowired
    private RefreshGtMarcService refreshGtMarcService;

    @GetMapping("/socket/demo")
    public String returnJd() {
        return refreshGtMarcService.sendSchedule();
    }

    @GetMapping("/socket/hello")
    public String hello() {
        return "111111";
    }

    @GetMapping("/dl/test")
    public String singletionTest(int i) {
        return refreshGtMarcService.singletionTest(i);
    }
}
