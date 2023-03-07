package com.example.world_in_paper_backend.mapper;

import com.example.world_in_paper_backend.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    public User getUserByUsername(String username);

    @Select("SELECT * FROM user WHERE username LIKE CONCAT('%',#{username},'%')")
    public List<User> searchUserByUsername(String username);

    @Select("SELECT * FROM user")
    public List<User> getAllUser();

    @Select("SELECT * FROM user WHERE id = #{id}")
    public User getUserById(Integer id);

    @Insert("INSERT INTO user (username,password,email,role_id) VALUES (#{username},#{password},#{email},0)")
    public Integer register(String username, String password, String email);

    @Update("UPDATE user SET avatar=#{avatar},introduction=#{introduction} WHERE id=#{id}")
    public Integer updateUserInfo(String id, String avatar, String introduction);

    @Update("UPDATE user SET introduction=#{introduction} WHERE id=#{id}")
    public Integer updateUserIntroduction(String id, String introduction);

    @Update("UPDATE user SET avatar=#{avatar} WHERE id=#{id}")
    public Integer updateUserAvatar(String id, String avatar);

    @Update("UPDATE user SET state = 1  WHERE id=#{id}")
    Integer disableUser(String id);

    @Update("UPDATE user SET state = 0  WHERE id=#{id}")
    Integer enableUser(String id);

    @Update("UPDATE user SET role_id = #{roleId} WHERE id=#{userId}")
    Integer updateUserRole(String userId, String roleId);
}
