package com.example.world_in_paper_backend.service;

import com.example.world_in_paper_backend.bean.R;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    public R<Map<String,Object>> getArticle(String articleId);

    public R<String> addArticle(String title, String content, String creatorId, String columnId,String coverImg);

    R<List<Map<String, Object>>> getArticleByUserId(String keyuserId);

    R<String> deleteArticleById(String articleId);

    R<String> thumbUpArticle(String articleId, String userId);
}
