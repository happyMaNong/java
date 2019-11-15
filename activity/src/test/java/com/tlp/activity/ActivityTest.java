package com.tlp.activity;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className: ActivityTest
 * @description:
 * @author: tianlingpeng
 * @create: 2019-11-02 14:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityTest {

//    @Autowired
//    private RuntimeService runtimeService;
//    @Autowired
//    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;


    @Test
    public void createTable(){

    }
}
