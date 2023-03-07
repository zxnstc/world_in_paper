package com.example.world_in_paper_backend.service;

import com.example.world_in_paper_backend.bean.Comment;
import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.bean.Topic;
import com.example.world_in_paper_backend.bean.User;

import java.util.ArrayList;
import java.util.Map;

public interface ForumService {


    public R<ArrayList<Map<String,Object>>> getTopicList(Integer currentPage, Integer pageSize, String userId);

    public R<Map<String, Object>> getTopicDetail(String id);

    public R<ArrayList<Map<String,Object>>> searchTopic(String keyword, String userId);

    public R<ArrayList<Comment>> getTopicComment(String topicId);

    public R<String> likeTopic(String topicId, String userId);

    public R<String> addTopicComment(String topicId, String content, String userId);

    public R<ArrayList<Map<String, Object>>> getTopAuthorList();

    public R<String> addTopic(String title, String content, String userId);

    public R<String> deleteTopic(String topicId);

    public R<Map<String,Object>> getAllCommentCount();

    public R<Map<String,Object>> getAllVisitCount();


    R<ArrayList<Map<String, Object>>> searchTopicByUserId(String keyUserId, String userId);

    R<String> deleteTopicById(String topicId);

}
