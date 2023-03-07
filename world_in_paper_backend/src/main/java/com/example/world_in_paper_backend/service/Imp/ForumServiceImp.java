package com.example.world_in_paper_backend.service.Imp;

import com.example.world_in_paper_backend.bean.Comment;
import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.bean.Topic;
import com.example.world_in_paper_backend.bean.User;
import com.example.world_in_paper_backend.mapper.ForumMapper;
import com.example.world_in_paper_backend.mapper.UserMapper;
import com.example.world_in_paper_backend.service.ForumService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ForumServiceImp implements ForumService {

    @Autowired
    private ForumMapper forumMapper;


    @Autowired
    private ThumbServiceImp thumbServiceImp;

    @Autowired
    private CommentServiceImp commentServiceImp;

    @Autowired
    private UserServiceImp userServiceImp;


    @Override
    public R<Map<String, Object>> getTopicDetail(String id) {
        Map<String, Object> t = forumMapper.getTopicById(id);
        if (t == null) {
            return R.error("帖子不存在");
        }
        forumMapper.addVisitCount(id);
        Date create_time = (Date) t.get("create_time");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        t.put("create_time",simpleDateFormat.format(create_time));
        User u = userServiceImp.getUserById(t.get("creator_id").toString());
        t.put("topic_user_username", u.getUsername());
        t.put("topic_user_avatar", u.getAvatar());
        t.put("topic_user_id", u.getId());
        t.put("topic_user_email", u.getEmail());
        t.put("topic_user_introduction", u.getIntroduction());
        t.put("topic_user_rank", u.getRank());
        return R.success(t);
    }


    @Override
    public R<ArrayList<Map<String,Object>>> getTopicList(Integer currentPage, Integer pageSize,String userId) {
        PageHelper.startPage(currentPage,pageSize);

        ArrayList<Map<String,Object>> topicList =forumMapper.getTopicList();
        Integer total = forumMapper.getTopicCount();
        for (Map<String,Object> topic:topicList) {
            Date create_time = (Date) topic.get("create_time");
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            topic.put("create_time",simpleDateFormat.format(create_time));
            Integer topicId = (Integer) topic.get("id");
            Integer commentCount = commentServiceImp.getCommentCountByTopicId(topicId,"1");
            Integer thumbsCount = thumbServiceImp.getThumbsCountByTopicId(topicId,"1");
            Integer isThumbs = thumbServiceImp.isThumbs(String.valueOf(topicId),userId,"1");
            boolean isThumbsBoolean = false;
            if(isThumbs==1){
                isThumbsBoolean = true;
            }
            topic.put("commentCount",commentCount);
            topic.put("thumbsCount",thumbsCount);
            topic.put("topicTotal",total);
            topic.put("isThumbs",isThumbsBoolean);
        }

        return R.success(topicList);
    }

    @Override
    public R<ArrayList<Map<String,Object>>> searchTopic(String keyword,String userId) {
        ArrayList<Map<String,Object>> topicList = forumMapper.searchTopic(keyword);
        for (Map<String,Object> topic:topicList) {
            Integer topicId = (Integer) topic.get("id");
            Integer commentCount = commentServiceImp.getCommentCountByTopicId(topicId,"1");
            Integer thumbsCount = thumbServiceImp.getThumbsCountByTopicId(topicId,"1");
            Integer isThumbs = thumbServiceImp.isThumbs(String.valueOf(topicId),userId,"1");
            boolean isThumbsBoolean = false;
            if(isThumbs==1){
                isThumbsBoolean = true;
            }
            topic.put("commentCount",commentCount);
            topic.put("thumbsCount",thumbsCount);
            topic.put("isThumbs",isThumbsBoolean);
        }
        return R.success(topicList);
    }



    @Override
    public R<ArrayList<Comment>> getTopicComment(String topicId) {
        ArrayList<Comment> commentList = forumMapper.getTopicCommentById(Integer.valueOf(topicId));
        if (commentList == null) {
            return R.error("没有相关评论");
        } else {
            return R.success(commentList);
        }
    }


    @Override
    public R<String> likeTopic(String topicId, String userId) {
        //不可以重复点赞
        if (thumbServiceImp.isThumbs(topicId,userId,"1") == 1) {
            return R.error("已经点过赞了");
        } else {
            Integer i = thumbServiceImp.addThumbs(topicId,userId,"1");
            if (i == 1) {
                return R.success("点赞成功");
            } else {
                return R.error("点赞失败");
            }
        }

    }

    @Override
    public R<String> addTopicComment(String topicId, String content, String userId) {

        Integer i =  forumMapper.addTopicComment(topicId,content,userId);
        if (i == 1) {
            return R.success("评论成功");
        } else {
            return R.error("评论失败");
        }

    }

    @Override
    public R<ArrayList<Map<String, Object>>> getTopAuthorList() {
        if (forumMapper.getTopAuthorList() == null) {
            return R.error("没有相关数据");
        } else {
            return R.success(forumMapper.getTopAuthorList());
        }

    }


    @Override
    public R<String> addTopic(String title, String content, String userId) {
        return forumMapper.addTopic(title,content,userId) == 1 ? R.success("发帖成功") : R.error("发帖失败");
    }

    @Override
    public R<String> deleteTopic(String topicId) {
        return forumMapper.deleteTopic(topicId) == 1 ? R.success("删除成功") : R.error("删除失败");
    }

    @Override
    public R<Map<String, Object>> getAllCommentCount() {
        Integer allCommentCount = forumMapper.getAllCommentCount();
        Map<String, Object> map = new HashMap<>();
        map.put("all_comment_count",allCommentCount);
        return R.success(map);
    }

    @Override
    public R<Map<String, Object>> getAllVisitCount() {
        Integer allVisitCount = forumMapper.getAllVisitCount();
        Map<String, Object> map = new HashMap<>();
        map.put("all_visit_count",allVisitCount);
        return R.success(map);
    }


    @Override
    public R<ArrayList<Map<String, Object>>> searchTopicByUserId(String keyUserId, String userId) {
        ArrayList<Map<String,Object>> topicList = forumMapper.getTopicByUserId(Integer.valueOf(keyUserId));
        for (Map<String,Object> topic:topicList) {
            Integer topicId = (Integer) topic.get("id");
            Date create_time = (Date) topic.get("create_time");
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            topic.put("create_time",simpleDateFormat.format(create_time));
            Integer commentCount = commentServiceImp.getCommentCountByTopicId(topicId,"1");
            Integer thumbsCount = thumbServiceImp.getThumbsCountByTopicId(topicId,"1");
            Integer isThumbs = thumbServiceImp.isThumbs(String.valueOf(topicId),userId,"1");
            boolean isThumbsBoolean = false;
            if(isThumbs==1){
                isThumbsBoolean = true;
            }
            topic.put("commentCount",commentCount);
            topic.put("thumbsCount",thumbsCount);
            topic.put("isThumbs",isThumbsBoolean);
        }
        return R.success(topicList);
    }

    @Override
    public R<String> deleteTopicById(String topicId) {
        return forumMapper.deleteTopicById(topicId) == 1 ? R.success("删除成功") : R.error("删除失败");
    }
}
