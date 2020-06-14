package com.tlp.mybatisdemo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author itar
 * @mail wuhandzy@gmail.com
 * @date 2020-06-13 06:03:28
 * @since jdk1.8
 */
@Setter
@Getter
public class GradeModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;

    /**
     *
     */
    private String gradeName;

    /**
     *
     */
    private Long studentNum;

    /**
     *
     */
    private String address;

    /**
     *
     */
    private String teachers;

    List<ClassModel> classList;
}
