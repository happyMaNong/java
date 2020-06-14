package com.tlp.mybatisdemo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author itar
 * @mail wuhandzy@gmail.com
 * @date 2020-06-13 06:03:27
 * @since jdk1.8
 */
@Setter
@Getter
public class ClassModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;

    /**
     *
     */
    private Long gradeId;

    /**
     *
     */
    private String className;

    /**
     *
     */
    private Integer studentNum;

    /**
     *
     */
    private String teachers;
}
