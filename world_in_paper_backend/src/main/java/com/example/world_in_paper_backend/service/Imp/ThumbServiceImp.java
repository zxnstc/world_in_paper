package com.example.world_in_paper_backend.service.Imp;

import com.example.world_in_paper_backend.mapper.ThumbMapper;
import com.example.world_in_paper_backend.service.ThumbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ThumbServiceImp implements ThumbsService {
    @Autowired
    private ThumbMapper thumbMapper;

    @Override
    public Integer getThumbsCountByTopicId(Integer thumbsTopicId, String type) {
        return thumbMapper.getThumbsCountByTopicId(thumbsTopicId,type);
    }

    @Override
    public Integer addThumbs(String topicId, String userId, String type) {
        return thumbMapper.addThumbs(Integer.valueOf(topicId),Integer.valueOf(userId),type);
    }

    @Override
    public Integer isThumbs(String topicId, String userId, String type) {
        return thumbMapper.isThumbs(Integer.valueOf(topicId),Integer.valueOf(userId),type);
    }

    @Override
    public Integer deleteThumbs(String topicId, String userId, String type) {
        return thumbMapper.deleteThumbs(Integer.valueOf(topicId),Integer.valueOf(userId),type);
    }
}
