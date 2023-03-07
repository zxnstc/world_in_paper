package com.example.world_in_paper_backend.service;

public interface ThumbsService {



    public Integer getThumbsCountByTopicId(Integer thumbsTopicId, String type);

    public Integer addThumbs(String topicId, String userId, String type);

    public Integer deleteThumbs(String topicId, String userId, String type);

    //是否点过赞了
    public Integer isThumbs(String topicId, String userId, String type);
}
