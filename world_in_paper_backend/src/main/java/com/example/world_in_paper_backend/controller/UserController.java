package com.example.world_in_paper_backend.controller;

import com.example.world_in_paper_backend.annotation.LoginRequire;
import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.bean.User;
import com.example.world_in_paper_backend.utils.VCodeUtill;
import com.example.world_in_paper_backend.service.Imp.UserServiceImp;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;


    @ApiOperation(value = "用户登陆", notes = "用户登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),

    })

    @PostMapping("/login")
    public R<Map<String,String>> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        return userServiceImp.login(username, password,session);
    }


    @ApiOperation(value = "发送验证码", notes = "发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true),
    })
    @PostMapping("/sendMail")
    public R<String> sendMail(@RequestParam("email") String email) {
        String vCode = VCodeUtill.verifyCode(6);
        return userServiceImp.sendMail(email, "验证码", vCode);
    }

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true),
            @ApiImplicitParam(name = "code", value = "验证码", required = true),

    })
    @PostMapping("register")
    public R<String> register(@RequestParam("username") String username, @RequestParam("password") String password,
                              @RequestParam("email") String email, @RequestParam("code") String code) {

        return userServiceImp.register(username, password, email,code);
    }
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true),
            @ApiImplicitParam(name = "avatar", value = "头像"),
            @ApiImplicitParam(name = "introduction", value = "个性签名"),

    })
    @PostMapping("/updateUserInfo")
    @LoginRequire
    public R<User> updateUserInfo(@RequestParam("id") String id,
                                    @RequestParam(value="avatar" ,required = false) String avatar,
                                    @RequestParam(value="introduction",required=false) String introduction) {

        return userServiceImp.updateUserInfo(id,avatar,introduction);
    }

    @ApiOperation(value = "禁用用户", notes = "禁用用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true)
    })
    @PostMapping("/disableUser")
    public R<String> disableUser(@RequestParam("id") String id) {

        return userServiceImp.disableUser(id);
    }

    @ApiOperation(value = "解禁用户", notes = "解禁用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true)
    })
    @PostMapping("/enableUser")
    @LoginRequire
    public R<String> enableUser(@RequestParam("id") String id) {

        return userServiceImp.enableUser(id);
    }

    @ApiOperation(value = "修改用户角色", notes = "修改用户角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true),
            @ApiImplicitParam(name = "roleId", value = "角色Id", required = true)
    })
    @PostMapping("/updateUserRole")
    @LoginRequire
    public R<String> updateUserRole(@RequestParam("id") String id, @RequestParam("roleId") String roleId) {

        return userServiceImp.updateUserRole(id, roleId);
    }
    //会话保持
    @ApiOperation(value = "会话保持", notes = "会话保持")
    @PostMapping("/keepSession")
    public R<Map<String,Object>> keepSession(HttpSession session){
        return userServiceImp.keepSession(session);
    }

    //获取用户列表
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = false),
    })
    @GetMapping("/getUserList")
    public R<List<User>> getUserList(@RequestParam(required = false) String username) {

        return userServiceImp.getUserList(username);
    }

    @ApiOperation(value = "退出登录", notes = "退出登录")
    @ApiImplicitParams({
    })
    @GetMapping("/logout")
    public R<String> logout(HttpSession session) {
        return userServiceImp.logout(session);
    }














}
