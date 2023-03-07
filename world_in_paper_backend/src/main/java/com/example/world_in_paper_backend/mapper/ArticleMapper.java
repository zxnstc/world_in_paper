package com.example.world_in_paper_backend.mapper;


import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Component
@Repository
public interface ArticleMapper {

    @Select("SELECT * FROM article WHERE id = #{articleId}")
    public Map<String,Object> getArticleById(Integer articleId);
    @Insert("INSERT INTO article (title,content,creator_id,column_id,cover_img,create_time,status) VALUES (#{title},#{content},#{creatorId},#{columnId},#{coverImg},NOW(),\"1\")")
    public Integer addArticle(String title, String content, Integer creatorId, Integer columnId,String coverImg);
    @Update("UPDATE article SET visit_count = visit_count+1 WHERE id=#{articleId}")
    public Integer addVisitCount(Integer articleId);

    @Select("SELECT * FROM article WHERE  creator_id= #{kayUserId} order by create_time desc")
    public List<Map<String,Object>> getArticleByUserId(Integer keyUserId);

    @Delete("DELETE FROM article WHERE id = #{articleId}")
    Integer deleteArticleById(Integer articleId);
}
