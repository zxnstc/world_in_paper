package com.example.world_in_paper_backend.controller;


import com.example.world_in_paper_backend.annotation.LoginRequire;
import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.service.Imp.CommentServiceImp;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

import static com.example.world_in_paper_backend.bean.CodeEnum.NEED_LOGIN;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentServiceImp commentServiceImp;

    @ApiOperation(value = "获取贴子的评论", notes = "获取贴子的评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topic_id", value = "帖子的id", required = true),

    })
    @GetMapping("/getCommentList")
    public R<List<Map<String ,Object>>> getTopicCommentList(Integer topic_id) {
        return commentServiceImp.getCommentListByTopicId(topic_id,"1");
    }

    @ApiOperation(value = "对一个帖子添加评论", notes = "对一个帖子添加评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topicId", value = "帖子id", required = true),
            @ApiImplicitParam(name = "userId", value = "用id", required = true),
            @ApiImplicitParam(name = "comment", value = "评论内容", required = true)

    })
    @PostMapping("/addTopicComment")
    @LoginRequire
    public R<String> addTopicComment(@RequestParam("topicId") String topicId, @RequestParam("userId") String userId,
                                     @RequestParam("comment") String comment) {
        if(userId.equals("-1")){
            return R.error(NEED_LOGIN,"未登录");
        }
        return commentServiceImp.addComment(topicId, userId, comment,"1");
    }


}
