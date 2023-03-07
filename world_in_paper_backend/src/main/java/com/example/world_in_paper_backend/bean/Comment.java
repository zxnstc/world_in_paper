package com.example.world_in_paper_backend.bean;

import lombok.Data;

import java.util.Date;


@Data
public class Comment {
    private Integer id;
    private String content;
    private Integer commentUserId;
    private Integer commentTopicId;
    private Date commentTime;
    private Integer floorCount;
    private String type;
}
