package com.example.project.demo_project.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.project.demo_project.service.model.UserModel;

@Mapper
public interface UserMapper {
    @Select("SELECT user_id, user_name FROM t_user")
    List<UserModel> selectAll();
}
