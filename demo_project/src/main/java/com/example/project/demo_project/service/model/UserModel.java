package com.example.project.demo_project.service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserModel {
    private int user_id;
    private String user_name;    
}
