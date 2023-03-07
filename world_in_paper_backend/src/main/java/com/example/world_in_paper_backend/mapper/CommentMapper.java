package com.example.world_in_paper_backend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface CommentMapper {

    @Select("SELECT COUNT(*) FROM comment WHERE comment_topic_id = #{topicId} AND type = #{type}")
    public Integer getCommentCountByTopicId(Integer topicId,String type);


    @Select("SELECT * FROM comment WHERE comment_topic_id = #{topicId} AND type = #{type}")
    public List<Map<String,Object>> getCommentListByTopicId(Integer topicId, String type);


    @Insert("INSERT INTO comment (comment_topic_id,comment_user_id,content,type,comment_time,floor_count) VALUES (#{topicId},#{userId},#{content},#{type},NOW(),0)")
    Integer addComment(Integer topicId, Integer userId, String content, String type);
}
