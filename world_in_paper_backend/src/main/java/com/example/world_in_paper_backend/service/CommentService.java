package com.example.world_in_paper_backend.service;

import com.example.world_in_paper_backend.bean.R;

import java.util.List;
import java.util.Map;

public interface CommentService {
    public Integer getCommentCountByTopicId(Integer TopicId,String type);

    public R<List<Map<String,Object>>> getCommentListByTopicId(Integer TopicId, String type);

    public R<String> addComment(String topicId, String userId, String content, String type);




}
