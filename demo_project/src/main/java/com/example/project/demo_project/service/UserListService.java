package com.example.project.demo_project.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.project.demo_project.model.UserMapper;
import com.example.project.demo_project.service.model.UserModel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class UserListService {
    private final UserMapper mapper;

    public String selectUser() {
        // userテーブル取得
        List<UserModel> userList = mapper.selectAll();

        // StringのListに変換
        List<String> userNameList = userList.stream().map(user -> user.getUser_name()).toList();
        String[] array = userNameList.toArray(new String[userNameList.size()]);

        // Stirngに変換
        return Arrays.toString(array);
    }
}
