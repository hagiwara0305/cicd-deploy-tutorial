package com.example.project.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project.demo_project.service.UserListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {

    // 通常
    @RequestMapping(value = "/")
    @ResponseBody
    public String hello(){
        return "Hello demo world!";
    }

    // HTTPメソッド
    @GetMapping(value = "/get")
    @ResponseBody
     public String getMethod(
        @RequestParam(name = "parameter",
            defaultValue = "SAMPLE",
            required = false) String name) {
        return name;
    }

    // ユーザリストを取得するためのサービスクラス
    @Autowired
    private final UserListService service;

    // DBアクセス + サービスクラス
    @RequestMapping(value = "/userList")
    @ResponseBody
    public String getUserList(){
        return service.selectUser();
    }
}