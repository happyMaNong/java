package com.tlp.ws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

/**
 * @className: EsTest
 * @description:
 * @author: tianlingpeng
 * @create: 2019-04-12 14:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

    @Test
    public void dateTest() {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        int year = today.getYear();
        int monthValue = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d  Month : %d  day : %d t %n", year, monthValue, day);
    }
}
