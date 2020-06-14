package com.tlp.mybatisdemo.mapper;

import com.tlp.mybatisdemo.model.GradeModel;
import com.tlp.mybatisdemo.model.PlayerUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserMapper {
    List<PlayerUser> findAllUserList(@Param("user") PlayerUser user);

    int batchAddUser(List<PlayerUser> list);

    int batchUpdateUser(List<PlayerUser> list);

    List<GradeModel> findGradeInfo();
}
