package com.example.world_in_paper_backend.service;

import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.bean.User;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {
    public R<Map<String, String>> login(String username, String password, HttpSession session);

    public R<String> register(String username, String password, String email, String vCode);

    public R<String> sendMail(String email, String subject, String body);

    public User getUserById(String id);

    public R<User> updateUserInfo(String id, String avatar, String introduction);

    public R<String> disableUser(String id);

    R<String> updateUserRole(String userId, String roleId);

    R<Map<String,Object>> keepSession(HttpSession session);

    R<List<User>> getUserList(String username);

    R<String> enableUser(String id);

    R<String> logout(HttpSession session);
}
