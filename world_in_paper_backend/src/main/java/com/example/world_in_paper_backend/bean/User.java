package com.example.world_in_paper_backend.bean;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String introduction;
    private String rank;
    private Integer roleId;
    private Integer state;


}
