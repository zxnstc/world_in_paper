package com.example.world_in_paper_backend.controller;

import com.example.world_in_paper_backend.annotation.LoginRequire;
import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.service.Imp.ArticleServiceImp;
import com.example.world_in_paper_backend.service.Imp.CommentServiceImp;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleServiceImp articleServiceImp;

    @Autowired
    private CommentServiceImp commentServiceImp;

    @ApiOperation(value = "获取文章", notes = "获取文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章的id", required = true),

    })
    @GetMapping("/getArticle")
    public R<Map<String, Object>> getArticle(@RequestParam String articleId) {

        return articleServiceImp.getArticle(articleId);
    }

    @ApiOperation(value = "获取文章的评论", notes = "获取文章的评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章的id", required = true),

    })
    @GetMapping("/getArticleComments")
    public R<List<Map<String, Object>>> getArticleComments(@RequestParam String articleId) {

        return commentServiceImp.getCommentListByTopicId(Integer.valueOf(articleId), "2");
    }

    @ApiOperation(value = "添加文章的评论", notes = "添加文章的评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章的id", required = true),
            @ApiImplicitParam(name = "userId", value = "用户的id", required = true),
            @ApiImplicitParam(name = "comment", value = "评论内容", required = true),
    })
    @PostMapping("/addArticleComment")
    @LoginRequire
    public R<String> addArticleComment(@RequestParam String articleId, @RequestParam String userId, @RequestParam String comment) {

        return commentServiceImp.addComment(articleId, userId, comment, "2");
    }

    @ApiOperation(value = "添加文章", notes = "添加文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户的id", required = true),
            @ApiImplicitParam(name = "title", value = "标题", required = true),
            @ApiImplicitParam(name = "content", value = "内容", required = true),
            @ApiImplicitParam(name = "columnId", value = "专栏的id", required = true),
            @ApiImplicitParam(name = "coverImage", value = "封面图片", required = true)

    })
    @PostMapping("/addArticle")
    @LoginRequire
    public R<String> addArticle(@RequestParam String userId, @RequestParam String title, @RequestParam String content, @RequestParam String coverImage, @RequestParam String columnId) {

        return articleServiceImp.addArticle(title, content, userId, columnId, coverImage);
    }

    @ApiOperation(value = "根据UserId获取文章", notes = "根据UserId获取文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "KeyuserId", value = "目的uerId", required = true),
    })
    @GetMapping("/getArticleByUserId")
    public R<List<Map<String, Object>>> getArticleByUserId(@RequestParam String KeyuserId) {

        return articleServiceImp.getArticleByUserId(KeyuserId);
    }

    @ApiOperation(value = "删除文章", notes = "删除文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章的id", required = true),
    })
    @PostMapping("/deleteArticleById")
    @LoginRequire
    public R<String> deleteArticleById(@RequestParam String articleId) {

        return articleServiceImp.deleteArticleById(articleId);
    }

    @ApiOperation(value = "点赞文章", notes = "点赞文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章的id", required = true),
    })
    @PostMapping("/thumbUpArticle")
    @LoginRequire
    public R<String> thumbUpArticle(@RequestParam String articleId, @RequestParam String userId) {
        return articleServiceImp.thumbUpArticle(articleId, userId);
    }


}
