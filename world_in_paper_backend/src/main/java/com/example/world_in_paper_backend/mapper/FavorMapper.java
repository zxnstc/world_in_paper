package com.example.world_in_paper_backend.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorMapper {

    //添加收藏
    @Insert("INSERT INTO favor (work_id,type,user_id) VALUES (#{workId},#{workType},#{userId})")
    public Integer addFavor(Integer workId, Integer userId, String workType);

    //删除收藏
    @Insert("DELETE FROM favor WHERE work_id = #{workId} AND user_id = #{userId} AND type = #{workType}")
    public Integer deleteFavor(Integer workId, Integer userId, String workType);


    @Select("SELECT COUNT(*) FROM favor WHERE work_id = #{workId} AND type = #{workType} AND user_id = #{userId}")
    public Integer isFavor(Integer workId, Integer userId, String workType);
}
