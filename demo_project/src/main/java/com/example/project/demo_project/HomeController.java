package com.example.project.demo_project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return "Hello demo world!";
    }
}