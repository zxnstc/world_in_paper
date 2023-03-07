package com.example.world_in_paper_backend.service.Imp;

import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.bean.User;
import com.example.world_in_paper_backend.mapper.CommentMapper;
import com.example.world_in_paper_backend.mapper.ThumbMapper;
import com.example.world_in_paper_backend.mapper.UserMapper;
import com.example.world_in_paper_backend.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CommentServiceImp implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ThumbMapper thumbMapper;
    @Override
    public Integer getCommentCountByTopicId(Integer TopicId,String type) {
        return commentMapper.getCommentCountByTopicId(TopicId,type);
    }

    @Override
    public R<List<Map<String, Object>>> getCommentListByTopicId(Integer TopicId, String type) {
        List<Map<String, Object>> commentList = commentMapper.getCommentListByTopicId(TopicId, type);
        if(commentList.size()==0){
            return R.success("没有评论");
        }
        for (Map<String, Object> comment : commentList) {
            Integer commentId = (Integer) comment.get("comment_user_id");
            log.info("u_id"+ commentId);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            comment.put("comment_time",simpleDateFormat.format(comment.get("comment_time")));
            User u = userMapper.getUserById(commentId);
            Integer thumbsCount = thumbMapper.getThumbsCountByTopicId(commentId, "2");
            if(u!=null) {
                comment.put("comment_user_name", u.getUsername());
                comment.put("comment_user_avatar", u.getAvatar());
                comment.put("comment_user_rank", u.getRank());
                comment.put("thumbsCount", thumbsCount);
            }
        }

        return R.success(commentList);
    }

    @Override
    public R<String> addComment(String topicId, String userId, String content, String type) {
        Integer result = commentMapper.addComment(Integer.valueOf(topicId), Integer.valueOf(userId), content, type);
        if (result == 1) {
            return R.success("评论成功");
        } else {
            return R.error("评论失败");
        }

    }
}

