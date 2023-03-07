package com.example.world_in_paper_backend.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Component
@Repository
public interface ColumnMapper {
    //获取所有专栏
    @Select("SELECT * FROM column_table")
    public List<Map<String,Object>> getAllColumns();

    @Select("SELECT COUNT(*) FROM favor WHERE work_id = #{columnId} AND type = \"0\"")
    public Integer getColumnFavorCountByColumnId(String columnIdString);

    @Select("SELECT COUNT(*) FROM article WHERE column_id = #{columnId}")
    public Integer getColumnArtCountByColumnId(String columnIdString);

    @Select("SELECT label_name, id FROM label WHERE id IN (SELECT label_id FROM art_label WHERE art_id IN (SELECT id FROM article WHERE column_id = #{columnId}))")
    public List<Map<String,Object>> getColumnLabels(Integer ColumnId);

    @Select("SELECT * FROM article WHERE column_id = #{columnId} ORDER BY create_time DESC")
    public List<Map<String,Object>> getColumnArticles(Integer ColumnId);

    @Select("SELECT title FROM column_table WHERE id = #{columnId}")
    public String getColumnTitleByColumnId(Integer ColumnId);

    @Insert("INSERT INTO column_table (title,content,creator_id,cover_img,create_time) VALUES (#{title},#{content},#{userId},#{coverImg},NOW())")
    public Integer addColumn(Integer userId,String title, String content,  String coverImg);

    @Select("SELECT * FROM column_table WHERE id = #{columnId}")
    Map<String, Object> getColumn(String columnId);


    @Select("SELECT * FROM column_table WHERE creator_id = #{userId} ORDER BY create_time DESC")

    List<Map<String, Object>> getColumnByUserId(Integer userId);

    @Delete("DELETE FROM column_table WHERE id = #{id}")
    void deleteColumn(Integer id);
}
