package com.tlp.mybatisdemo.controller;

import com.tlp.mybatisdemo.mapper.IUserMapper;
import com.tlp.mybatisdemo.model.GradeModel;
import com.tlp.mybatisdemo.model.PlayerUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：tlp
 * @crateDate：2020/6/13 11:20
 */
@RestController
@Api("运动员Controller")
@Slf4j
public class MybatisController {
    @Autowired
    private IUserMapper userMapper;

    @ApiOperation(value = "查询所有运动员")
    @PostMapping("/findAllUser")
    public List<PlayerUser> findAllUser(@RequestBody PlayerUser user) {
       return userMapper.findAllUserList(user);
    }
    @ApiOperation(value = "新增运动员")
    @PostMapping("/addUser")
    public int addUser(@RequestBody List<PlayerUser> users) {
        int i = userMapper.batchAddUser(users);
        users.forEach(user -> {
           log.info("id:{},name{}",user.getId(),user.getName());
        });
        return i;
    }

    @ApiOperation(value = "更新运动员信息")
    @PostMapping("/updateUser")
    public int updateUser(@RequestBody List<PlayerUser> users) {
        return userMapper.batchUpdateUser(users);
    }

    @ApiOperation(value = "查询所有班级信息")
    @PostMapping("/findGradeInfo")
    public List<GradeModel> findGradeInfo() {
        return userMapper.findGradeInfo();
    }
}
