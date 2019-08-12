package cn.tlp.ws.controller;

import cn.tlp.ws.config.WebSocketServer;
import cn.tlp.ws.service.RefreshGtMarcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @className: CheckCenterController
 * @description:
 * @author: tianlingpeng
 * @create: 2019-03-14 11:19
 */

@RestController("/checkcenter")
public class CheckCenterController {



    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }
    //推送数据接口

    @GetMapping("/socket/push/{cid}")
    public String pushToWeb(@PathVariable String cid, String message) {
        WebSocketServer.sendInfo(message, cid);
        return cid;
    }


}

