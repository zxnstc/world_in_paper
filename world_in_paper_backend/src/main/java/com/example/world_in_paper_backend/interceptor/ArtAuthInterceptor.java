package com.example.world_in_paper_backend.interceptor;

import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.bean.User;
import com.example.world_in_paper_backend.service.Imp.UserServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.world_in_paper_backend.bean.CodeEnum.NEED_LOGIN;

public class ArtAuthInterceptor implements HandlerInterceptor {
    @Autowired
    private UserServiceImp userServiceImpl;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            authFailOutput(response, "登录信息不存在，请重新登录");
            return false;
        }

        User u = userServiceImpl.getUserById(userId);
        if (u == null) {
            authFailOutput(response, "登录信息不存在，请重新登录");
            return false;
        }else{
            if(u.getRoleId()==2){
                return true;
            }else{
                authFailOutput(response, "您不是艺术家，无法访问");
                return false;
            }
        }

    }

    private void authFailOutput(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(R.error(NEED_LOGIN, msg)));
        out.flush();
    }
}
