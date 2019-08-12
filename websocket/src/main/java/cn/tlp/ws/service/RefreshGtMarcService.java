package cn.tlp.ws.service;

import cn.tlp.ws.config.WebSocketServer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: RefreshGtMarcService
 * @description:i
 * @author: tianlingpeng
 * @create: 2019-04-30 16:22
 */
@Service
public class RefreshGtMarcService {

    static List<RefreshGtMarcService> list = new ArrayList<>();

    private int count;

    public String sendSchedule() {
        int sum = 100;
        int count = 0;
        while (count <= sum) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double i = ((float)count / (float)sum) * 100;
            System.out.println(i);
            WebSocketServer.sendInfo(i + "", "33");
            count++;
        }
        return "200";
    }

    public String singletionTest(int i) {
        this.count = i;
        list.add(this);
        System.out.println(this);
        return "";
    }
    public static void main(String[] args){
        float i = (float)1/(float)100;
    }
}
