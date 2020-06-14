package com.tlp.mybatisdemo.model;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

/**
 * @author：tlp
 * @crateDate：2020/6/13 11:26
 */
@Data
public class PlayerUser {
    private Long id;

    private String name;

    private String address;

    private Date updateTime;

    private Long salary;
}
