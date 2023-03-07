package com.example.world_in_paper_backend.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Mapper
@Component
public interface PaperworkMapper {
    @Select("SELECT * from art order by id desc")
    public ArrayList<Map<String, Object>> getPaperwork();

    @Insert("INSERT INTO art (title, author_id, create_time, content, img_url) VALUES (#{title}, #{author_id}, NOW(),#{content}, #{img_url})")
    public void uploadPaperwork(String title, Integer author_id, String content, String img_url);

    @Insert("INSERT INTO art (title, author_id, create_time, content, img_url,  background_color) VALUES (#{title}, #{author_id}, NOW(),#{content}, #{img_url}, #{background_color})")
    public void uploadPaperworkWithColor(String title, Integer author_id, String img_url, String content, String background_color);

    @Insert("INSERT INTO art (title, author_id, create_time, content, img_url, background_url) VALUES (#{title}, #{author_id}, NOW(),#{content}, #{img_url}, #{background_url})")
    public void uploadPaperworkWithImage(String title, Integer author_id, String img_url, String content, String background_url);

    @Select("SELECT * from art where author_id = #{id} ORDER BY id DESC")
    public ArrayList<Map<String, Object>> getPaperworkByAuthorId(Integer id);

    @Select("SELECT * from art where id = #{id}")
    public ArrayList<Map<String, Object>> getPaperworkById(Integer id);

    @Select("DELETE from art where id = #{id}")
    public ArrayList<Map<String, Object>> deletePaperworkById(Integer id);
}
