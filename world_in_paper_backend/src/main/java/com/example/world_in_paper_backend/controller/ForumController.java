package com.example.world_in_paper_backend.controller;

import com.example.world_in_paper_backend.annotation.LoginRequire;
import com.example.world_in_paper_backend.bean.Comment;
import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.bean.Topic;
import com.example.world_in_paper_backend.bean.User;
import com.example.world_in_paper_backend.service.Imp.ForumServiceImp;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

import static com.example.world_in_paper_backend.bean.CodeEnum.NEED_LOGIN;

@RequestMapping("/forum")
@RestController
@Slf4j
public class ForumController {

    @Autowired
    private ForumServiceImp forumServiceImp;

    @ApiOperation(value = "获取所有的帖子", notes = "获取所有的帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "现在的页面", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页面size", required = true),
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true)
    })
    @GetMapping("/getTopicList")
    public R<ArrayList<Map<String,Object>>> getTopicList(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize, @RequestParam("userId") String userId) {
        return forumServiceImp.getTopicList(currentPage,pageSize,userId);
    }

    @ApiOperation(value = "获取帖子详情", notes = "获取帖子详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topicId", value = "帖子id", required = true),
    })
    @GetMapping("/getTopicDetail")
    public R<Map<String, Object>> getTopicDetail(@RequestParam("topicId") String topicId) {

        return forumServiceImp.getTopicDetail(topicId);
    }

    @ApiOperation(value = "根据关键字搜索帖子", notes = "根据关键字搜索帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "关键字", required = true),
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true),
    })
    @GetMapping("/searchTopicByKeyword")
    public R<ArrayList<Map<String,Object>>> searchTopicByKeyword(@RequestParam("keyword") String keyword, @RequestParam("userId") String userId) {

        return forumServiceImp.searchTopic(keyword,userId);
    }


    @ApiOperation(value = "根据userId搜索帖子", notes = "根据userId搜索帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyUserId", value = "目标userId", required = true),
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true),
    })
    @GetMapping("/searchTopicByUserId")
    public R<ArrayList<Map<String,Object>>> searchTopicByUserId(@RequestParam("keyUserId") String keyUserId, @RequestParam("userId") String userId) {

        return forumServiceImp.searchTopicByUserId(keyUserId,userId);
    }

    @ApiOperation(value = "对一个帖子点赞", notes = "对一个帖子点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topicId", value = "帖子id", required = true),
            @ApiImplicitParam(name = "userId", value = "用户id", required = true)
    })
    @PostMapping("/likeTopic")
    @LoginRequire
    public R<String> likeTopic(@RequestParam("topicId") String topicId,@RequestParam("userId") String userId) {

        if(userId.equals("-1")){
            return R.error(NEED_LOGIN,"未登录");
        }
        return forumServiceImp.likeTopic(topicId,userId);
    }

    @ApiOperation(value = "对一个帖子删除", notes = "对一个帖子删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topicId", value = "帖子id", required = true)
    })
    @DeleteMapping("/deleteTopic")
    @LoginRequire
    public R<String> deleteTopicById(@RequestParam("topicId") String topicId) {

        return forumServiceImp.deleteTopicById(topicId);
    }

    @ApiOperation(value = "获取作者榜", notes = "获取作者榜")
    @GetMapping("/getTopAuthorList")
    public R<ArrayList<Map<String, Object>>> getTopAuthorList() {
        return forumServiceImp.getTopAuthorList();
    }


    @ApiOperation(value = "添加一个帖子", notes = "添加一个帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "标题", required = true),
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true),
            @ApiImplicitParam(name = "content", value = "内容", required = true),
    })
    @PostMapping("/addTopic")
    @LoginRequire
    public R<String> addTopic(@RequestParam("title") String title,@RequestParam("userId") String userId,@RequestParam("content") String content) {
        log.info("title:"+title);
        if(userId.equals("-1")){
            return R.error(NEED_LOGIN,"未登录");
        }
        return forumServiceImp.addTopic(title,content,userId);
    }

    @ApiOperation(value = "获取论坛所有的评论数量", notes = "获取论坛所有的评论数量")
    @ApiImplicitParams({
    })
    @GetMapping("/getCommentCount")
    public R<Map<String,Object>> getAllCommentCount() {
        return forumServiceImp.getAllCommentCount();
    }

    @ApiOperation(value = "获取论坛所有的访客数量", notes = "获取论坛所有的访客数量")
    @ApiImplicitParams({
    })
    @GetMapping("/getVisitCount")
    public R<Map<String,Object>> getAllVisitCount() {
        return forumServiceImp.getAllVisitCount();
    }






}
